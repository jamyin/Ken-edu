package com.ssic.education.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.education.app.interceptor.AccessRequired;
import com.ssic.education.app.service.ICommitteeService;
import com.ssic.education.app.service.IInformationService;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.StringUtils;

/**
 * @ClassName: InformationController
 * @Description: 资讯controller (1:公告 2:卫生检查 3:健康宣教)  
 * @author Ken Yin
 * @date 2016年5月20日 上午10:41:26
 *
 */
@Controller
@RequestMapping(value = "information")
public class InformationController {
	protected static final Log logger = LogFactory.getLog(InformationController.class);

	@Autowired
	private IInformationService informationService;

	@Autowired
	private EduSchoolService eduSchoolService;

	@Autowired
	private ICommitteeService committeeService;

	/**
	 * @Title: findInformationList
	 * @Description: 查询全部公告列表
	 * @author Ken Yin  
	 * @date 2016年5月20日 上午10:26:05
	 * @return Response<PageResult<EduInformationDto>>    返回类型
	 */
	@AccessRequired
	@RequestMapping("/findInformationList")
	@ResponseBody
	public Response<PageResult<EduInformationDto>>  findInformationList(EduInformationDto eduInformationDto, PageQuery query) {
		logger.info("EduInformationDto : " + eduInformationDto + ";PageQuery : " + query );
		Response<PageResult<EduInformationDto>> result = new Response<PageResult<EduInformationDto>>();
		if(eduInformationDto.getSourceType() == null){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("传入的sourceType为空");
			return result;  		
		}
		if(eduInformationDto.getSourceId() == null){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("传入的sourceId为空");
			return result;  		
		}
		PageResult<EduInformationDto> informationList = new PageResult<EduInformationDto>();
		//当前用户是市教委的话可以看到所有
		if(eduInformationDto.getSourceType() == 0){
			informationList = informationService.findInformationList(eduInformationDto, query);
		}
		//区教委--看自己发的和市教委发的
		else if(eduInformationDto.getSourceType() == 2){
			List<String> commList = new ArrayList<String>();
			//查询市教委Id
			EduCommitteeDto eduCommitteeDto = new EduCommitteeDto();
			eduCommitteeDto.setType(DataStatus.SHORT_ENABLED);       //市教委
			List<EduCommitteeDto> comm = committeeService.findCommitteeListNoPage(eduCommitteeDto);
			String commId = "";
			if(comm != null && comm.size() >0){
				commId = comm.get(0).getId();
			}
			commList.add(commId);
			commList.add(eduInformationDto.getSourceId());
			eduInformationDto.setSourceIds(commList);
			informationList = informationService.findInformationList(eduInformationDto, query);
		}else{
			//学校能查看市教委和对应区教委发的 sourceId == 1
			List<String> commList = new ArrayList<String>();
			//查询市教委Id
			EduCommitteeDto eduCommitteeDto = new EduCommitteeDto();
			eduCommitteeDto.setType(DataStatus.SHORT_ENABLED);       //市教委
			List<EduCommitteeDto> comm = committeeService.findCommitteeListNoPage(eduCommitteeDto);
			String commId = "";
			if(comm != null && comm.size() >0){
				commId = comm.get(0).getId();
			}
			//查看对应区教委的id
			EduSchoolDto eduSchoolDto = eduSchoolService.findById (eduInformationDto.getSourceId().toString());
			String commId_ = "";
			if(eduSchoolDto != null){
				commId_ = eduSchoolDto.getCommitteeId();
			}
			commList.add(commId);
			commList.add(commId_);
			eduInformationDto.setSourceIds(commList);
			informationList = informationService.findInformationList(eduInformationDto, query);

		}
		if(informationList == null){
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("未查到相关记录");
			return result;
		}
		result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setData(informationList);
		result.setMessage("查询成功");
		return result;
	}

	/**
	 * @Title: findInformationDetialList
	 * @Description: 根据公告id查公告详细信息
	 * @author Ken Yin  
	 * @date 2016年5月20日 上午10:29:45
	 * @return Response<PageResult<EduInformationDto>>    返回类型
	 */
	@AccessRequired
	@RequestMapping("/findInformationDetial/{id}")
	@ResponseBody
	public Response<EduInformationDto> findInformationDetial(@PathVariable("id")String id) {
		logger.info("id : " + id );
		Response<EduInformationDto> result = new Response<EduInformationDto>();
		if(StringUtils.isEmpty(id)){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("查询Id为空");
			return result;
		}
		EduInformationDto dto = informationService.findInformationDetial(id);
		if(dto != null){
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(dto);
			return result;
		}else{
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("未查到相关记录！");
			return result;
		}
	}
}


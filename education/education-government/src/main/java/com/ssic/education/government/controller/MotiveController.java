package com.ssic.education.government.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.educateion.common.dto.EduInformationListDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.IEduCommitteeService;
import com.ssic.education.handle.service.IEduInformationListService;
import com.ssic.education.handle.service.IEduInformationService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.UUIDGenerator;

@Controller
@RequestMapping(value = "motive")
public class MotiveController extends BaseController {

	@Autowired
	private IEduCommitteeService iEduCommitteeService;

	@Autowired
	private EduSchoolService eduSchoolService;

	@Autowired
	private IEduInformationService iEduInformationService;
	
	@Autowired
	private IEduInformationListService iEduInformationListService;
	
	
	/**
	 * 
		 * 此方法描述的是：异步删除
		 * @author: cwftalus@163.com
		 * @version: 2016年5月30日 下午7:06:52
	 */
	@RequestMapping(value="ajaxDelete")
	@ResponseBody
	public Response<String> ajaxDelete(EduInformationListDto eduInformationListDto){
		Response<String> response = new Response<String>();

		int result = iEduInformationListService.updateEduInformationList(eduInformationListDto);
		
		return response;
	}
	
	/**
	 * 
		 * 此方法描述的是：查询联系人列表异步
		 * @author: cwftalus@163.com
		 * @version: 2016年5月30日 下午7:06:52
	 */
	@RequestMapping(value="ajaxSearch")
	@ResponseBody
	public Response<List<InfoList>> ajaxSearch(String name){
		Response<List<InfoList>> response = new Response<List<InfoList>>();
		List<InfoList> dataList = new ArrayList<MotiveController.InfoList>();
		if (Objects.equal(getEduUsersDto().getSourceType(), Byte.valueOf("0"))) {// 查询市教委下的区教委信息
			EduCommitteeDto eduCommitteeDto = new EduCommitteeDto();
			eduCommitteeDto.setType(Short.valueOf("2"));
			eduCommitteeDto.setName(name);
			List<EduCommitteeDto> resultList = iEduCommitteeService.queryCommittee(eduCommitteeDto);
			if(resultList!=null && resultList.size()>0){
				dataList = copyProperty(resultList);	
			}
		} else if (Objects.equal(getEduUsersDto().getSourceType(),Byte.valueOf("2"))) {// 查询区县教委下的学校信息
			EduSchoolDto eduSchoolDto = new EduSchoolDto();
			eduSchoolDto.setCommitteeId(getEduUsersDto().getSourceId());
			eduSchoolDto.setSchoolName(name);
			List<EduSchoolDto> resultList = eduSchoolService.searchEduScholDtoList(eduSchoolDto);
			if(resultList!=null && resultList.size()>0){
				dataList = copyProperty(resultList);	
			}
		}
		response.setData(dataList);
		return response;
	}
	
	/**
	 * 
	 * 此方法描述的是：发布
	 * 市教委  新建 0
	 * 区教委  新建 未读 已读 已发 2
	 * 学校 未读 已读 1
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:41:57
	 */
	@RequestMapping(value = "release")
	public ModelAndView index() {
		ModelAndView mv = getModelAndView();

		// 0市教委，1学校, 2区教委
		List<InfoList> dataList = new ArrayList<MotiveController.InfoList>();
		if (Objects.equal(getEduUsersDto(),null)) {// 查询市教委下的区教委信息
			return new ModelAndView("redirect:/login.htm");
		}
		if (Objects.equal(getEduUsersDto().getSourceType(), Byte.valueOf("0"))) {// 查询市教委下的区教委信息
			EduCommitteeDto eduCommitteeDto = new EduCommitteeDto();
			eduCommitteeDto.setType(Short.valueOf("2"));
			List<EduCommitteeDto> resultList = iEduCommitteeService.queryCommittee(eduCommitteeDto);
			dataList = copyProperty(resultList);
		} else if (Objects.equal(getEduUsersDto().getSourceType(),
				Byte.valueOf("2"))) {// 查询区县教委下的学校信息
			EduSchoolDto eduSchoolDto = new EduSchoolDto();
			eduSchoolDto.setCommitteeId(getEduUsersDto().getSourceId());
			List<EduSchoolDto> resultList = eduSchoolService.searchEduScholDtoList(eduSchoolDto);
			dataList = copyProperty(resultList);
		}else{
			
		}
		
		getSourceType(mv);
		
		mv.addObject("dataList", dataList);
		mv.setViewName("motive/dis_edu_motive_release");
		return mv;
	}
	
	
	public void getSourceType(ModelAndView mv){
		if(getEduUsersDto()!=null){
			mv.addObject("sourceType", getEduUsersDto().getSourceType());	
		}
		
	}

	/**
	 * 
	 * 此方法描述的是：发布 -->保存
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:03
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public Response<String> save(EduInformationDto eduInformationDto) {
		Response<String> response = new Response<String>();
		eduInformationDto.setContent(eduInformationDto.getEditorValue());
		String infoId = UUIDGenerator.getUUID32Bit();
		eduInformationDto.setId(infoId);
		eduInformationDto.setCreateAdminId(getSessionUserId());
		eduInformationDto.setCreateAdminName(getEduUsersDto().getName());
		int result = iEduInformationService.saveInfomation(eduInformationDto);
		if (!(result > 0)) {
			response.setStatus(DataStatus.HTTP_FAILE);
		} else {
			// String lianxiIds = getRequest().getParameter("lianxiIds");
			List<EduInformationListDto> dataList = copyList(eduInformationDto);
			if (dataList != null) {
				iEduInformationListService.saveList(dataList);
			}
		}
		return response;
	}

	public List<EduInformationListDto> copyList(EduInformationDto eduInformationDto) {
		List<EduInformationListDto> dList = null;
		// if(!StringUtils.isNotEmpty(lianxiIds)){
		String[] lianxiId = getRequest().getParameterValues("lianxiIds");
		dList = new ArrayList<EduInformationListDto>();
		for (String lxId : lianxiId) {
			String[] idName = lxId.split("#");
			EduInformationListDto dto = new EduInformationListDto();
			dto.setInfomationId(eduInformationDto.getId());
			dto.setInfoTitle(eduInformationDto.getTitle());
			dto.setCreateId(getSessionUserId());
			dto.setSourceId(idName[0]);
			dto.setSourceName(idName[1]);
			dList.add(dto);
		}
		// }
		return dList;
	}

	/**
	 * 
	 * 此方法描述的是：未读
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value = "unreaded")
	public ModelAndView unreaded(EduInformationListDto eduInformationListDto,PageQuery pageQuery) {
		ModelAndView mv = getModelAndView();

		String sourceId = getEduUsersDto().getSourceId();//用户所属教委 或学校
		eduInformationListDto.setSourceId(sourceId);
		PageResult<EduInformationListDto> pageList = iEduInformationListService
				.searchEduInformationList(eduInformationListDto,pageQuery);
		
		getSourceType(mv);
		mv.addObject("pageList", pageList);
		mv.setViewName("motive/dis_edu_motive_unreaded");
		return mv;
	}

	/**
	 * 
	 * 此方法描述的是：发送的
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value = "sended")
	public ModelAndView sended(EduInformationListDto eduInformationListDto,PageQuery pageQuery) {
		ModelAndView mv = getModelAndView();

		eduInformationListDto.setCreateId(getSessionUserId());
		PageResult<EduInformationListDto> pageList = iEduInformationListService
				.searchEduInformationList(eduInformationListDto,pageQuery);
		getSourceType(mv);
		mv.addObject("pageList", pageList);
		mv.setViewName("motive/dis_edu_motive_sended");
		return mv;
	}

	/**
	 * 
	 * 此方法描述的是：发送的
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value = "readed")
	public ModelAndView readed() {
		ModelAndView mv = getModelAndView();
		getSourceType(mv);
		mv.setViewName("motive/dis_edu_motive_readed");
		return mv;
	}

	/**
	 * 
	 * 此方法描述的是：infomation 详情信息
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value = "details/{infoId}")
	public ModelAndView details(@PathVariable String infoId) {
		ModelAndView mv = getModelAndView();

		EduInformationDto data = iEduInformationService.search(infoId);

		mv.addObject("data", data);
		mv.setViewName("motive/dis_edu_motice_detail");
		return mv;
	}

	public List<InfoList> copyProperty(Object xObj) {
		List<InfoList> infoList = new ArrayList<MotiveController.InfoList>();
		if (xObj instanceof List<?>) {
			if (((List<?>) xObj).get(0) instanceof EduCommitteeDto) {
				List<EduCommitteeDto> dataList = (List<EduCommitteeDto>) xObj;
				for (EduCommitteeDto obj : dataList) {
					InfoList e = new InfoList();
					e.setId(obj.getId());
					e.setName(obj.getName());
					infoList.add(e);
				}
			} else if (((List<?>) xObj).get(0) instanceof EduSchoolDto) {
				List<EduSchoolDto> dataList = (List<EduSchoolDto>) xObj;
				for (EduSchoolDto obj : dataList) {
					InfoList e = new InfoList();
					e.setId(obj.getId());
					e.setName(obj.getSchoolName());
					infoList.add(e);
				}
			}
		}
		return infoList;
	}

	@Data
	public class InfoList implements Serializable {
		private String id;
		private String name;

	}

}

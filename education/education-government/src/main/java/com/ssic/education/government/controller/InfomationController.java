package com.ssic.education.government.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.IEduCommitteeService;
import com.ssic.education.handle.service.IEduInformationService;
import com.ssic.education.handle.service.ITaskReceiveService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.UUIDGenerator;

@Controller
@RequestMapping(value = "info")
public class InfomationController extends BaseController {
	
	@Autowired
	private IEduInformationService iEduInformationService;

	@Autowired
	private IEduCommitteeService iEduCommitteeService;

	@Autowired
	private EduSchoolService eduSchoolService;

	@Autowired
	private ITaskReceiveService iEduInformationListService;

	/**
	 * 
	 * 此方法描述的是：发布
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:41:57
	 */
	@RequestMapping(value = "index/{type}")
	public ModelAndView index(@PathVariable String type,PageQuery pageQuery) {
		ModelAndView mv = getModelAndView();
		EduInformationDto eduInformationDto = new EduInformationDto();
		eduInformationDto.setType(Integer.valueOf(type));
		
		List<String> sourceIds = packageSourceId();
		eduInformationDto.setSourceIds(sourceIds);
		PageResult<EduInformationDto> pageList =  iEduInformationService.searchInfomation(eduInformationDto,pageQuery);
		
		mv.addObject("type",type);
		mv.addObject("pageList", pageList);
		mv.setViewName("info/dis_edu_motive_index");
		return mv;
	}
	
	
	private List<String> packageSourceId() {
		List<String> sIds = new ArrayList<String>();
		EduCommitteeDto eduCommitteeDto = new EduCommitteeDto();
		eduCommitteeDto.setType(Short.valueOf("1"));
		List<EduCommitteeDto> committeeList = iEduCommitteeService.queryCommittee(eduCommitteeDto);
		if (Objects.equal(getEduUsersDto().getSourceType(), Byte.valueOf("0"))) {// 市教委登录的账号能看全部的信息
		} else if (Objects.equal(getEduUsersDto().getSourceType(),Byte.valueOf("1"))) {//学校登录的能看到市教委 和 该区教委的发不的
			EduSchoolDto eduSchoolDto = eduSchoolService.findById(getEduUsersDto().getSourceId());
			sIds.add(committeeList.get(0).getId());
			sIds.add(eduSchoolDto.getCommitteeId());
		} else if (Objects.equal(getEduUsersDto().getSourceType(),Byte.valueOf("2"))) {// 区教委登录的能看市教委 和 自己发布的
			sIds.add(committeeList.get(0).getId());
			sIds.add(getEduUsersDto().getSourceId());		
		}
		return sIds;
	}


	/**
	 * 
	 * 此方法描述的是：发布
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:41:57
	 */
	@RequestMapping(value = "release")
	public ModelAndView release() {
		ModelAndView mv = getModelAndView();

		mv.setViewName("info/dis_edu_motive_release");
		return mv;
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
		}
		return response;
	}
	
	
	/**
	 * 
	 * 此方法描述的是：infomation 详情信息
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value = "details/{infoId}")
	public ModelAndView details(@PathVariable String infoId,PageQuery pageQuery) {
		ModelAndView mv = getModelAndView();

		EduInformationDto data = iEduInformationService.search(infoId);
		
		EduInformationDto eduInformationDto = new EduInformationDto();
		eduInformationDto.setType(data.getType());
		PageResult<EduInformationDto> pageList =  iEduInformationService.searchInfomation(eduInformationDto,pageQuery);
		mv.addObject("pageList", pageList);
		
		mv.addObject("data", data);
		mv.setViewName("info/dis_edu_motice_detail");
		return mv;
	}

}

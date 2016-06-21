package com.ssic.education.government.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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


@Controller
public class MainController extends BaseController{
	
	@Autowired
	private IEduInformationService iEduInformationService;
	
	@Autowired
	private IEduCommitteeService iEduCommitteeService;

	@Autowired
	private EduSchoolService eduSchoolService;

	@Autowired
	private ITaskReceiveService iEduInformationListService;
	
	@RequestMapping(value="main")
	private ModelAndView main(PageQuery pageQuery){
		ModelAndView mv = getModelAndView();
		EduInformationDto eduInformationDto = new EduInformationDto();
		List<String> sourceIds = packageSourceId();
		eduInformationDto.setSourceIds(sourceIds);
		PageResult<EduInformationDto> pageList =  iEduInformationService.searchInfomation(eduInformationDto,pageQuery);
		EduInformationDto eduinformationDto = new EduInformationDto();
		if (null != pageList.getResults() && pageList.getResults().size()>0){
			eduinformationDto = pageList.getResults().get(0); 
			String content = eduinformationDto.getContent();
			if (StringUtils.isNotBlank(content)) {
				eduinformationDto.setContent(content.replace("img","yy"));
				eduinformationDto = pageList.getResults().get(0);
				eduinformationDto.setContent(eduinformationDto.getContent().replaceAll("</?[^>]+>", ""));
				eduinformationDto.setContent(eduinformationDto.getContent().replaceAll("<a>\\s*|\t|\r|\n</a>", ""));  
				eduinformationDto.setContent(eduinformationDto.getContent().substring(0, 410));
			}
		}
		eduInformationDto.setType(Integer.valueOf(DataStatus.ENABLED));
		PageResult<EduInformationDto> pageList1 =  iEduInformationService.searchInfomation(eduInformationDto,pageQuery);
		eduInformationDto.setType(Integer.valueOf(DataStatus.MANAGERTYPE));
		PageResult<EduInformationDto> pageList3 =  iEduInformationService.searchInfomation(eduInformationDto,pageQuery);
		mv.addObject("eduInformationDto", eduinformationDto);
		mv.addObject("pageList1", pageList1);
		mv.addObject("pageList3", pageList3);
		mv.setViewName("main");
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
}

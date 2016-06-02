package com.ssic.education.government.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.education.handle.service.IEduInformationService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;


@Controller
public class MainController extends BaseController{
	
	@Autowired
	private IEduInformationService iEduInformationService;
	
	@RequestMapping(value="main")
	private ModelAndView main(PageQuery pageQuery){
		ModelAndView mv = getModelAndView();
		EduInformationDto eduInformationDto = new EduInformationDto();
		eduInformationDto.setType(Integer.valueOf(DataStatus.ENABLED));
		PageResult<EduInformationDto> pageList1 =  iEduInformationService.searchInfomation(eduInformationDto,pageQuery);
		eduInformationDto.setType(Integer.valueOf(DataStatus.MANAGERTYPE));
		PageResult<EduInformationDto> pageList3 =  iEduInformationService.searchInfomation(eduInformationDto,pageQuery);		
		mv.addObject("pageList1", pageList1);
		mv.addObject("pageList3", pageList3);
		mv.setViewName("main");
		return mv;
	}
	
}

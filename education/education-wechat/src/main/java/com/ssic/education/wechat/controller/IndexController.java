package com.ssic.education.wechat.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.education.handle.service.EduSchoolService;

@Controller
public class IndexController extends BaseController{
	
	@Autowired
	private EduSchoolService eduSchoolService;
	
	@RequestMapping(value="index")
	public ModelAndView indexController(EduSchoolDto eduSchoolDto,String code) {
		if(StringUtils.isNotEmpty(code)){
			setWeixinOpenId(code);	
		}
		
		ModelAndView mv = getModelAndView();
		eduSchoolDto.setReviewed(Byte.valueOf("1"));
		List<EduSchoolDto> dataList = eduSchoolService.searchEduScholDtoList(eduSchoolDto);
		
		
		mv.addObject("dataList",dataList);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="main")
	public ModelAndView mainController(EduSchoolDto eduSchoolDto) {
		
		ModelAndView mv = getModelAndView();
		eduSchoolDto.setReviewed(Byte.valueOf("1"));
		List<EduSchoolDto> dataList = eduSchoolService.searchEduScholDtoList(eduSchoolDto);
		
		
		mv.addObject("dataList",dataList);
		mv.setViewName("index");
		return mv;
	}

}

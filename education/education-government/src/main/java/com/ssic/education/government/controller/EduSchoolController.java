package com.ssic.education.government.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.common.service.EduSchoolService;
import com.ssic.education.common.service.ProPackagesService;
import com.ssic.education.government.dto.EduSchoolDto;
import com.ssic.education.government.dto.ProPackagesDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

@Controller
@RequestMapping(value = "/edu/school")
public class EduSchoolController {
	
	protected static final Log logger = LogFactory.getLog(EduSchoolController.class);
	
	private final static int PAGESIZE = 10;
	
	@Autowired
	private EduSchoolService eduSchoolService;
	
	@Autowired
	private ProPackagesService proPackagesService;
	
	@RequestMapping(value = "/list")
	public ModelAndView list(EduSchoolDto dto, PageQuery page) {
		ModelAndView mv = new ModelAndView();
		PageResult<EduSchoolDto> result = eduSchoolService.list(dto, page);
		mv.setViewName("/edu/school/list");
		mv.addObject("pageList", result);
		return mv;
	}
	
	
	@RequestMapping(value = "/details")
	public ModelAndView details(ProPackagesDto dto) {
		ModelAndView mv = new ModelAndView();
		EduSchoolDto eduSchoolDto = eduSchoolService.findById(dto.getCustomerId());
		List<ProPackagesDto> proPackagesDtos = proPackagesService.getProPackages(dto);
		mv.setViewName("/edu/school/details");
		mv.addObject("eduSchoolDto", eduSchoolDto);
		mv.addObject("proPackagesDtos", proPackagesDtos);
		return mv;
	}
}
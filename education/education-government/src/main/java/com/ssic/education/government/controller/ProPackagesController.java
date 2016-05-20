package com.ssic.education.government.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.common.government.service.ProPackagesService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

@Controller
@RequestMapping(value = "/pro/packages")
public class ProPackagesController extends BaseController{

	@Autowired
	private ProPackagesService proPackagesService;
	
	@RequestMapping(value = "/findPage")
	public ModelAndView findPage(ProPackagesDto dto, PageQuery page) {
		ModelAndView mv = this.getModelAndView();
		PageResult<ProPackagesDto> proPackagesDtos = proPackagesService.fingPackagesPage(dto, page);
		mv.addObject("proPackagesDtos", proPackagesDtos);
		mv.setViewName("/");
		return mv;
	}
	
}

package com.ssic.education.government.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.service.ProSupplierService;

/**
 * 
  @Author: pengpeng
  @Date: 2016年5月12日 下午2:55:56 
  @Description: 
 */
@Controller
@RequestMapping(value = "/pro/supplier")
public class ProSupplierController {
	
	protected static final Log logger = LogFactory.getLog(ProSupplierController.class);
	
	@Autowired
	private ProSupplierService proSupplierService;
	
	
	@RequestMapping(value = "/qualificationsDetails")
	public ModelAndView qualificationsDetails(String id) {
		ModelAndView mv = new ModelAndView();
		ProSupplierDto proSupplierDto = proSupplierService.findById(id);
		mv.setViewName("qualificationsDetails");
		mv.addObject("ProSupplierDto", proSupplierDto);
		return mv;
	}

}

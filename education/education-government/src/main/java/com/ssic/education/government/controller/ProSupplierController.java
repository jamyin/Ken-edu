package com.ssic.education.government.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.common.dto.ProDishesDto;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.service.ProDishesService;
import com.ssic.education.common.service.ProLedgerService;
import com.ssic.education.common.service.ProSupplierService;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

/**
 * 
  @Author: pengpeng
  @Date: 2016年5月12日 下午2:55:56 
  @Description: 
 */
@Controller
@RequestMapping(value = "/pro/supplier")
public class ProSupplierController extends BaseController{
	
	protected static final Log logger = LogFactory.getLog(ProSupplierController.class);
	
	@Autowired
	private ProSupplierService proSupplierService;
	
	@Autowired
	private ProDishesService proDishesService;
	
	@Autowired
	private ProLedgerService proLedgerService;
	
	/**
	 * 
	  @Name:  qualificationsDetails 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:19:37 
	  @Description: 供应商详情
	  @param id
	  @param page
	  @return
	 */
	@RequestMapping(value = "/qualificationsDetails")
	public ModelAndView qualificationsDetails(String id,PageQuery page) {
		ModelAndView mv = getModelAndView();
		ProSupplierDto proSupplierDto = proSupplierService.findById(id);
		ProDishesDto proDishesDto =new ProDishesDto();
		proDishesDto.setSupplierId(id);
		PageResult<ProWaresDto> proWaresDtos = proDishesService.findPage(proDishesDto, page);
		PageResult<ProSupplierDto> proSupplierDtos = proLedgerService.findPage(id, page);
		mv.setViewName("qualificationsDetails");
		mv.addObject("ProSupplierDto", proSupplierDto);
		mv.addObject("proWaresDtos", proWaresDtos);
		mv.addObject("proSupplierDtos", proSupplierDtos);
		return mv;
	}

}

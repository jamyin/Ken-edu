package com.ssic.education.government.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.common.government.service.EduSchoolService;
import com.ssic.education.common.government.service.ProPackagesService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

/**
 * 
  @Author: pengpeng
  @Date: 2016年5月12日 下午2:55:24 
  @Description: 
 */
@Controller
@RequestMapping(value = "/edu/school")
public class EduSchoolController extends BaseController{
	
	protected static final Log logger = LogFactory.getLog(EduSchoolController.class);
	
	private final static int PAGESIZE = 10;
	
	@Autowired
	private EduSchoolService eduSchoolService;
	
	@Autowired
	private ProPackagesService proPackagesService;
	
	/**
	 * 
	  @Name:  list 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:18:03 
	  @Description: 学校列表
	  @param dto
	  @param page
	  @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(EduSchoolDto dto, PageQuery page) {
		ModelAndView mv = getModelAndView();
		PageResult<EduSchoolDto> result = eduSchoolService.list(dto, page);
		mv.setViewName("/edu/school/list");
		mv.addObject("pageList", result);
		return mv;
	}
	
	/**
	 * 
	  @Name:  details 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:18:42 
	  @Description: 学校餐详情
	  @param dto
	  @return
	 */
	@RequestMapping(value = "/details")
	public ModelAndView details(ProPackagesDto dto) {
		ModelAndView mv = getModelAndView();
		EduSchoolDto eduSchoolDto = eduSchoolService.findById(dto.getCustomerId());
		List<ProPackagesDto> proPackagesDtos = proPackagesService.getProPackages(dto);
		mv.setViewName("/edu/school/details");
		mv.addObject("eduSchoolDto", eduSchoolDto);
		mv.addObject("proPackagesDtos", proPackagesDtos);
		return mv;
	}
}

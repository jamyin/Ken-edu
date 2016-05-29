package com.ssic.education.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.EduCanteenDto;
import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.education.handle.service.IEduCanteenService;
import com.ssic.education.handle.service.IProLicenseService;

/**
 * 
	 * 此类描述的是：供应商对应的一些执照信息
	 * @author: cwftalus@163.com
	 * @version: 2016年5月29日 下午12:37:35
 */
@Controller
@RequestMapping(value="/wap/supplier")
public class WapSupplierController extends BaseController{

	@Autowired
	private IEduCanteenService iEduCanteenService; 
	
	@Autowired
	private IProLicenseService iProLicenseService;
	
	/**
	 * 
		 * 此方法描述的是：查询食堂和 委托单位的一些基本信息
		 * @author: cwftalus@163.com
		 * @version: 2016年5月29日 下午12:54:03
		 * @param companyType 自定义类型 1 食堂 2 委托单位
	 */
	@RequestMapping(value="index")
	public ModelAndView index(Integer companyType,String relationId){
		ModelAndView mv = getModelAndView();

		List<ProLicenseDto> resultList = null;
		
		if(Objects.equal(companyType, 1)){
			EduCanteenDto eduCanteenDto = new EduCanteenDto();
			eduCanteenDto.setSchoolId(relationId);
			eduCanteenDto = iEduCanteenService.searchEduCanteenDto(eduCanteenDto);
			
			ProLicenseDto proLicenseDto = new ProLicenseDto();
			proLicenseDto.setRelationId(eduCanteenDto.getId());
			proLicenseDto.setCerSource(Short.valueOf("3"));
			resultList = iProLicenseService.searchProLicenseList(proLicenseDto);
		}else if(Objects.equal(companyType, 2)){
			
		}

		
		mv.addObject("resultList", resultList);
		mv.setViewName("aptitude");
		return mv;
	}

}

package com.ssic.education.wechat.controller;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.EduCanteenDto;
import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.education.handle.service.IEduCanteenService;
import com.ssic.education.handle.service.IEduSchoolSupplierService;
import com.ssic.education.handle.service.IProLicenseService;
import com.ssic.education.handle.service.ISupplierService;
import com.ssic.education.utils.model.Response;

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
	private ISupplierService iSupplierService;
	
	@Autowired
	private IProLicenseService iProLicenseService;
	
	@Autowired
	private IEduSchoolSupplierService iEduSchoolSupplierService;
	
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
		InfoObj infoObj = new InfoObj();
		String supplierId = null;
		if(Objects.equal(companyType, 1)){
			//基本信息
			EduCanteenDto eduCanteenDto = new EduCanteenDto();
			eduCanteenDto.setSchoolId(relationId);
			eduCanteenDto = iEduCanteenService.searchEduCanteenDto(eduCanteenDto);
			if(eduCanteenDto!=null){
				infoObj = copyCanteenProperty(eduCanteenDto);
				
				List<SupplierDto> supplierList = iEduSchoolSupplierService.searchEduSchoolSupplierListDto(relationId);
				if(!supplierList.isEmpty()){
					supplierId = supplierList.get(0).getId();
				}
				
				//资质信息
				ProLicenseDto proLicenseDto = new ProLicenseDto();
				proLicenseDto.setRelationId(eduCanteenDto.getId());
				proLicenseDto.setCerSource(Short.valueOf("3"));
				resultList = iProLicenseService.searchProLicenseList(proLicenseDto);				
			}
		}else if(Objects.equal(companyType, 2)){
			//基本信息
			ProSupplierDto proSupplierDto =  iSupplierService.searchProSupplierById(relationId);
			
			supplierId = proSupplierDto.getId();
			
			infoObj = copySupplierProperty(proSupplierDto);
			//资质信息
			ProLicenseDto proLicenseDto = new ProLicenseDto();
			proLicenseDto.setRelationId(relationId);
			proLicenseDto.setCerSource(Short.valueOf("0"));
			resultList = iProLicenseService.searchProLicenseList(proLicenseDto);
		}

		
		//根据当前供应商信息 查询该供应商对应的原料供应商信息
		List<ProSupplierDto> suppliList = iSupplierService.searchSupplierListBySupplierId(supplierId,null,2,10);

		mv.addObject("companyType",companyType);
		mv.addObject("infoObj",infoObj);
		mv.addObject("resultList", resultList);
		mv.addObject("suppliList", suppliList);
		mv.addObject("supplierId", supplierId);
		mv.setViewName("aptitude");
		return mv;
	}
	
	
	/**
	 * 
		 * 此方法描述的是：供应商列表
		 * @author: cwftalus@163.com
		 * @version: 2016年5月29日 下午12:54:03
	 */
	@RequestMapping(value="more/{supplierId}")
	public ModelAndView more(@PathVariable String supplierId){
		ModelAndView mv = getModelAndView();
	
		//根据当前供应商信息 查询该供应商对应的原料供应商信息
		List<ProSupplierDto> suppliList = iSupplierService.searchSupplierListBySupplierId(supplierId,null,2,null);

		mv.addObject("supplierId", supplierId);
		mv.addObject("suppliList", suppliList);
		mv.setViewName("suppliers");
		return mv;
	}
	
	/**
	 * 
		 * 此方法描述的是：供应商列表异步查询
		 * @author: cwftalus@163.com
		 * @version: 2016年5月29日 下午12:54:03
	 */
	@RequestMapping(value="search/{supplierId}")
	@ResponseBody
	public Response<List<ProSupplierDto>> search(@PathVariable String supplierId,String suppliName){
		Response<List<ProSupplierDto>> result = new Response<List<ProSupplierDto>>();
	
		//根据当前供应商信息 查询该供应商对应的原料供应商信息
		List<ProSupplierDto> suppliList = iSupplierService.searchSupplierListBySupplierId(supplierId,suppliName,2,null);

		result.setData(suppliList);
		return result;
	}
	
	private InfoObj copySupplierProperty(ProSupplierDto proSupplierDto) {
		InfoObj infoObj = new InfoObj();
		infoObj.setName(proSupplierDto.getSupplierName());
		infoObj.setAddress(proSupplierDto.getAddress());
		infoObj.setMobile(proSupplierDto.getContactWay());
		infoObj.setRelationer(proSupplierDto.getCorporation());
		return infoObj;
	}




	private InfoObj copyCanteenProperty(EduCanteenDto eduCanteenDto) {
		InfoObj infoObj = new InfoObj();
		infoObj.setName(eduCanteenDto.getCanteenName());
		infoObj.setAddress("");
		infoObj.setMobile(eduCanteenDto.getPhoneNumber());
		infoObj.setRelationer(eduCanteenDto.getCanteenContacts());			
		return infoObj;
	}



	/**
	 * 
		 * 此类描述的是：内部类实现 当前页面使用
		 * @author: cwftalus@163.com
		 * @version: 2016年5月29日 下午1:59:52
	 */
	@Data
	public class InfoObj implements Serializable{
		public String name;
		public String address;
		public String relationer;
		public String mobile;
	}	
	

}

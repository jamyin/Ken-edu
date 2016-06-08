package com.ssic.education.wechat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.educateion.common.utils.ProductClass;
import com.ssic.education.handle.service.IProLicenseService;
import com.ssic.education.handle.service.ProWaresService;
import com.ssic.education.utils.model.Response;

/**
 * 
	 * 此类描述的是：h5 学校对应的采购品列表
	 * @author: cwftalus@163.com
	 * @version: 2016年5月29日 上午10:55:29
 */

@Controller
@RequestMapping(value="/wap/purchases")
public class WapPurchasesController extends BaseController{

	@Autowired
	private ProWaresService proWaresService;
	
	@Autowired
	private IProLicenseService iProLicenseService;
	
	@RequestMapping(value="/index/{schoolId}")
	private ModelAndView index(@PathVariable String schoolId){
		ModelAndView mv = getModelAndView();
		
		//根据学校查询 对应的采购品信息
		List<ProWaresDto> resultList = proWaresService.searchProWares(schoolId,null,null);

//		List<String> wareIds = new ArrayList<String>();
//		for(ProWaresDto wareDto : resultList){
//			wareIds.add(wareDto.getId());
//		}
		//资质 图片信息
//		ProLicenseDto proLicenseDto = new ProLicenseDto();
//		proLicenseDto.setWareIds(wareIds);
//		proLicenseDto.setLicType(8);
//		proLicenseDto.setCerSource(Short.valueOf("2"));
////		List<ProLicenseDto> licenseList = iProLicenseService.searchProLicenseList(proLicenseDto);
//		HashMap<String,ProLicenseDto> licenseMap = licenseListToMap(licenseList);

//		for(ProWaresDto wareDto : resultList){
//			ProLicenseDto licenseDto = licenseMap.get(wareDto.getId());
//			if(licenseDto!=null){
//				wareDto.setImage(licenseDto.getLicPic());	
//			}
//		}
		Map<Integer,String> productClass = ProductClass.getAll();
		mv.addObject("productClass",mapToList(productClass));
		mv.addObject("resultList",resultList);
		mv.addObject("schoolId",schoolId);
		mv.setViewName("sc_purchases");
		return mv;
	}
	
	
	private HashMap<String, ProLicenseDto> licenseListToMap(List<ProLicenseDto> licenseList) {
		HashMap<String, ProLicenseDto> objMap = new HashMap<String, ProLicenseDto>();
		for(ProLicenseDto licenseDto : licenseList){
			String keyCode = licenseDto.getRelationId();
			objMap.put(keyCode, licenseDto);
		}
		return objMap;
	}


	@RequestMapping(value="/search/{schoolId}")
	@ResponseBody
	private Response<List<ProWaresDto>> search(@PathVariable String schoolId,Integer waresType,String waresName){
		Response<List<ProWaresDto>> result = new Response<List<ProWaresDto>>();
		//根据学校查询 对应的采购品信息
		List<ProWaresDto> resultList = proWaresService.searchProWares(schoolId,waresName,waresType);
		result.setData(resultList);
		return result;
	}
	
	
	@RequestMapping(value="/details/{waresId}")
	private ModelAndView details(@PathVariable String waresId){
		ModelAndView mv = getModelAndView();
		
		//根据学校查询 对应的采购品信息
		ProWaresDto proWaresDto = proWaresService.findById(waresId);

		//资质信息
		ProLicenseDto proLicenseDto = new ProLicenseDto();
		proLicenseDto.setRelationId(waresId);
		proLicenseDto.setCerSource(Short.valueOf("2"));
		List<ProLicenseDto> resultList = iProLicenseService.searchProLicenseList(proLicenseDto);
		String wareTypeName = ProductClass.getName(proWaresDto.getWaresType());
		
		mv.addObject("wareTypeName",wareTypeName);
		mv.addObject("resultList",resultList);
		mv.addObject("proWaresDto",proWaresDto);
		mv.setViewName("sc_purchasing_c");
		return mv;
	}
	
	public List<purChasesWaresType> mapToList(Map<Integer,String> productClass){
		List<purChasesWaresType> dataList = new ArrayList<WapPurchasesController.purChasesWaresType>();
		purChasesWaresType purType = null;
		for (Map.Entry<Integer, String> entry : productClass.entrySet()) {
			purType = new purChasesWaresType();
			purType.setWaresType(entry.getKey());
			purType.setWaresName(entry.getValue());
			dataList.add(purType);
//		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		
		return dataList;
	}
	
	@Data
	public class purChasesWaresType implements Serializable{
		private Integer waresType;
		private String waresName;
	}
	
}

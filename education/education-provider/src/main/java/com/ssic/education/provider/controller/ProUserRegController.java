package com.ssic.education.provider.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.EduSupplierReviewDto;
import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.education.handle.service.IEduSupplierReviewService;
import com.ssic.education.handle.service.IProLicenseService;
import com.ssic.education.handle.service.ISupplierService;
import com.ssic.education.provider.dto.ProUsersDto;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.service.IProUsersService;
import com.ssic.education.utils.constants.DataStatus;
/**
 * 
	 * 此类描述的是：供应商注册信息
	 * @author: cwftalus@163.com
	 * @version: 2016年5月20日 下午1:37:22
 */
@Controller
@RequestMapping(value="/proUserRegController")
public class ProUserRegController extends BaseController{

	@Autowired
	private ISupplierService iSupplierService;
	
	@Autowired
	private IProUsersService iProUsersService;
	
	@Autowired
	private IEduSupplierReviewService iEduSupplierReviewService;
	
	
	@Autowired
	private IProLicenseService iProLicenseService;
	
	@RequestMapping(value="/pureg")
	@ResponseBody
	public Json prreg(SupplierDto supplierDto,ProUsersDto proUsersDto) {
		Json json = new Json();
		//先保存供应商信息  -->  保存该供应商对应的用户信息(账号) //需要增加事务处理 或 增加判断
		supplierDto.setReviewed(Byte.valueOf("0"));
		supplierDto.setSupplierType(Integer.valueOf(1));//常量  0为不区分，1为成品菜供应商，2为原料供应商  
		String supplierId = iSupplierService.saveOrUpdateSupplier(supplierDto);
		
		//供应商对应的区县信息
		saveSupplierReview(supplierId);
		
		//保存证件信息
		String[] licenses = getRequest().getParameterValues("licenseList");
		saveLicenses(supplierId,licenses);
		
		//用户信息
		proUsersDto.setSourceId(supplierId);
		proUsersDto.setName(supplierDto.getSupplierName());
		proUsersDto.setIsadmin(DataStatus.ENABLED);
		String proUserId = iProUsersService.saveProUsers(proUsersDto);
		
		return json;
		
	}

	private void saveLicenses(String supplierId, String[] licenses) {
		if(licenses!=null){
			for(String licesse : licenses){
				if(!StringUtils.isEmpty(licesse)){
					String licenseName = licesse.split("#")[0];
					String licPic = licesse.split("#")[1];
					ProLicenseDto proLicenseDto = new ProLicenseDto();
					
					proLicenseDto.setLicName(licenseName);
					proLicenseDto.setLicPic(licPic);
					proLicenseDto.setRelationId(supplierId);
					proLicenseDto.setCerSource(Short.valueOf("0"));

					iProLicenseService.saveProLicense(proLicenseDto);
				}
			}
		}
	}

	private void saveSupplierReview(String supplierId) {
		String[] committees = getRequest().getParameterValues("committees");
		List<String> commitIdList =  Arrays.asList(committees);
		List<EduSupplierReviewDto> insertList = new ArrayList<EduSupplierReviewDto>();
		Date date = new Date();
		for(String committeeId : commitIdList){
			EduSupplierReviewDto tDto = new EduSupplierReviewDto(committeeId, supplierId, Short.valueOf(String.valueOf(DataStatus.DISABLED)), date, date);
			insertList.add(tDto);
		}
		iEduSupplierReviewService.saveSupplierReview(insertList);	
	}	


}

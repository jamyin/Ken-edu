package com.ssic.education.provider.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.EduSupplierReviewDto;
import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.education.handle.service.IEduSupplierReviewService;
import com.ssic.education.handle.service.IProLicenseService;
import com.ssic.education.handle.service.ISupplierService;
import com.ssic.education.provider.dto.ProUsersDto;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.service.IProUsersService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.UUIDGenerator;
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
	@Transactional
	public Json prreg(SupplierDto supplierDto,ProUsersDto proUsersDto) {
		Json json = new Json();
		//先保存供应商信息  -->  保存该供应商对应的用户信息(账号) //需要增加事务处理 或 增加判断		String supplierId = UUIDGenerator.getUUID();
		String supplierId = UUIDGenerator.getUUID();
//		iSupplierService.saveOrUpdateSupplier(supplierDto);
		//供应商对应的区县信息
		saveSupplierReview(supplierId);
		//保存证件信息
		String[] licenses = getRequest().getParameterValues("licenseList");
		
		String creatorId = UUIDGenerator.getUUID();
		
		saveLicenses(supplierId,licenses,creatorId,supplierDto);
		//licenses 信息保存时同时存入主表信息
		
		//用户信息
		proUsersDto.setId(creatorId);
		proUsersDto.setCreator(creatorId);		
		proUsersDto.setSourceId(supplierId);
		proUsersDto.setName(supplierDto.getSupplierName());
		proUsersDto.setIsadmin(DataStatus.ENABLED);
		String proUserId = iProUsersService.saveProUsers(proUsersDto);
		
		return json;
		
	}

	private void saveLicenses(String supplierId, String[] licenses,String creatorId,SupplierDto supplierDto) {
		if(licenses!=null){
			for(String licesse : licenses){
				if(!StringUtils.isEmpty(licesse)){
					String licenseName = licesse.split("#")[0];
					String licPic = licesse.split("#")[1];
					String licNo = licesse.split("#")[2];
					String licType = licesse.split("#")[3];
					ProLicenseDto proLicenseDto = new ProLicenseDto();
					proLicenseDto.setLicType(DataStatus.DISABLED);
					proLicenseDto.setLicName(licenseName);
					proLicenseDto.setLicPic(licPic);
					proLicenseDto.setLicType(Integer.valueOf(licType));;
					proLicenseDto.setLicNo(licNo);
					proLicenseDto.setRelationId(supplierId);
					proLicenseDto.setCerSource(Short.valueOf("0"));
					proLicenseDto.setCreator(creatorId);
					iProLicenseService.saveProLicense(proLicenseDto);
					
					if(Objects.equal(licType, "4")){
						supplierDto.setBusinessLicense(licNo);
					}else if(Objects.equal(licType, "0")){
						supplierDto.setFoodServiceCode(licNo);
					}else if(Objects.equal(licType, "2")){
						supplierDto.setFoodCirculationCode(licNo);
					}else if(Objects.equal(licType, "3")){
						supplierDto.setFoodProduceCode(licNo);
					}
				}
			}
			supplierDto.setId(supplierId);
			supplierDto.setReviewed(Byte.valueOf("0"));
			supplierDto.setSupplierType(Integer.valueOf(1));//常量  0为不区分，1为成品菜供应商，2为原料供应商  
			iSupplierService.saveOrUpdateSupplier(supplierDto);
		}
		
//		business_license            工商执照号  4                                                              
//		organization_code           组织机构代码                                                            
//		food_service_code           餐饮服务证号   0                                                         
//		food_service_code_date      餐饮服务证号失效日期                                                
//		food_business_code          食品经营许可证号                                                      
//		food_business_code_date     食品经营许可证号失效日期                                          
//		food_circulation_code       食品流通证号            2                                                
//		food_circulation_code_date  食品流通证号失效日期                                                
//		food_produce_code           食品生产证号          3                                                  
//		food_produce_code_date      食品生产证号失效日期   
		
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

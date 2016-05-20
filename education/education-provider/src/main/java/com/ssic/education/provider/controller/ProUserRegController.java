package com.ssic.education.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.common.provider.service.ISupplierService;
import com.ssic.education.provider.dto.ProUsersDto;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.service.IProUsersService;
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
	
	
	@RequestMapping(value="/pureg")
	@ResponseBody
	public Json prreg(SupplierDto supplierDto,ProUsersDto proUsersDto) {
		Json json = new Json();
		//先保存供应商信息  -->  保存该供应商对应的用户信息(账号) //需要增加事务处理 或 增加判断
		String supplierId = iSupplierService.saveOrUpdateSupplier(supplierDto);
		
		proUsersDto.setSourceId(supplierId);
		proUsersDto.setName(supplierDto.getSupplierName());
		String proUserId = iProUsersService.saveProUsers(proUsersDto);
		
		return json;
		
	}

}

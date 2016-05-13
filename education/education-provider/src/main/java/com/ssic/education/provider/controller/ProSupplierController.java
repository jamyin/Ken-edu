package com.ssic.education.provider.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.provider.service.ISupplierService;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.PageHelper;



@Controller
@RequestMapping("/proSupplierController")
public class ProSupplierController {

	@Autowired
	private ISupplierService supplierService;

	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "supplier/supplier";
	}

	/**
	 * 查询供应商
	 * 
	 * @param proSupplierDto
	 * @param ph
	 * @return ming
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(ProSupplierDto proSupplierDto, PageHelper ph) {
		DataGrid dataGrid = new DataGrid();
		List<ProSupplierDto> list = supplierService.findAllProSupplier();
		dataGrid.setRows(list);
		return dataGrid;
	}
	
	/**
	 * 供应商详情
	 * 
	 * @param proSupplierDto
	 * @param ph
	 * @return ming
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		ProSupplierDto ps = supplierService.findProSupplierById(id);
		request.setAttribute("ProSupplie", ps);
		return "supplier/supplierEdit";
	}
	
	/**
	 * 修改供应商
	 * 
	 * @param proSupplierDto
	 * @return ming
	 */
	@RequestMapping(value="/proSupplierEdit")
	@ResponseBody
	public Json updataProSupplier(ProSupplierDto psd) {
		Json j = new Json();
		if(psd.getSupplierName()==null||psd.getSupplierName().equals("")){
			j.setMsg("供应商名称不能为空");
			j.setSuccess(false);
		}
		if(psd.getAddress()==null||psd.getAddress().equals("")){
			j.setMsg("供应商地址不能为空");
			j.setSuccess(false);
		}
		if(psd.getSupplierType()==null||psd.getSupplierType().equals("")){
			j.setMsg("供应商类型不能为空");
			j.setSuccess(false);
		}
		if(psd.getBusinessLicense()==null||psd.getBusinessLicense().equals("")){
			j.setMsg("工商执照号不能为空");
			j.setSuccess(false);
		}
		if(psd.getOrganizationCode()==null||psd.getOrganizationCode().equals("")){
			j.setMsg("组织机构代码不能为空");
			j.setSuccess(false);
		}
		if(psd.getCorporation()==null||psd.getCorporation().equals("")){
			j.setMsg("法人代表不能为空");
			j.setSuccess(false);
		}
		if(psd.getContactWay()==null||psd.getContactWay().equals("")){
			j.setMsg("联系方式不能为空");
			j.setSuccess(false);
		}
		if(psd.getLongitude()==null||psd.getLongitude().equals("")){
			j.setMsg("精度不能为空");
			j.setSuccess(false);
		}
		if(psd.getLatitude()==null||psd.getLatitude().equals("")){
			j.setMsg("维度不能为空");
			j.setSuccess(false);
		}
		if(psd.getProvinces()==null||psd.getProvinces().equals("")){
			j.setMsg("省不能为空");
			j.setSuccess(false);
		}
		if(psd.getCity()==null||psd.getCity().equals("")){
			j.setMsg("市不能为空");
			j.setSuccess(false);
		}
		if(psd.getArea()==null||psd.getArea().equals("")){
			j.setMsg("区不能为空");
			j.setSuccess(false);
		}
		ProSupplierDto ps = supplierService.findProSupplierById(psd.getId());
		if(ps==null){
			j.setMsg("不存在的供应商");
			j.setSuccess(false);
		}
		supplierService.updataProSupplier(psd);
		j.setMsg("修改信息成功");
    	j.setSuccess(true);
		return j;
	}
}

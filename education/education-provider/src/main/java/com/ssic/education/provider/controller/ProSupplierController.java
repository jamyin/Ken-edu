package com.ssic.education.provider.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.government.service.ProSupplierService;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.PageHelper;

@Controller
@RequestMapping("/proSupplierController")
public class ProSupplierController {

	@Autowired
	private ProSupplierService proSupplierService;

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
		List<ProSupplierDto> list = proSupplierService.findAllProSupplier();
		dataGrid.setRows(list);
		return dataGrid;
	}
	
	/**
	 * 修改供应商
	 * 
	 * @param proSupplierDto
	 * @param ph
	 * @return ming
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		ProSupplierDto ps = proSupplierService.findProSupplierById(id);
		request.setAttribute("ProSupplie", ps);
		return "supplier/supplierEdit";
	}
}

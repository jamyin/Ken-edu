package com.ssic.education.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.admin.pageModel.DataGrid;
import com.ssic.education.admin.service.ISchoolSupplierService;
import com.ssic.education.common.dto.SchoolSupplierDto;
import com.ssic.education.common.pageModel.PageHelper;

@Controller
@RequestMapping("/schoolSupplierController")
public class SchoolSupplierController {

	@Autowired
	private ISchoolSupplierService schoolSupplierService;
	
	@RequestMapping("/manager")
	public String manager(){
		return "education/schoolSupplier/schoolSupplier";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(SchoolSupplierDto schoolSupplierDto,PageHelper ph){
		DataGrid dataGrid = new DataGrid();
		List<SchoolSupplierDto> listdto = schoolSupplierService.findByPage(schoolSupplierDto,ph); 
		Integer count = schoolSupplierService.findCountByPage(schoolSupplierDto,ph);
		dataGrid.setRows(listdto);
		dataGrid.setTotal(count.longValue());
		return dataGrid;
	}
	
	@RequestMapping("/addPage")
	public String addPage(){
		return "education/schoolSupplier/schoolSupplierAddPage";
	}
	
	
}

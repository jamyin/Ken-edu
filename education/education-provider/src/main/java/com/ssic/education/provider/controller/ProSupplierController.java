package com.ssic.education.provider.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.provider.service.ISupplierService;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.utils.util.UUIDGenerator;

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
	@RequestMapping(value = "/proSupplierEdit")
	@ResponseBody
	public Json updataProSupplier(ProSupplier ps) {
		Json j = null;
		j=checkSupplier(ps);
		if(j!=null){
			return j;
		}
		j = new Json();
		ProSupplierDto p = supplierService.findProSupplierById(ps.getId());
		if (p == null) {
			j.setMsg("不存在的供应商");
			j.setSuccess(false);
			return j;
		}
		supplierService.updataProSupplier(ps);
		j.setMsg("修改信息成功");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping("/deleteSupplier")
	@ResponseBody
	public Json deleteSupplier(ProSupplierDto psd) {
		Json j = new Json();
		int r = supplierService.deleteSupplier(psd.getId());
		if (r == 0) {
			j.setMsg("删除供应商失败");
			j.setSuccess(false);
			return j;
		}
		j.setMsg("删除供应商成功");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 添加供应商页面
	 * 
	 * @return
	 */
	@RequestMapping("/addSupplier")
	public String addSupplier() {
		return "supplier/supplierAdd";
	}
	
	/**
	 * 添加供应商
	 * 
	 * @return
	 */
	@RequestMapping("/saveSupplier")
	@ResponseBody
	public Json saveSupplier(ProSupplier ps) {
		Json j=null;
		j=checkSupplier(ps);
		if(j!=null){
			return j;
		};
		ps.setId(UUIDGenerator.getUUID());
		supplierService.saveSupplier(ps);
		j=new Json();
		j.setMsg("添加供应商成功");
		j.setSuccess(true);
		return j;
	}
	
	private Json checkSupplier(ProSupplier ps){
		if (ps.getSupplierName() == null || ps.getSupplierName().equals("")) {
			Json j=new Json();
			j.setMsg("供应商名称不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getAddress() == null || ps.getAddress().equals("")) {
			Json j=new Json();
			j.setMsg("供应商地址不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getSupplierType() == null || ps.getSupplierType().equals("")) {
			Json j=new Json();
			j.setMsg("供应商类型不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getBusinessLicense() == null
				|| ps.getBusinessLicense().equals("")) {
			Json j=new Json();
			j.setMsg("工商执照号不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getOrganizationCode() == null
				|| ps.getOrganizationCode().equals("")) {
			Json j=new Json();
			j.setMsg("组织机构代码不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getCorporation() == null || ps.getCorporation().equals("")) {
			Json j=new Json();
			j.setMsg("法人代表不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getContactWay() == null || ps.getContactWay().equals("")) {
			Json j=new Json();
			j.setMsg("联系方式不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getLongitude() == null || ps.getLongitude().equals("")) {
			Json j=new Json();
			j.setMsg("精度不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getLatitude() == null || ps.getLatitude().equals("")) {
			Json j=new Json();
			j.setMsg("维度不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getProvinces() == null || ps.getProvinces().equals("")) {
			Json j=new Json();
			j.setMsg("省不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getCity() == null || ps.getCity().equals("")) {
			Json j=new Json();
			j.setMsg("市不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getArea() == null || ps.getArea().equals("")) {
			Json j=new Json();
			j.setMsg("区不能为空");
			j.setSuccess(false);
			return j;
		}
		return null;
	}
	
}

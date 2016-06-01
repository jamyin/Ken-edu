package com.ssic.education.provider.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.ImageInfoDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.educateion.common.utils.PageHelperDto;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.handle.pojo.ProSupplierReceiver;
import com.ssic.education.handle.service.ICreateImageService;
import com.ssic.education.handle.service.IProLicenseService;
import com.ssic.education.handle.service.ISupplierService;
import com.ssic.education.handle.service.IWaresService;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.SessionInfo;
import com.ssic.education.provider.util.ConfigUtil;
import com.ssic.education.provider.util.ProductClass;
import com.ssic.education.utils.poi.ParseExcelUtil;
import com.ssic.education.utils.util.ObjectExcelView;
import com.ssic.education.utils.util.PageData;
import com.ssic.education.utils.util.PropertiesUtils;
import com.ssic.education.utils.util.Tools;
import com.ssic.education.utils.util.UUIDGenerator;

@Controller
@RequestMapping("/proSupplierController")
public class ProSupplierController extends BaseController{
	@Autowired
	private IWaresService waresService;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private ICreateImageService createImageServiceImpl;

	@Autowired
	private IProLicenseService proLicenseServiceImpl;

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
	public DataGrid dataGrid(SupplierDto supplierDto, PageHelper ph,
			HttpServletRequest request) {
		DataGrid dataGrid = new DataGrid();
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		supplierDto.setReceiverId(info.getSupplierId());
		return supplierService.findProSupplier(supplierDto, ph);
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
		SupplierDto ps = supplierService.findProSupplierById(id);
		request.setAttribute("ProSupplie", ps);
		return "supplier/supplierEdit";
	}

	/**
	 * 修改供应商
	 * 
	 * @param SupplierDto
	 * @return ming
	 */
	@RequestMapping(value = "/proSupplierEdit")
	@ResponseBody
	public Json updataProSupplier(SupplierDto ps, HttpServletRequest request) {
		Json j = new Json();
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		// 当前登录用户所属供应商的id
		String supplierId = info.getSupplierId();
		if(supplierId==null){
			j.setMsg("请登录");
			j.setSuccess(false);
			return j;
		}
		if (ps.getSupplierName() == null || ps.getSupplierName().equals("")) {
			j.setMsg("供应商名称不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getAddress() == null || ps.getAddress().equals("")) {
			j.setMsg("供应商地址不能为空");
			j.setSuccess(false);
			return j;
		}
		SupplierDto p = supplierService.findProSupplierById(ps.getId());
		if (p == null) {
			j.setMsg("不存在的供应商");
			j.setSuccess(false);
			return j;
		}
		// 查找已定义的供应商编码，供应商编码唯一
		/*
		 * List<SupplierDto> list=
		 * supplierService.findSupplierCodeByReceiverId(info.getSupplierId());
		 * for (SupplierDto supplierDto : list) {
		 * if(supplierDto.getSupplierCode().equals(ps.getSupplierCode())){
		 * j.setMsg("供应商编码重复"); j.setSuccess(false); return j; }
		 * 
		 * }
		 */
		ProSupplierReceiver proSupplierReceiver = new ProSupplierReceiver();		
		proSupplierReceiver.setSupplierCode(ps.getSupplierCode());
		proSupplierReceiver.setSupplierId(ps.getId());
		proSupplierReceiver.setReceiverId(supplierId);
		supplierService.updataProSupplier(ps);
		supplierService.updataProSupplierCode(proSupplierReceiver);

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
	public Json saveSupplier(SupplierDto ps, HttpServletRequest request) {
		Json j = new Json();
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		String supplierId = info.getSupplierId();
		if(supplierId==null){
			j.setMsg("请登录");
			j.setSuccess(false);
			return j;
		}
		if (ps.getSupplierName() == null || ps.getSupplierName().equals("")) {
			j.setMsg("供应商名称不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getAddress() == null || ps.getAddress().equals("")) {
			j.setMsg("供应商地址不能为空");
			j.setSuccess(false);
			return j;
		}
		ps.setId(UUIDGenerator.getUUID());
		ps.setSupplierType(2);
		ProSupplierReceiver proSupplierReceiver = new ProSupplierReceiver();
		proSupplierReceiver.setSupplierId(ps.getId());
		proSupplierReceiver.setReceiverId(info.getSupplierId());
		proSupplierReceiver.setSupplierCode(ps.getSupplierCode());
		ProSupplier rps = supplierService.findProSupplierByName(ps.getSupplierName(),supplierId);
		if(rps!=null){
			j.setMsg("供应商已存在");
			j.setSuccess(false);
			return j;
		}
		List<SupplierDto> list = supplierService
				.findSupplierCodeByReceiverId(info.getSupplierId());
		for (int i = 0; i < list.size(); i++) {
			boolean falge = list.get(i).getSupplierCode()
					.equalsIgnoreCase(ps.getSupplierCode());
			if (falge) {
				j = new Json();
				j.setMsg("供应商编码重复");
				j.setSuccess(false);
				return j;
			}

		}
		supplierService.saveSupplier(ps);
		supplierService.saveSupplierReceiver(proSupplierReceiver);
		j = new Json();
		j.setMsg("添加供应商成功");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 查看关联产品
	 */
	/**
	 * 查看该商品供应商
	 * 
	 * @param request
	 * @param id
	 *            商品ID
	 * @return
	 */
	@RequestMapping("/lookRelatingWares")
	public DataGrid lookRelatingWares(HttpServletRequest request, String id) {
		ProSupplierDto dto = new ProSupplierDto();
		dto.setId(id);
		DataGrid dataGrid = new DataGrid();
		List<SupplierDto> SupplierDtoList = supplierService
				.lookRelatingWares(dto);
		dataGrid.setRows(SupplierDtoList);
		;
		return dataGrid;
	}

	/**
	 * 跳转到上传图片页面
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/inputImage")
	public String inputImage(HttpServletRequest request, String id) {

		request.setAttribute("id", id);
		return "supplier/updateImage";
	}

	/**
	 * 查看图片
	 */
	@RequestMapping("/lookImage")
	public String lookImage(HttpServletRequest request, String id) {
		ProLicense license = new ProLicense();
		license.setRelationId(id);
		license.setCerSource((short) 0);
		List<ProLicense> ProLicenseList = proLicenseServiceImpl
				.lookImage(license);
		String realPath = PropertiesUtils.getProperty("upload.look.url");
		for (ProLicense proLicense : ProLicenseList) {
			proLicense.setLicPic(realPath + proLicense.getLicPic());
		}
		request.setAttribute("ProLicenseList", ProLicenseList);
		return "supplier/lookImage";
	}

	/**
	 * 跳转到修改图片页面
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/editImage")
	public String editImage(HttpServletRequest request, String id) {

		request.setAttribute("id", id);
		return "supplier/editImage";
	}

	/**
	 * 上传图片
	 */
	@RequestMapping("/insterImage")
	@ResponseBody
	public Json updateImage(String id,
			@RequestParam(value = "imgUrl1") MultipartFile imgUrl1,
			@RequestParam(value = "imgUrl2") MultipartFile imgUrl2,
			@RequestParam(value = "imgUrl3") MultipartFile imgUrl3,
			@RequestParam(value = "imgUrl4") MultipartFile imgUrl4,
			@RequestParam(value = "imgUrl5") MultipartFile imgUrl5,
			@RequestParam(value = "imgUrl6") MultipartFile imgUrl6,
			@RequestParam(value = "imgUrl7") MultipartFile imgUrl7,
			@RequestParam(value = "imgUrl8") MultipartFile imgUrl8,
			@RequestParam(value = "imgUrl9") MultipartFile imgUrl9,
			@RequestParam(value = "imgUrl10") MultipartFile imgUrl10,
			@RequestParam(value = "imgUrl11") MultipartFile imgUrl11,
			ImageInfoDto image, HttpServletRequest request,
			HttpServletResponse response) {
		Json json = new Json();
		ProLicense license = new ProLicense();
		
		
		
		
		Map<String, Object> map1 = createImageServiceImpl.createImage(image,
				imgUrl1, request, response);
		Map<String, Object> map2 = createImageServiceImpl.createImage(image,
				imgUrl2, request, response);
		Map<String, Object> map3 = createImageServiceImpl.createImage(image,
				imgUrl3, request, response);
		Map<String, Object> map4 = createImageServiceImpl.createImage(image,
				imgUrl4, request, response);
		Map<String, Object> map5 = createImageServiceImpl.createImage(image,
				imgUrl5, request, response);
		Map<String, Object> map6 = createImageServiceImpl.createImage(image,
				imgUrl6, request, response);
		Map<String, Object> map7 = createImageServiceImpl.createImage(image,
				imgUrl7, request, response);
		Map<String, Object> map8 = createImageServiceImpl.createImage(image,
				imgUrl8, request, response);
		Map<String, Object> map9 = createImageServiceImpl.createImage(image,
				imgUrl9, request, response);
		Map<String, Object> map10 = createImageServiceImpl.createImage(image,
				imgUrl10, request, response);
		Map<String, Object> map11 = createImageServiceImpl.createImage(image,
				imgUrl11, request, response);

		// 如果已经有图片则更新image_url
		String imageurl1 = (String) map1.get("image_url");
		String imageurl2 = (String) map2.get("image_url");
		String imageurl3 = (String) map3.get("image_url");
		String imageurl4 = (String) map4.get("image_url");
		String imageurl5 = (String) map5.get("image_url");
		String imageurl6 = (String) map6.get("image_url");
		String imageurl7 = (String) map7.get("image_url");
		String imageurl8 = (String) map8.get("image_url");
		String imageurl9 = (String) map9.get("image_url");
		String imageurl10 = (String) map10.get("image_url");
		String imageurl11 = (String) map11.get("image_url");

		//判断图片是否重复上传
				List<ProLicense> list2=	proLicenseServiceImpl.selectByRelationId(id);
					
				for (int i = 0; i < list2.size(); i++) {
					if(imageurl1!=null){
					if(list2.get(i).getLicName().equals("工商营业执照")){
						json.setMsg("工商营业执照不可重复上传");
						json.setSuccess(false);
						return json;
					}}
				if(imageurl2!=null){
					if(list2.get(i).getLicName().equals("组织机构代码")){
						json.setMsg("组织机构代码不可重复上传");
						json.setSuccess(false);
						return json;
					}}
				if(imageurl3!=null){
					if(list2.get(i).getLicName().equals("税务登记证")){
						json.setMsg("税务登记证不可重复上传");
						json.setSuccess(false);
						return json;
					}}
				if(imageurl4!=null){
					if(list2.get(i).getLicName().equals("食品流通许可证")){
						json.setMsg("食品流通许可证不可重复上传");
						json.setSuccess(false);
						return json;
					}}
				if(imageurl5!=null){
					if(list2.get(i).getLicName().equals("食品生产许可证")){
						json.setMsg("食品生产许可证不可重复上传");
						json.setSuccess(false);
						return json;
					}}
				if(imageurl6!=null){
					if(list2.get(i).getLicName().equals("餐饮服务许可证")){
						json.setMsg("餐饮服务许可证不可重复上传");
						json.setSuccess(false);
						return json;
					}}
				if(imageurl7!=null){
					if(list2.get(i).getLicName().equals("食品经营许可证")){
						json.setMsg("食品经营许可证不可重复上传");
						json.setSuccess(false);
						return json;
					}}
				if(imageurl8!=null){
					if(list2.get(i).getLicName().equals("身份证")){
						json.setMsg("身份证不可重复上传");
						json.setSuccess(false);
						return json;
					}}
				if(imageurl9!=null){
					if(list2.get(i).getLicName().equals("港澳居民来往内地通行证")){
						json.setMsg("港澳居民来往内地通行证不可重复上传");
						json.setSuccess(false);
						return json;
					}}
				if(imageurl10!=null){
					if(list2.get(i).getLicName().equals("台湾居民往来内地通行证")){
						json.setMsg("台湾居民往来内地通行证不可重复上传");
						json.setSuccess(false);
						return json;
					}}
				if(imageurl11!=null){
					if(list2.get(i).getLicName().equals("其他")){
						json.setMsg("其他证件不可重复上传");
						json.setSuccess(false);
						return json;
					}	}	
				}
				
		
		
		if (imageurl1 != null && imageurl1 != "") {
			license.setLicName("工商营业执照");
			license.setLicPic(imageurl1);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(4);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl2 != null && imageurl2 != "") {
			license.setLicName("组织机构代码");
			license.setLicPic(imageurl2);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(5);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl3 != null && imageurl3 != "") {
			license.setLicName("税务登记证");
			license.setLicPic(imageurl3);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(6);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
			
		}
		if (imageurl4 != null && imageurl4 != "") {
			license.setLicName("食品流通许可证");
			license.setLicPic(imageurl4);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(2);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl5 != null && imageurl5 != "") {
			license.setLicName("食品生产许可证");
			license.setLicPic(imageurl5);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(3);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl6 != null && imageurl6 != "") {
			license.setLicName("餐饮服务许可证");
			license.setLicPic(imageurl6);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(0);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl7 != null && imageurl7 != "") {
			license.setLicName("食品经营许可证");
			license.setLicPic(imageurl7);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(1);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl8 != null && imageurl8 != "") {
			license.setLicName("身份证");
			license.setLicPic(imageurl8);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(9);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl9 != null && imageurl9 != "") {
			license.setLicName("港澳居民来往内地通行证");
			license.setLicPic(imageurl9);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(10);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl10 != null && imageurl10 != "") {
			license.setLicName("台湾居民往来内地通行证");
			license.setLicPic(imageurl10);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(11);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl11 != null && imageurl11 != "") {
			license.setLicName("其他");
			license.setLicPic(imageurl11);
			license.setRelationId(id);
			license.setStat(1);
			license.setLicType(12);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		json.setMsg("上传图片成功");
		json.setSuccess(true);
		return json;
	}

	/**
	 * 修改图片
	 */
	@RequestMapping("/alterImage")
	@ResponseBody
	public Json alterImage(String id,
			@RequestParam(value = "imgUrl1") MultipartFile imgUrl1,
			@RequestParam(value = "imgUrl2") MultipartFile imgUrl2,
			@RequestParam(value = "imgUrl3") MultipartFile imgUrl3,
			@RequestParam(value = "imgUrl4") MultipartFile imgUrl4,
			@RequestParam(value = "imgUrl5") MultipartFile imgUrl5,
			@RequestParam(value = "imgUrl6") MultipartFile imgUrl6,
			@RequestParam(value = "imgUrl7") MultipartFile imgUrl7,
			@RequestParam(value = "imgUrl8") MultipartFile imgUrl8,
			@RequestParam(value = "imgUrl9") MultipartFile imgUrl9,
			@RequestParam(value = "imgUrl10") MultipartFile imgUrl10,
			@RequestParam(value = "imgUrl11") MultipartFile imgUrl11,
			ImageInfoDto image, HttpServletRequest request,
			HttpServletResponse response) {
		Json json = new Json();
		ProLicense license = new ProLicense();
		Map<String, Object> map1 = createImageServiceImpl.createImage(image,
				imgUrl1, request, response);
		Map<String, Object> map2 = createImageServiceImpl.createImage(image,
				imgUrl2, request, response);
		Map<String, Object> map3 = createImageServiceImpl.createImage(image,
				imgUrl3, request, response);
		Map<String, Object> map4 = createImageServiceImpl.createImage(image,
				imgUrl4, request, response);
		Map<String, Object> map5 = createImageServiceImpl.createImage(image,
				imgUrl5, request, response);
		Map<String, Object> map6 = createImageServiceImpl.createImage(image,
				imgUrl6, request, response);
		Map<String, Object> map7 = createImageServiceImpl.createImage(image,
				imgUrl7, request, response);
		Map<String, Object> map8 = createImageServiceImpl.createImage(image,
				imgUrl8, request, response);
		Map<String, Object> map9 = createImageServiceImpl.createImage(image,
				imgUrl9, request, response);
		Map<String, Object> map10 = createImageServiceImpl.createImage(image,
				imgUrl10, request, response);
		Map<String, Object> map11 = createImageServiceImpl.createImage(image,
				imgUrl11, request, response);

		// 如果已经有图片则更新image_url
		String imageurl1 = (String) map1.get("image_url");
		String imageurl2 = (String) map2.get("image_url");
		String imageurl3 = (String) map3.get("image_url");
		String imageurl4 = (String) map4.get("image_url");
		String imageurl5 = (String) map5.get("image_url");
		String imageurl6 = (String) map6.get("image_url");
		String imageurl7 = (String) map7.get("image_url");
		String imageurl8 = (String) map8.get("image_url");
		String imageurl9 = (String) map9.get("image_url");
		String imageurl10 = (String) map10.get("image_url");
		String imageurl11 = (String) map11.get("image_url");

		if (imageurl1 != null && imageurl1 != "") {
			license.setLicName("工商营业执照");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl2 != null && imageurl2 != "") {
			license.setLicName("组织机构代码");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl2);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl3 != null && imageurl3 != "") {
			license.setLicName("税务登记证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl3);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl4 != null && imageurl4 != "") {
			license.setLicName("食品流通许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl4);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl5 != null && imageurl5 != "") {
			license.setLicName("食品生产许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl5);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl6 != null && imageurl6 != "") {
			license.setLicName("餐饮服务许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl6);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl7 != null && imageurl7 != "") {
			license.setLicName("食品经营许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl7);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl8 != null && imageurl8 != "") {
			license.setLicName("身份证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl8);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl9 != null && imageurl9 != "") {
			license.setLicName("港澳居民来往内地通行证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl9);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl10 != null && imageurl10 != "") {
			license.setLicName("台湾居民往来内地通行证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl10);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl11 != null && imageurl11 != "") {
			license.setLicName("其他");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl11);
			license.setLastUpdateTime(new Date());
			proLicenseServiceImpl.alterImage(license);
		}
		json.setMsg("上传图片成功");
		json.setSuccess(true);
		return json;
	}

	@RequestMapping("/importPage")
	public String importPage() {
		return "supplier/supplierImport";
	}

	/**
	 * 导入供应商
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 * @author chenminghai
	 * @throws IOException
	 */
	@RequestMapping("/supplierImport")
	@ResponseBody
	public Json supplierImport(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Json j = new Json();
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		// 当前登录用户所属供应商的id
		String supplierId = info.getSupplierId();
		String errorMsg = null;
		Map<String,Map<ProSupplierReceiver,ProSupplier>> map = new HashMap();
		try (Workbook wb = WorkbookFactory.create(file.getInputStream());) {
			Sheet sheet = wb.getSheetAt(0);
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.M.d");
			if (sheet == null) {
				return null;
			}
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				if (errorMsg != null) {
					break;
				}
				Map< ProSupplierReceiver,ProSupplier> suppliers=new HashMap();
				ProSupplier supplier = null;
				ProSupplierReceiver psr=null;
				Row row = sheet.getRow(rowNum);
				int n = 0;
				for (int i = 0; i < row.getLastCellNum(); i++) {
					if (errorMsg != null) {
						break;
					}
					Cell cell = row.getCell(i);
					String value = ParseExcelUtil.getStringCellValue(cell);
					if (value != null) {
						value = value.trim();
					}
					if (i == 0) {
						//供应商
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，供应商名称不能为空。";
							break;
						}
						ProSupplier s = supplierService.findProSupplierByName(
								value, supplierId);
						if (s != null) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，供应商名称已存在。";
							break;
						}
						if (map.get(value)!= null) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，供应商名称重复。";
							break;
						}
						supplier = new ProSupplier();
						supplier.setSupplierName(value);
						supplier.setCreateTime(now);
						supplier.setLastUpdateTime(now);
						supplier.setStat(1);
					} else if (i == 1) {
						//供应商地址
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，供应商地址不能为空。";
							break;
						}
						supplier.setAddress(value);
					} else if (i == 2) {
						//证书
						if (StringUtils.isBlank(value)) {
							n += 1;
							break;
						}
						supplier.setFoodServiceCode(value);
					} else if (i == 3) {
						if (StringUtils.isBlank(value)) {
							n += 1;
							break;
						}
						supplier.setFoodBusinessCode(value);
					} else if (i == 4) {
						if (StringUtils.isBlank(value)) {
							n += 1;
							break;
						}
						supplier.setFoodCirculationCode(value);
					} else if (i == 5) {
						if (StringUtils.isBlank(value)) {
							n += 1;
							break;
						}
						supplier.setFoodProduceCode(value);
					} else if (i == 6) {
						if (StringUtils.isBlank(value)) {
							if (n == 4) {
								errorMsg = "第" + (rowNum + 1)
										+ "行数据不正确，证件号至少一个不能为空。";
							}
							break;
						}
						supplier.setBusinessLicense(value);
					} else if (i == 7 && !StringUtils.isBlank(value)) {
						//供应商编码
						psr=new ProSupplierReceiver();
						psr.setSupplierCode(value);
					} else if (i == 8 && !StringUtils.isBlank(value)) {
						//联系人
						supplier.setCorporation(value);
					} else if (i == 9 && !StringUtils.isBlank(value)) {
						//联系方式
						supplier.setContactWay(value);
					}
				}
				if (supplier != null && errorMsg == null) {
					supplier.setId(UUID.randomUUID().toString());
					if(psr==null){
						psr=new ProSupplierReceiver();
					}
					psr.setSupplierId(supplier.getId());
					psr.setReceiverId(supplierId);
					suppliers.put(psr, supplier);
					map.put(supplier.getSupplierName(), suppliers);
				}
			}
		} catch (EncryptedDocumentException | InvalidFormatException e) {
			errorMsg = "Excel文件格式不正确";
		}
		if(errorMsg != null) {
			j.setMsg(errorMsg);
			j.setSuccess(false);
		} else {
			int r=supplierService.importSupplier(map);
			j.setMsg("成功添加"+r+"条数据");
			j.setSuccess(true);
		}
		return j;
	}
	
	@RequestMapping(value = "/excel")
	@ResponseBody
	public ModelAndView exportExcel(SupplierDto supplierDto,
			HttpServletRequest request,HttpServletResponse response) {
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		if (info == null) {
			return null;
		}
		supplierDto.setReceiverId(info.getSupplierId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.M.d");
		Date date = new Date();
		String filename = Tools.date2Str(date, "yyyyMMddHHmmss");
		HSSFSheet sheet;
		HSSFCell cell;
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename + ".xls");
		Workbook workbook = new HSSFWorkbook();
		sheet = (HSSFSheet) workbook.createSheet("供货商");
		try {
			List<String> titles = new ArrayList<String>();
			titles.add("供应商名称");
			titles.add("供应商地址");
			titles.add("餐饮服务证号");
			titles.add("食品经营许可证号");
			titles.add("食品流通证号");
			titles.add("食品生产证号");
			titles.add("工商执照号");
			titles.add("供应商编码");
			titles.add("联系人");
			titles.add("电话");
			int len = titles.size();
			HSSFCellStyle headerStyle = (HSSFCellStyle) workbook
					.createCellStyle(); // 标题样式
			headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			HSSFFont headerFont = (HSSFFont) workbook.createFont(); // 标题字体
			headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			headerFont.setFontHeightInPoints((short) 11);
			headerStyle.setFont(headerFont);
			short width = 20, height = 25 * 20;
			sheet.setDefaultColumnWidth(width);
			HSSFRow sheetRow = sheet.createRow(0);
			for (int i = 0; i < len; i++) { // 设置标题
				String title = titles.get(i);
				cell = sheetRow.createCell(i);
				cell.setCellStyle(headerStyle);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(title);
			}
			sheet.getRow(0).setHeight(height);
			HSSFCellStyle contentStyle = (HSSFCellStyle) workbook
					.createCellStyle(); // 内容样式
			contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			DataGrid dg = supplierService.findProSupplier(supplierDto,
					null);
			List<SupplierDto> expList = dg.getRows();
			List<PageData> varList = new ArrayList<PageData>();
			if (!CollectionUtils.isEmpty(expList)) {
				for (int i = 0; i < expList.size(); i++) {
					PageData vpd = new PageData();
					vpd.put("var1", expList.get(i).getSupplierName());
					vpd.put("var2", expList.get(i).getAddress());
					vpd.put("var3", expList.get(i).getFoodServiceCode());
					vpd.put("var4", expList.get(i).getFoodBusinessCode());
					vpd.put("var5", expList.get(i).getFoodCirculationCode());
					vpd.put("var6",
							expList.get(i).getFoodProduceCode());
					vpd.put("var7", expList.get(i).getBusinessLicense());
					vpd.put("var8", expList.get(i).getSupplierCode());
					vpd.put("var9", expList.get(i).getCorporation());
					vpd.put("var10", expList.get(i).getContactWay());
					varList.add(vpd);
				}
			}
			for (int i = 0; i < varList.size(); i++) {
				HSSFRow row = sheet.createRow(i + 1);
				PageData vpd = varList.get(i);
				for (int j = 0; j < len; j++) {
					String varstr = vpd.getString("var" + (j + 1)) != null ? vpd
							.getString("var" + (j + 1)) : "";
					cell = row.createCell(j);
					HSSFCellStyle cellStyle2 = (HSSFCellStyle) workbook
							.createCellStyle();
					HSSFDataFormat format = (HSSFDataFormat) workbook
							.createDataFormat();
					cellStyle2.setDataFormat(format.getFormat("@"));
					cell.setCellStyle(cellStyle2);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(varstr);

				}

			}
			OutputStream os = response.getOutputStream();
			workbook.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {

		}
		return null;
	}
	
//	@RequestMapping("download")
//	public void download(HttpServletRequest request,
//			HttpServletResponse response) {
//		String fileName = "供货商.xlsx";
//		BufferedInputStream bis = null;
//		BufferedOutputStream bos = null;
//		String p = request.getSession().getServletContext().getRealPath("/")
//				+ "\\templates\\" + fileName;
//		try {
//			bis = new BufferedInputStream(new FileInputStream(new File(request
//					.getSession().getServletContext().getRealPath("/")
//					+ "\\templates\\" + fileName)));
//			bos = new BufferedOutputStream(response.getOutputStream());
//			String encodedfileName = null;
//			String agent = request.getHeader("USER-AGENT");
//			if (null != agent && -1 != agent.indexOf("MSIE")) {// IE
//				encodedfileName = java.net.URLEncoder.encode(fileName, "UTF-8");
//			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {
//				encodedfileName = new String(fileName.getBytes("UTF-8"),
//						"iso-8859-1");
//			} else {
//				encodedfileName = java.net.URLEncoder.encode(fileName, "UTF-8");
//			}
//			response.setHeader("Content-Disposition", "attachment; filename=\""
//					+ encodedfileName + "\"");
//			int byteRead = 0;
//			byte[] buffer = new byte[8192];
//			while ((byteRead = bis.read(buffer, 0, 8192)) != -1) {
//				bos.write(buffer, 0, byteRead);
//			}
//
//			bos.flush();
//			bis.close();
//			bos.close();
//		} catch (Exception e) {
//		}
//	}
}

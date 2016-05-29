package com.ssic.education.provider.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.EncryptedDocumentException;
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

import com.ssic.educateion.common.dto.ImageInfoDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
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
import com.ssic.education.utils.poi.ParseExcelUtil;
import com.ssic.education.utils.util.PropertiesUtils;
import com.ssic.education.utils.util.UUIDGenerator;

@Controller
@RequestMapping("/proSupplierController")
public class ProSupplierController {
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
		Json j = null;
		j = checkSupplier(ps);
		if (j != null) {
			return j;
		}
		j = new Json();
		SupplierDto p = supplierService.findProSupplierById(ps.getId());
		if (p == null) {
			j.setMsg("不存在的供应商");
			j.setSuccess(false);
			return j;
		}
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
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
	public Json saveSupplier(SupplierDto ps, HttpServletRequest request) {
		Json j = null;
		j = checkSupplier(ps);
		if (j != null) {
			return j;
		}
		;
		ps.setId(UUIDGenerator.getUUID());
		ps.setSupplierType(2);
		supplierService.saveSupplier(ps);
		ProSupplierReceiver proSupplierReceiver = new ProSupplierReceiver();
		proSupplierReceiver.setSupplierId(ps.getId());
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		proSupplierReceiver.setReceiverId(info.getSupplierId());
		proSupplierReceiver.setSupplierCode(ps.getSupplierCode());
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
		supplierService.saveSupplierReceiver(proSupplierReceiver);
		j = new Json();
		j.setMsg("添加供应商成功");
		j.setSuccess(true);
		return j;
	}

	private Json checkSupplier(SupplierDto ps) {
		if (ps.getSupplierName() == null || ps.getSupplierName().equals("")) {
			Json j = new Json();
			j.setMsg("供应商名称不能为空");
			j.setSuccess(false);
			return j;
		}
		if (ps.getAddress() == null || ps.getAddress().equals("")) {
			Json j = new Json();
			j.setMsg("供应商地址不能为空");
			j.setSuccess(false);
			return j;
		}

		return null;
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

		if (imageurl1 != null && imageurl1 != "") {
			license.setLicName("工商营业执照");
			license.setLicPic(imageurl1);
			license.setRelationId(id);
			license.setStat(1);
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
	 * 上传图片
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
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl2 != null && imageurl2 != "") {
			license.setLicName("组织机构代码");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl3 != null && imageurl3 != "") {
			license.setLicName("税务登记证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl4 != null && imageurl4 != "") {
			license.setLicName("食品流通许可证");
			license.setLicPic(imageurl3);
			license.setRelationId(id);
			license.setStat(1);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 0);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl5 != null && imageurl5 != "") {
			license.setLicName("食品生产许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl6 != null && imageurl6 != "") {
			license.setLicName("餐饮服务许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl7 != null && imageurl7 != "") {
			license.setLicName("食品经营许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl8 != null && imageurl8 != "") {
			license.setLicName("身份证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl9 != null && imageurl9 != "") {
			license.setLicName("港澳居民来往内地通行证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl10 != null && imageurl10 != "") {
			license.setLicName("台湾居民往来内地通行证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl11 != null && imageurl11 != "") {
			license.setLicName("其他");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
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
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，供应商地址不能为空。";
							break;
						}
						supplier.setAddress(value);
					} else if (i == 2) {
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
						psr=new ProSupplierReceiver();
						psr.setSupplierCode(value);
					} else if (i == 8 && !StringUtils.isBlank(value)) {
						supplier.setCorporation(value);
					} else if (i == 9 && !StringUtils.isBlank(value)) {
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
}

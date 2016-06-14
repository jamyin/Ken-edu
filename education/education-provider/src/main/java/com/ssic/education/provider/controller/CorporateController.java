package com.ssic.education.provider.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssic.educateion.common.dto.ImageInfoDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.handle.service.ICorporateService;
import com.ssic.education.handle.service.ICreateImageService;
import com.ssic.education.handle.service.IProLicenseService;
import com.ssic.education.handle.service.ISupplierService;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.SessionInfo;
import com.ssic.education.provider.util.ConfigUtil;
import com.ssic.education.utils.util.PropertiesUtils;

@Controller
@RequestMapping("/corporateController")
public class CorporateController {

	@Autowired
	private ICorporateService corporateService;

	@Autowired
	private ISupplierService supplierService;

	@Autowired
	private IProLicenseService proLicenseServiceImpl;

	@Autowired
	private ICreateImageService createImageServiceImpl;

	@RequestMapping("/manager")
	public String manager(HttpServletRequest request, HttpSession session) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		ProSupplier ps = corporateService.findSupplierById(user.getSourceId());
		request.setAttribute("Corporate", ps);
		return "corporate/corporate";
	}

	@RequestMapping("/editPage")
	public String editCorporate(HttpServletRequest request, HttpSession session) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		ProSupplier ps = corporateService.findSupplierById(user.getSourceId());
		request.setAttribute("Corporate", ps);
		return "corporate/corporateEdit";
	}

	@RequestMapping("/corporateEdit")
	@ResponseBody
	public Json corporateEdit(SupplierDto psd, HttpServletRequest request,
			HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		psd.setLastUpdateTime(new Date());
		psd.setUpdater(user.getId());
		psd.setId(user.getSourceId());
		supplierService.updataProSupplier(psd);
		j.setMsg("修改信息成功");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping("/showPic")
	public String showPic(HttpServletRequest request,
			HttpSession session) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		ProLicense license = new ProLicense();
		license.setRelationId(user.getSourceId());
		license.setCerSource((short) 0);
		List<ProLicense> ProLicenseList = proLicenseServiceImpl
				.lookImage(license);
		String realPath = PropertiesUtils.getProperty("upload.look.url");
		for (ProLicense proLicense : ProLicenseList) {
			proLicense.setLicPic(realPath + proLicense.getLicPic());
		}
		JSONArray jsonarray = JSONArray.fromObject(ProLicenseList);  
		request.setAttribute("ProLicenseList", jsonarray.toString());
		return "corporate/lookImage";
	}

	/**
	 * 跳转到修改图片页面
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/editPic")
	public String editPic(HttpServletRequest request, HttpSession session) {
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		if (info == null) {
			return null;
		}
		String supplierId = info.getSupplierId();
		ProLicense license = new ProLicense();
		license.setRelationId(supplierId);
		license.setCerSource((short) 0);
		List<ProLicense> ProLicenseList = proLicenseServiceImpl
				.lookImage(license);
		String realPath = PropertiesUtils.getProperty("upload.look.url");
		for (ProLicense proLicense : ProLicenseList) {
			if(proLicense.getLicPic()!=null){
			proLicense.setLicPic(realPath + proLicense.getLicPic());
			}
		}
		
		JSONArray jsonarray = JSONArray.fromObject(ProLicenseList);  
		request.setAttribute("ProLicenseList", jsonarray.toString());
		return "corporate/editImage";
	}

	/**
	 * 上传图片
	 */
	@RequestMapping("/alterImage")
	@ResponseBody
	public Json alterImage(
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
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		if(info==null){
			json.setMsg("尚未登录");
			json.setSuccess(false);
			return json;
		}
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

		String id=info.getSupplierId();
		if (imageurl1 != null && imageurl1 != "") {
			license.setLicName("工商营业执照");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(4);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl2 != null && imageurl2 != "") {
			license.setLicName("组织机构代码");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl2);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(5);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl3 != null && imageurl3 != "") {
			license.setLicName("税务登记证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl3);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(6);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl4 != null && imageurl4 != "") {
			license.setLicName("食品流通许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl4);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(2);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl5 != null && imageurl5 != "") {
			license.setLicName("食品生产许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl5);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(3);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl6 != null && imageurl6 != "") {
			license.setLicName("餐饮服务许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl6);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(0);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl7 != null && imageurl7 != "") {
			license.setLicName("食品经营许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl7);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(1);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl8 != null && imageurl8 != "") {
			license.setLicName("身份证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl8);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(9);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl9 != null && imageurl9 != "") {
			license.setLicName("港澳居民来往内地通行证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl9);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(10);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl10 != null && imageurl10 != "") {
			license.setLicName("台湾居民往来内地通行证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl10);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(11);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl11 != null && imageurl11 != "") {
			license.setLicName("其他");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl11);
			license.setUpdater(info.getId());
			license.setLastUpdateTime(new Date());
			int i = proLicenseServiceImpl.alterImage(license);
			if (i == 0) {
				license.setStat(1);
				license.setLicType(12);
				license.setCreator(info.getId());
				license.setCreateTime(new Date());
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				proLicenseServiceImpl.updateImage(license);
			}
		}
		json.setMsg("上传图片成功");
		json.setSuccess(true);
		return json;
	}

}

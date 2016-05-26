package com.ssic.education.provider.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssic.education.common.dto.ImageInfoDto;
import com.ssic.education.common.pojo.ProLicense;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.common.provider.service.ICorporateService;
import com.ssic.education.common.provider.service.ISupplierService;
import com.ssic.education.common.service.ICreateImageService;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.service.IProLicenseService;

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
		psd.setId(user.getSourceId());
		supplierService.updataProSupplier(psd);
		j.setMsg("修改信息成功");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping("/showPic")
	public String showPic(SupplierDto psd, HttpServletRequest request,
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
		request.setAttribute("ProLicenseList", ProLicenseList);
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
			HttpServletResponse response ,HttpSession session) {
		Json json = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		String id=user.getSourceId();
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
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
		}
		if (imageurl2 != null && imageurl2 != "") {
			license.setLicName("组织机构代码");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
		}
		if (imageurl3 != null && imageurl3 != "") {
			license.setLicName("税务登记证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
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
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
		}
		if (imageurl5 != null && imageurl5 != "") {
			license.setLicName("食品生产许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
		}
		if (imageurl6 != null && imageurl6 != "") {
			license.setLicName("餐饮服务许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
		}
		if (imageurl7 != null && imageurl7 != "") {
			license.setLicName("食品经营许可证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
		}
		if (imageurl8 != null && imageurl8 != "") {
			license.setLicName("身份证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
		}
		if (imageurl9 != null && imageurl9 != "") {
			license.setLicName("港澳居民来往内地通行证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
		}
		if (imageurl10 != null && imageurl10 != "") {
			license.setLicName("台湾居民往来内地通行证");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
		}
		if (imageurl11 != null && imageurl11 != "") {
			license.setLicName("其他");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl1);
			int n=proLicenseServiceImpl.alterImage(license);
			if(n==0){
				proLicenseServiceImpl.saveLicense(license);
			}
		}
		json.setMsg("上传图片成功");
		json.setSuccess(true);
		return json;
	}

}

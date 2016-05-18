package com.ssic.education.provider.controller;

import java.util.Map;

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
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.common.service.ICreateImageService;
import com.ssic.education.provider.dto.RecycleOilDto;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.service.IRecycleOilService;
import com.ssic.education.provider.util.ConfigUtil;

@Controller
@RequestMapping("/recycleOilControllor")
public class RecycleOilControllor {

	@Autowired
	private IRecycleOilService recycleOilService;
	
	@Autowired
    private   ICreateImageService  createImageService;

	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "recycle/recycleOilList";
	}

	/**
	 * 
	 * @param RecycleOilDto
	 * @param ph
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(RecycleOilDto rod,HttpSession session, PageHelper ph) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if(user==null){
			return null;
		}
		rod.setSupplierId(user.getSourceId());
		DataGrid dataGrid = new DataGrid();
		return recycleOilService.findAllRecycleOil(rod, ph);
	}

	/**
	 * 废弃油脂详情
	 * 
	 * @param id
	 * @param ph
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage( String id,HttpServletRequest request,HttpSession session) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if(user==null){
			return null;
		}
		RecycleOilDto rod = recycleOilService.findRecycleOilById(user.getSourceId(),id);
		request.setAttribute("RecycleOil", rod);
		return "recycle/recycleOilEdit";
	}
	
	@RequestMapping(value = "/recycleOilEdit")
	@ResponseBody
	public Json updataProSupplier(@RequestParam(value = "oilDocumentUrl") MultipartFile oilDocumentUrl,RecycleOilDto rod ,ImageInfoDto image,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if(user==null){
			j.setMsg("供应商不能为空");
			j.setSuccess(false);
			return j;
		}
		Map<String, Object> map = createImageService.createImage(image, oilDocumentUrl, request, response);
	    String imageurl = (String) map.get("image_url");
	    if(imageurl!=null && imageurl!=""){
	    	rod.setDocumentUrl(imageurl);
        } 
	    String sourceId=user.getSourceId();
		RecycleOilDto r = recycleOilService.findRecycleOilById(sourceId,rod.getId());
		if (r == null) {
			j.setMsg("不存在的废油");
			j.setSuccess(false);
			return j;
		}
		rod.setSupplierId(sourceId);
		recycleOilService.updataRecycleOil(rod);
		j.setMsg("修改信息成功");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping("/deleteRecycleOil")
	@ResponseBody
	public Json deleteRecycleOil(RecycleOilDto rod,HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if(user==null){
			j.setMsg("供应商不能为空");
			j.setSuccess(false);
			return j;
		}
		int r = recycleOilService.deleteRecycleOil(user.getSourceId(),rod.getId());
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
	 * 添加废弃油脂页面
	 * 
	 * @return
	 */
	@RequestMapping("/addRecycleOil")
	public String addSupplier(HttpServletRequest request,HttpSession session) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if(user==null){
			return null;
		}
		String r = recycleOilService.findRecycleBySourceId(user.getSourceId());
		request.setAttribute("Recycle", r);
		return "Recycle/RecycleOilAdd";
	}
	
	/**
	 * 添加废弃油脂
	 * 
	 * @return
	 */
	@RequestMapping("/saveRecycleOil")
	@ResponseBody
	public Json saveRecycleOil(@RequestParam(value = "oilDocumentUrl") MultipartFile oilDocumentUrl,RecycleOilDto rod ,ImageInfoDto image,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if(user==null){
			j.setMsg("供应商不能为空");
			j.setSuccess(false);
			return j;
		}
		rod.setSupplierId(user.getSourceId());
	    Map<String, Object> map = createImageService.createImage(image, oilDocumentUrl, request, response);
	    String imageurl = (String) map.get("image_url");
	    if(imageurl!=null && imageurl!=""){
	    	rod.setDocumentUrl(imageurl);
        } 
	    recycleOilService.saveRecycleOil(rod);
		j=new Json();
		j.setMsg("添加供应商成功");
		j.setSuccess(true);
		return j;
	}
	
}

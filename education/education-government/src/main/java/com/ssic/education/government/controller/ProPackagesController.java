package com.ssic.education.government.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.EduUsersDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.education.handle.service.EduUsersService;
import com.ssic.education.handle.service.INutritionalService;
import com.ssic.education.handle.service.ProPackagesService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.constants.PackagesTypeEnum;
import com.ssic.education.utils.constants.ProNutritionalNameEnum;
import com.ssic.education.utils.constants.ProNutritionalUnitEnum;
import com.ssic.education.utils.constants.SessionConstants;
import com.ssic.education.utils.constants.SupplyPhaseEnum;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;

@Controller
@RequestMapping(value = "/pro/packages")
public class ProPackagesController extends BaseController{

	@Autowired
	private ProPackagesService proPackagesService;
	
	@Autowired
	private EduUsersService eduUsersService;
	
	@Autowired
	private INutritionalService nutritionalService;
	
	@RequestMapping(value = "/findPage")
	public ModelAndView findPage(HttpServletRequest request,HttpServletResponse response,HttpSession session,ProPackagesDto dto, PageQuery page) {
		ModelAndView mv = this.getModelAndView();
		String id = (String) getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
//		EduUsersDto usersdto = (EduUsersDto) session.getAttribute(SessionConstants.LOGIN_USER_INFO);
		EduUsersDto usersdto = getLoginUser(request, response, session, id);
		if (null != usersdto && StringUtils.isNotBlank(usersdto.getSourceId()) ) {
			dto.setCustomerId(usersdto.getSourceId());
		}
		PageResult<ProPackagesDto> proPackagesDtos = proPackagesService.findPackagesPage(dto, page);
		mv.addObject("pageList", proPackagesDtos);
		mv.setViewName("/menu/menu_typing");
		return mv;
	}
	
	@RequestMapping(value = "/detail")
	public ModelAndView detail(ProPackagesDto dto) {
		ModelAndView mv = this.getModelAndView();
		ProPackagesDto proPackagesDto = proPackagesService.findById(dto.getId());
		mv.addObject("data", proPackagesDto);
		mv.setViewName("/menu/menu_detail");
		return mv;
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Response<String> delete(ProPackagesDto dto) {
		proPackagesService.delete(dto.getId());
		Response<String> res = new Response<String>();
		res.setStatus(DataStatus.HTTP_SUCCESS);
		res.setMessage("删除成功！");
		return res;
	}	
	
	@RequestMapping(value = "/edit")
	public ModelAndView edit(ProPackagesDto dto) {
		ModelAndView mv = this.getModelAndView();
		ProPackagesDto proPackagesDto = proPackagesService.findById(dto.getId());
		mv.addObject("data", proPackagesDto);
		mv.addObject("PackagesType", PackagesTypeEnum.values());
		mv.addObject("SupplyPhase", SupplyPhaseEnum.values());
		mv.addObject("NutritionalUnit", ProNutritionalUnitEnum.values());
		mv.addObject("NutritionalName", ProNutritionalNameEnum.values());
		mv.setViewName("/menu/menu_edit");
		return mv;
	}
	
	@RequestMapping(value = "/save")
	@ResponseBody
	public Response<String> save(HttpServletRequest request,HttpServletResponse response,HttpSession session,ProPackagesDto dto, String jsonWares,String jsonNutritional) {
		String id = (String) getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
		EduUsersDto usersdto = getLoginUser(request, response, session, id);
		dto.setCreator(usersdto.getId());
		proPackagesService.save(dto, jsonWares, jsonNutritional);
		Response<String> res = new Response<String>();
		res.setStatus(DataStatus.HTTP_SUCCESS);
		res.setMessage("更新成功！");
		return res;
	}
	
	/**
	* @Title: add
	* @Description: 去增加菜谱页面
	* @author Ken Yin  
	* @date 2016年5月24日 下午5:57:13
	* @return ModelAndView    返回类型
	 */
	@RequestMapping(value = "/toAddPackage")
	public ModelAndView toAddPackage() {
		ModelAndView mv = this.getModelAndView();
		//套餐类型下拉框
		mv.addObject("packagesTypeList", PackagesTypeEnum.values());
		//套餐餐次下拉框
		mv.addObject("supplyPhaseList", SupplyPhaseEnum.values());
		mv.addObject("nutritionalNameList", ProNutritionalNameEnum.values());
		mv.addObject("nutritionalUnitList", ProNutritionalUnitEnum.values());
		mv.setViewName("/menu/menu_add");
		return mv;
	}
	
	/**
	* @Title: addPackage
	* @Description: 增加菜谱
	* @author Ken Yin  
	* @date 2016年5月25日 下午2:29:32
	* @return Response<String>    返回类型
	 */
	@RequestMapping(value = "/addPackage")
	@ResponseBody
	public Response<String> addPackage(HttpServletRequest request,HttpServletResponse response,HttpSession session,ProPackagesDto dto) {
		Response<String> res = new Response<String>();
		String id = (String) getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
		EduUsersDto usersdto = getLoginUser(request, response, session, id);
		dto.setCreator(usersdto.getId());
		if (null != usersdto && StringUtils.isNotBlank(usersdto.getSourceId()) ) {
			dto.setCustomerId(usersdto.getSourceId());
		}
		int flag = proPackagesService.addPackage(dto);
		if(flag > 0){
			res.setStatus(DataStatus.HTTP_SUCCESS);
			res.setMessage("添加菜谱成功");
			return res;
		}else{
			res.setStatus(DataStatus.HTTP_SUCCESS);
			res.setMessage("添加菜谱失败");
			return res;
		}
	}
	
	public EduUsersDto getLoginUser(HttpServletRequest request, HttpServletResponse response,
    		HttpSession session, String id){
    	if(id==null){
    		try {
				response.sendRedirect(request.getContextPath() + "/login.htm");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	EduUsersDto usersDto = new EduUsersDto();
    	usersDto.setId(id);
    	return eduUsersService.getUserInfo(usersDto);
    }
}

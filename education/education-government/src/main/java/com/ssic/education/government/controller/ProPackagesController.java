package com.ssic.education.government.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.common.government.service.ProPackagesService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;

@Controller
@RequestMapping(value = "/pro/packages")
public class ProPackagesController extends BaseController{

	@Autowired
	private ProPackagesService proPackagesService;
	
	@RequestMapping(value = "/findPage")
	public ModelAndView findPage(ProPackagesDto dto, PageQuery page) {
		ModelAndView mv = this.getModelAndView();
		PageResult<ProPackagesDto> proPackagesDtos = proPackagesService.fingPackagesPage(dto, page);
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
	
	
	@RequestMapping(value = "/add")
	public ModelAndView add() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("");
		return mv;
	}
	
	@RequestMapping(value = "/save")
	@ResponseBody
	public Response<String> save(ProPackagesDto dto, String jsonWares) {
		proPackagesService.save(dto, jsonWares);
		Response<String> res = new Response<String>();
		res.setStatus(DataStatus.HTTP_SUCCESS);
		res.setMessage("更新成功！");
		return res;
	}
}

package com.ssic.education.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.service.ProWaresService;
import com.ssic.education.utils.model.Response;

/**
 * 
	 * 此类描述的是：h5 学校对应的采购品列表
	 * @author: cwftalus@163.com
	 * @version: 2016年5月29日 上午10:55:29
 */

@Controller
@RequestMapping(value="/wap/purchases")
public class WapPurchasesController extends BaseController{

	@Autowired
	private ProWaresService proWaresService;
	
	@RequestMapping(value="/index/{schoolId}")
	private ModelAndView index(@PathVariable String schoolId){
		ModelAndView mv = getModelAndView();
		
		//根据学校查询 对应的采购品信息
		List<ProWaresDto> resultList = proWaresService.searchProWares(schoolId,null);

		mv.addObject("resultList",resultList);
		mv.addObject("schoolId",schoolId);
		mv.setViewName("sc_purchases");
		return mv;
	}
	
	
	@RequestMapping(value="/search/{schoolId}")
	@ResponseBody
	private Response<List<ProWaresDto>> search(@PathVariable String schoolId,String waresName){
		Response<List<ProWaresDto>> result = new Response<List<ProWaresDto>>();
		//根据学校查询 对应的采购品信息
		List<ProWaresDto> resultList = proWaresService.searchProWares(schoolId,waresName);
		result.setData(resultList);
		return result;
	}
	
}

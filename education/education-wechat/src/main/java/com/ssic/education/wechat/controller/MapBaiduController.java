package com.ssic.education.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="map")
public class MapBaiduController extends BaseController{

	@RequestMapping(value="show")
	public ModelAndView show(){
		ModelAndView mv = getModelAndView();
		
		return mv;
	}
	
}

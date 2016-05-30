package com.ssic.education.government.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="info")
public class MotiveController  extends BaseController{


	@RequestMapping(value="index")
	public ModelAndView index(){
		ModelAndView mv = getModelAndView();
		
		mv.setViewName("motive/index");
		return mv;
	}
	
}

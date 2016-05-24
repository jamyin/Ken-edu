package com.ssic.education.government.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController extends BaseController{
	
	@RequestMapping(value="main")
	private ModelAndView main(){
		ModelAndView mv = getModelAndView();
		
		mv.setViewName("main");
		return mv;
	}
	
}

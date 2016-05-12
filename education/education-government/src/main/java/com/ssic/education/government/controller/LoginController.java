package com.ssic.education.government.controller;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.common.metrics.MeanMetric;
import org.objectweb.asm.commons.Method;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;

@Controller
public class LoginController extends BaseController{

	@RequestMapping(value="login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();

		if(Objects.equal(getRequest().getMethod().toString(), RequestMethod.GET.toString())){
			mv.setViewName("/login");	
		}else{
			return new ModelAndView("redirect:/main.htm");  
		}
		
		return mv;
	}

}

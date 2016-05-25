package com.ssic.education.provider.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.common.provider.service.ICorporateService;
import com.ssic.education.provider.dto.TImsUsersDto;

@Controller
@RequestMapping("/corporateController")
public class CorporateController {

	@Autowired
	private ICorporateService corporateService;
	
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request, HttpSession session) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if(user==null){
			return null;
		}
		ProSupplier ps=corporateService.findSupplierById(user.getSourceId());
		request.setAttribute("Corporate", ps);
		return "corporate/corporate";
	}

	@RequestMapping("/showCorporate")
	public SupplierDto showCorporate() {
		
		return null;
	}

}

package com.ssic.education.provider.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssic.education.common.service.ProSupplierService;

@Controller
@RequestMapping("/proSupplierController")
public class ProSupplierController {
	
	@Autowired
	private ProSupplierService proSupplierService;
	
	@RequestMapping("/manager")
    public String manager(HttpServletRequest request)
    {
       return  "supplier/supplier";
    }

}

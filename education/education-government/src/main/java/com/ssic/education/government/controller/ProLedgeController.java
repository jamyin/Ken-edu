package com.ssic.education.government.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.common.service.ProLedgerService;
import com.ssic.education.government.dto.ProLedgerDto;

/**
 * 
 * @author pengpeng
 * @Date: 2016年5月12日 下午6:00:15
 */
@Controller
@RequestMapping(value = "/pro/ledge")
public class ProLedgeController extends BaseController{
	
	protected static final Log logger = LogFactory.getLog(ProSupplierController.class);
	
	@Autowired
	private ProLedgerService proLedgerService;
	
}

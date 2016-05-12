package com.ssic.education.government.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ssic.education.common.service.ProLedgerService;
import com.ssic.education.common.service.ProWaresService;
import com.ssic.education.government.dto.ProLedgerDto;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

/**
 * 
	 * 此类描述的是：原料 或者 成品菜 处理 模块
	 * @author: cwftalus@163.com
	 * @version: 2016年5月12日 下午5:05:51
 */

@Controller
@RequestMapping(value="wares")
public class WaresController extends BaseController{

	protected static final Log logger = LogFactory.getLog(ProSupplierController.class);
	
	@Autowired
	private ProWaresService proWaresService;
	
	@Autowired
	private ProLedgerService proLedgerService;
	
	/**
	 * 
	  @Name:  waresDetails 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:17:16 
	  @Description: 商品详情
	  @param id
	  @param page
	  @return
	 */
	@RequestMapping(value = "/details")
	private ModelAndView waresDetails(String id,PageQuery page) {
		ModelAndView mv = getModelAndView();
		ProWaresDto proWaresDto = proWaresService.findById(id);
		ProLedgerDto proLedgerDto = new ProLedgerDto();
		proLedgerDto.setWaresId(id);
		PageResult<ProLedgerDto> proLedgerDtos = proLedgerService.findLedgerPage(proLedgerDto, page);
		mv.setViewName("");
		mv.addObject("proWaresDto", proWaresDto);
		mv.addObject("proLedgerDtos", proLedgerDtos);
		return mv;
	}
	
	/**
	 * 
	  @Name:  ledgerDetails 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:16:38 
	  @Description: 商品批次详情
	  @param waresId
	  @param ledgerId
	  @return
	 */
	@RequestMapping(value = "/ledgerDetails")
	private ModelAndView ledgerDetails(String waresId,String ledgerId) {
		ModelAndView mv = getModelAndView();
		ProWaresDto proWaresDto = proWaresService.findById(waresId);
		ProLedgerDto proLedgerDto = proLedgerService.findById(ledgerId);
		mv.setViewName("");
		mv.addObject("proWaresDto", proWaresDto);
		mv.addObject("proLedgerDto", proLedgerDto);
		return mv;
	}

}

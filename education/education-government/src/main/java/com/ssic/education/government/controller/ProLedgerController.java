package com.ssic.education.government.controller;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.government.controller.supplier.ProSupplierController;
import com.ssic.education.handle.service.ProLedgerService;
import com.ssic.education.handle.service.ProSupplierService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

/**
 * 
 * @author pengpeng
 * @Date: 2016年5月12日 下午6:00:15
 */
@Controller
@RequestMapping(value = "/pro/ledger")
public class ProLedgerController extends BaseController{
	
	protected static final Log logger = LogFactory.getLog(ProSupplierController.class);
	
	@Autowired
	private ProLedgerService proLedgerService;
	
	@Autowired
	private ProSupplierService proSupplierService;
	
	@RequestMapping("/findPage")
	public ModelAndView findPage(ProPackagesDto dto,PageQuery query) throws ParseException{
		ModelAndView mv = this.getModelAndView();
		LedgerDto ledgerDto = new LedgerDto();
		ledgerDto.setReceiverId(dto.getCustomerId());
		ledgerDto.setReceiverName(dto.getWaresNames());
		ledgerDto.setSourceId(dto.getSourceId());
		PageResult<LedgerDto> ledgerDtos = proLedgerService.selectLedgerPage(ledgerDto,query);
		mv.setViewName("/ledger/distribution_list");
		mv.addObject("pageList", ledgerDtos);
		mv.addObject("dto", dto);
		return mv;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(LedgerDto dto) {
		ModelAndView mv = this.getModelAndView();
		List<LedgerDto> ledgerDtos = proLedgerService.findById(dto);
		LedgerDto ledgerDto = new LedgerDto();
		
		if (null !=ledgerDtos && ledgerDtos.size()>0) {
			ledgerDto = ledgerDtos.get(0);
		}
		ProSupplierDto proSupplierDto = new ProSupplierDto();
		if (StringUtils.isNotBlank(ledgerDto.getSupplierId())) {
			proSupplierDto = proSupplierService.findById(ledgerDto.getSupplierId());
		}		
		mv.setViewName("/ledger/distribution_detail");
		mv.addObject("ledgerDtos", ledgerDtos);
		mv.addObject("ledgerDto", ledgerDto);
		mv.addObject("dto", dto);
		mv.addObject("proSupplierDto", proSupplierDto);
		return mv;
	}
}

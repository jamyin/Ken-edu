package com.ssic.education.wechat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.ProLedgerDto;
import com.ssic.educateion.common.dto.ProLedgerMasterDto;
import com.ssic.education.handle.service.IProLedgerMasterService;
import com.ssic.education.handle.service.ProLedgerService;

@Controller
@RequestMapping(value="/wap/map")
public class MapBaiduController extends BaseController{
	
	@Autowired
	private ProLedgerService proLedgerService;
	
	@Autowired
	private IProLedgerMasterService iProLedgerMasterService;
	
	
	
	@RequestMapping(value="show/{masterId}")
	public ModelAndView show(@PathVariable String masterId){
		ModelAndView mv = getModelAndView();

		ProLedgerMasterDto resultDto = iProLedgerMasterService.searchProLedgerMasterDto(masterId);
		
		List<String> ledgerMasterIds = new ArrayList<String>();
		ledgerMasterIds.add(masterId);
		
		List<ProLedgerDto> resultLeList = proLedgerService.searchProLedger(ledgerMasterIds);
		
		resultDto.setResltList(resultLeList);
		
		mv.addObject("resultDto", resultDto);
		mv.setViewName("dispatching_c");
		return mv;
	}
	
}

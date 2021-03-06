package com.ssic.education.wechat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.ProLedgerDto;
import com.ssic.educateion.common.dto.ProLedgerMasterDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.handle.service.IProLedgerMasterService;
import com.ssic.education.handle.service.ProLedgerService;
import com.ssic.education.handle.service.ProSupplierService;

@Controller
@RequestMapping(value="/wap/ledger")
public class LedgerMasterController extends BaseController{
	
	@Autowired
	private ProLedgerService proLedgerService;
	
	@Autowired
	private IProLedgerMasterService iProLedgerMasterService;
	
	@Autowired
	private ProSupplierService proSupplierService;
	
	@RequestMapping(value="/list/{receiceId}")
	public ModelAndView list(@PathVariable String receiceId){
		ModelAndView mv = getModelAndView();
		ProLedgerMasterDto dto = new ProLedgerMasterDto();
		dto.setReceiverId(receiceId);
		//主
		List<ProLedgerMasterDto> resultList = iProLedgerMasterService.searchProLedgerMasterDto(dto);
		List<String> ledgerMasterIds = new ArrayList<String>();
		List<String> sourceIds = new ArrayList<String>();
		for(ProLedgerMasterDto master : resultList){
			ledgerMasterIds.add(master.getId());
			sourceIds.add(master.getSourceId());//
		}
		//从
		List<ProLedgerDto> resultLeList = proLedgerService.searchProLedger(ledgerMasterIds);
		HashMap<String,List<ProLedgerDto>> map = listToMap(resultLeList);
		for(ProLedgerMasterDto master : resultList){
			master.setResltList(map.get(master.getId()));
		}

		//查询对应的供应商信息
		List<ProSupplierDto> supplierList = proSupplierService.searchProSupplier(sourceIds);
		HashMap<String,ProSupplierDto> mapSupplier = listToSupplierMap(supplierList);
		for(ProLedgerMasterDto master : resultList){
			master.setSupplierDto(mapSupplier.get(master.getSourceId()));
		}
		
		mv.addObject("resultList", resultList);
		mv.setViewName("dispatching");
		return mv;
	}

	private HashMap<String, ProSupplierDto> listToSupplierMap(List<ProSupplierDto> supplierList) {
		HashMap<String, ProSupplierDto> objMap = new HashMap<String, ProSupplierDto>();
		for(ProSupplierDto supplier : supplierList){
			String keyCode = supplier.getId();
			objMap.put(keyCode, supplier);
		}
		return objMap;
	}

	private HashMap<String, List<ProLedgerDto>> listToMap(List<ProLedgerDto> resultLeList) {
		HashMap<String, List<ProLedgerDto>> objMap = new HashMap<String, List<ProLedgerDto>>();
		List<ProLedgerDto> objList = null;
		for(ProLedgerDto ledger : resultLeList){
			String keyCode = ledger.getMasterId();
			if(objMap.containsKey(keyCode)){
				objList = objMap.get(keyCode);
				objList.add(ledger);
			}else{
				objList = new ArrayList<ProLedgerDto>();
				objList.add(ledger);
			}
			objMap.put(keyCode, objList);
		}
		return objMap;
	}
	
}

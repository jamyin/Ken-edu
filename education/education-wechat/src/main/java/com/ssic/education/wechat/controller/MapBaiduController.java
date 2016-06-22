package com.ssic.education.wechat.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ssic.educateion.common.dto.BaiduHistoryDto;
import com.ssic.educateion.common.dto.BaiduPointsDto;
import com.ssic.educateion.common.dto.ProLedgerDto;
import com.ssic.educateion.common.dto.ProLedgerMasterDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.educateion.common.utils.BaiduMapUtils;
import com.ssic.education.handle.service.IProLedgerMasterService;
import com.ssic.education.handle.service.ProLedgerService;
import com.ssic.education.handle.service.ProSupplierService;
import com.ssic.education.handle.service.ProWaresService;
import com.ssic.education.utils.util.DateUtils;
import com.ssic.education.utils.util.HttpClientUtil;
import com.ssic.education.utils.util.PropertiesUtils;

@Controller
@RequestMapping(value="/wap/map")
public class MapBaiduController extends BaseController{
	
	@Autowired
	private ProLedgerService proLedgerService;
	
	@Autowired
	private IProLedgerMasterService iProLedgerMasterService;
	
	
	@Autowired
	private ProWaresService proWaresService;
	
	
	@Autowired
	private ProSupplierService proSupplierService;
	
	
	@RequestMapping(value="show/{masterId}")
	public ModelAndView show(@PathVariable String masterId){
		ModelAndView mv = getModelAndView();

		ProLedgerMasterDto resultDto = iProLedgerMasterService.searchProLedgerMasterDto(masterId);
		
		ProSupplierDto supplierDto = new ProSupplierDto();
		
		List<BaiduPointsDto> points = null;//new ArrayList<BaiduPointsDto>();
		
		if(resultDto!=null){
			supplierDto = proSupplierService.findById(resultDto.getSourceId());//获取企业信息
			List<String> ledgerMasterIds = new ArrayList<String>();
			ledgerMasterIds.add(masterId);
			
			List<ProLedgerDto> resultLeList = proLedgerService.searchProLedger(ledgerMasterIds);
			resultDto.setResltList(resultLeList);
			
			List<String> wareIds = new ArrayList<String>();
			for(ProLedgerDto ledger : resultLeList){
				wareIds.add(ledger.getWaresId());
			}
			if(!wareIds.isEmpty()){
				List<ProWaresDto> wareList = proWaresService.searchWarseList(wareIds);
				resultDto.setWareList(wareList);
			}		
			
			try {
//				points = ShowMap.getHistory(resultDto).getPoints();
				points = BaiduMapUtils.getHistory(resultDto).getPoints();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(points!=null && points.size()>0){
				for(BaiduPointsDto bp : points){
					bp.setX(bp.getLocation()[0]);
					bp.setY(bp.getLocation()[1]);
				}							
			}
		}
		
		mv.addObject("historyList", points);
		
		mv.addObject("supplierDto", supplierDto);
		
		mv.addObject("resultDto", resultDto);
		
		mv.addObject("baiduAk",PropertiesUtils.getProperty("baidu.ditu.ak"));
		mv.setViewName("dispatching_c");
		return mv;
	}
	
}

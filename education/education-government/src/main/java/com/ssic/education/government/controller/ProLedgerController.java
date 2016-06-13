package com.ssic.education.government.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ssic.educateion.common.dto.BaiduHistoryDto;
import com.ssic.educateion.common.dto.BaiduPointsDto;
import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProLedgerMasterDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.government.controller.supplier.ProSupplierController;
import com.ssic.education.handle.service.IProLedgerMasterService;
import com.ssic.education.handle.service.ProLedgerService;
import com.ssic.education.handle.service.ProSupplierService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.HttpClientUtil;
import com.ssic.education.utils.util.PropertiesUtils;

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
	
	@Autowired
	private IProLedgerMasterService iProLedgerMasterService;
	
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
		
		ProLedgerMasterDto resultDto = iProLedgerMasterService.searchProLedgerMasterDto(ledgerDto.getMasterId());
		//地图展示方法
		List<BaiduPointsDto> points = new ArrayList<BaiduPointsDto>();
		points = getHistory(resultDto).getPoints();
		if(points!=null && points.size()>0){
			for(BaiduPointsDto bp : points){
				bp.setX(bp.getLocation()[0]);
				bp.setY(bp.getLocation()[1]);
			}							
		}
		mv.addObject("historyList", points);
		
		mv.addObject("baiduAk",PropertiesUtils.getProperty("baidu.ditu.ak"));
		
		return mv;
	}
	
	
	public BaiduHistoryDto getHistory(ProLedgerMasterDto resultDto){
		String baidu_getHistory_url = PropertiesUtils.getProperty("baidu.ditu.url");
		String startTime = "";
		String endTime = "";
		if(resultDto.getStartTime()!=null){
			startTime = String.valueOf(resultDto.getStartTime().getTime());	
		}
		if(resultDto.getStartTime()!=null){
			endTime = String.valueOf(resultDto.getEndTime().getTime());	
		}		
//		String reqURL = "ak=YN0mfG1VM2jrGV5jBB7RD6lKKmrDZA43&service_id=117192&entity_name=8438B07A-2B4C-49B7-8523-5A177081F602&start_time=1463695529&end_time=1463767529";
		String reqURL = "ak="+PropertiesUtils.getProperty("baidu.ditu.ak")+"&service_id="+PropertiesUtils.getProperty("baidu.ditu.serviceId")+"&entity_name="+resultDto.getId()+"&start_time="+startTime+"&end_time="+endTime+"";
		String json = HttpClientUtil.sendGetRequest(baidu_getHistory_url+reqURL, null);
		BaiduHistoryDto history = new Gson().fromJson(json, BaiduHistoryDto.class);
		return history;
	}
}

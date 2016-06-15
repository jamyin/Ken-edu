package com.ssic.education.wechat.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ssic.educateion.common.dto.BaiduHistoryDto;
import com.ssic.educateion.common.dto.BaiduPointsDto;
import com.ssic.educateion.common.dto.ProLedgerDto;
import com.ssic.educateion.common.dto.ProLedgerMasterDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.service.IProLedgerMasterService;
import com.ssic.education.handle.service.ProLedgerService;
import com.ssic.education.handle.service.ProSupplierService;
import com.ssic.education.handle.service.ProWaresService;
import com.ssic.education.utils.util.DateUtils;
import com.ssic.education.utils.util.HttpClientUtil;
import com.ssic.education.utils.util.PropertiesUtils;

public class ShowMap {

	public static BaiduHistoryDto getHistory(ProLedgerMasterDto resultDto) throws ParseException{
		String baidu_getHistory_url = PropertiesUtils.getProperty("baidu.ditu.url");
		String startTime = "";
		String endTime = "";
		if(resultDto.getStartTime()!=null){
			startTime = DateUtils.dateToTimestamp(resultDto.getStartTime());	
		}
		if(resultDto.getStartTime()!=null){
			endTime = DateUtils.dateToTimestamp(resultDto.getEndTime());//String.valueOf(resultDto.getEndTime().getTime());	
		}		
//		String reqURL = "ak=YN0mfG1VM2jrGV5jBB7RD6lKKmrDZA43&service_id=117192&entity_name=8438B07A-2B4C-49B7-8523-5A177081F602&start_time=1463695529&end_time=1463767529";
		String reqURL = "ak="+PropertiesUtils.getProperty("baidu.ditu.ak")+"&service_id="+PropertiesUtils.getProperty("baidu.ditu.serviceId")+"&entity_name="+resultDto.getId()+"&start_time="+startTime+"&end_time="+endTime+"";
		
		String json = HttpClientUtil.sendGetRequest(baidu_getHistory_url+reqURL, null);
		BaiduHistoryDto history = new Gson().fromJson(json, BaiduHistoryDto.class);
		return history;
	}
	
}

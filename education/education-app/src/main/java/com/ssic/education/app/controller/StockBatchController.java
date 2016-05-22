package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.LedgerInfoDto;
import com.ssic.education.app.service.ILedgerInfoService;
import com.ssic.education.utils.model.Response;
/**		
 * <p>Title: StockBatchController </p>
 * <p>Description: 库存批次控制器类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月16日 上午10:05:32	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月16日 上午10:05:32</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping(value = "/stockbatch")
public class StockBatchController {

	@Autowired
	private ILedgerInfoService ledgerInfoService;

	/**
	 * 
	 * getMaterialInfo：批次信息：根据批次id查批次信息（需带出收货商信息）
	 * 原料批次信息：根据原料批次id查原料批次信息（需带出供应商信息）
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月16日 上午10:10:50
	 */
	@RequestMapping(value = "/info/{batchNo}", method = RequestMethod.GET)
	@ResponseBody
	public Response<LedgerInfoDto> getMaterialInfo(@PathVariable("batchNo") String batchNo) {
		Response<LedgerInfoDto> result = new Response<LedgerInfoDto>();
		LedgerInfoDto waresInfoList = ledgerInfoService.findLedgerByBatchNo(batchNo);
		result.setData(waresInfoList);
		return result;
	}
}

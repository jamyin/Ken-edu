package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.LedgerInfoDto;
import com.ssic.education.app.dto.LedgerMasterInfoDto;
import com.ssic.education.app.dto.LedgerMasterListDto;
import com.ssic.education.app.service.ILedgerInfoService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
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
	 * 批次信息：根据批次id查批次信息（需带出收货商信息）
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

	/**
	 * 根据学校查询是收获是ID查询配送列表
	 * getMaterialInfo：一句话描述方法功能
	 * @param receiverId
	 * @param query
	 * @return
	 * @exception	
	 * @author Administrator
	 * @date 2016年5月27日 下午2:24:06
	 */
	@RequestMapping(value = "/list/{receiverId}", method = RequestMethod.POST)
	@ResponseBody
	public Response<PageResult<LedgerMasterListDto>> getMaterialInfo(@PathVariable("receiverId") String receiverId, PageQuery query) {
		Response<PageResult<LedgerMasterListDto>> result = new Response<PageResult<LedgerMasterListDto>>();
		PageResult<LedgerMasterListDto> ledgerInfoDto = ledgerInfoService.findMasterList(receiverId, query);
		result.setData(ledgerInfoDto);
		return result;
	}

	/**
	 * 根据驾驶员查询配送列表
	 * getMaterialInfo：一句话描述方法功能
	 * @param receiverId
	 * @param query
	 * @return
	 * @exception	
	 * @author Administrator
	 * @date 2016年5月27日 下午2:24:06
	 */
	@RequestMapping(value = "/driverlist/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public Response<PageResult<LedgerMasterListDto>> getMaterialByUser(@PathVariable("userId") String userId, PageQuery query) {
		Response<PageResult<LedgerMasterListDto>> result = new Response<PageResult<LedgerMasterListDto>>();
		PageResult<LedgerMasterListDto> ledgerInfoDto = ledgerInfoService.findMasterDriverList(userId, query);
		result.setData(ledgerInfoDto);
		return result;
	}

	/**
	 * 根据ID查询配送信息并带出货物列表
	 * getMasterInfoById
	 * @param id
	 * @param query
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月27日 下午2:39:55
	 */
	@RequestMapping(value = "/master/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Response<LedgerMasterInfoDto> getMasterInfoById(@PathVariable("id") String id, PageQuery query) {
		Response<LedgerMasterInfoDto> result = new Response<LedgerMasterInfoDto>();
		LedgerMasterInfoDto LedgerInfoDto = ledgerInfoService.findMasterById(id, query);
		result.setData(LedgerInfoDto);
		return result;
	}

	@RequestMapping(value = "/updateStatus/{id}/{status}", method = RequestMethod.GET)
	@ResponseBody
	public Response<Integer> updateStatus(@PathVariable("id") String id, @PathVariable("status") String status) {
		Response<Integer> result = new Response<Integer>();
		int num = ledgerInfoService.updateStatus(id, status);
		if (num != -1) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("提交成功！");
			result.setData(num);
			return result;
		} else {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("请求失败！");
			result.setData(num);
			return result;
		}
	}
}

package com.ssic.education.provider.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.LedgerAddressDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.service.ILedgerAddressService;
import com.ssic.education.provider.dto.TImsUsersDto;

/**
 * 
 * Description: 配货管理控制器类
 * 
 * Company: 上海天坊信息科技有限公司
 * 
 * @author minghai_chen
 * @date 2016年5月18日 下午2:2:53
 * @version 1.0
 */
@Controller
@RequestMapping("/ledgerAddressController")
public class LedgerAddressController {
	
	@Autowired
	private ILedgerAddressService ledgerAddressService;
	
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "ledger/ledgerAddressList";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(LedgerAddressDto lad, HttpSession session, PageHelper ph) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		lad.setSupplierId(user.getSourceId());
		DataGrid dataGrid = new DataGrid();
		return ledgerAddressService.findAllLedgerAddress(lad, ph);
	}
	
}

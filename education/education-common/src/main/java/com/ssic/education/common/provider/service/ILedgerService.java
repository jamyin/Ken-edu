package com.ssic.education.common.provider.service;

import java.util.List;

import com.ssic.education.common.pojo.ProLedger;
import com.ssic.education.common.provider.dto.LedgerDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;

public interface ILedgerService {

	DataGrid findAllLedger(LedgerDto ld, PageHelper ph);

	int saveLedger(List<LedgerDto> ledger);

	/**
	 * 批量添加ledger
	 * 
	 * @param list
	 * @author zhangjiwei
	 * @since 2016.5.21
	 */
	public void addProLedger(List<ProLedger> list);
}

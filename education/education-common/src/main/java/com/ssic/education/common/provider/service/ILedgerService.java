package com.ssic.education.common.provider.service;

import java.util.List;

import com.ssic.education.common.provider.dto.LedgerDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;

public interface ILedgerService {

	DataGrid findAllLedger(LedgerDto ld, PageHelper ph);

	int saveLedger(List<LedgerDto> ledger);

	List<LedgerDto> findLedgerById(String sourceId, String wareBatchNo);

	int updataLedger(List<LedgerDto> ledger);

	int deleteLedger(String sourceId, String wareBatchNo);

}

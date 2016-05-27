package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;

public interface ILedgerService {

	DataGrid findAllLedger(LedgerDto ld, PageHelper ph);

	int saveLedger(List<LedgerDto> ledger);

	List<LedgerDto> findLedgerByMasterId(String sourceId, String masterId);

	int updataLedger(List<LedgerDto> ledger);

	int deleteLedger(String sourceId, String wareBatchNo);

	int findWareBatchNo(LedgerDto ledgerDto);

}

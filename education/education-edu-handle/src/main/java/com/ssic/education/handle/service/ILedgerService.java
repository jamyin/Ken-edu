package com.ssic.education.handle.service;

import java.util.List;
import java.util.Map;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.pojo.ProLedger;
import com.ssic.education.handle.pojo.ProLedgerMaster;

public interface ILedgerService {

	DataGrid findAllLedger(LedgerDto ld, PageHelper ph);

	int saveLedger(List<LedgerDto> ledger);

	List<LedgerDto> findLedgerByMasterId(String sourceId, String masterId);

	int updataLedger(List<LedgerDto> ledger);

	int deleteLedger(String sourceId, String wareBatchNo);

	int findWareBatchNo(String wareBatchNo,String sourceId);
	
	int importLedger(Map<ProLedgerMaster, List<ProLedger>> map);

	Map<ProLedgerMaster,List<ProLedger>> findExportProSupplier(LedgerDto ld);

}

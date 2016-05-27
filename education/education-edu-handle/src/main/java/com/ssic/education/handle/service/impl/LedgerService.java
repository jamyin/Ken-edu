package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.dao.ProLedgerDao;
import com.ssic.education.handle.service.ILedgerService;

@Service
public class LedgerService implements ILedgerService {

	@Autowired
	private ProLedgerDao ledgerDao;

	
	public DataGrid findAllLedger(LedgerDto ld, PageHelper ph) {
		return ledgerDao.findAllLedger(ld, ph);
	}

	
	public int saveLedger(List<LedgerDto> ledger) {
		return ledgerDao.saveLedger(ledger);
	}

	
	public List<LedgerDto> findLedgerById(String sourceId,
			String wareBatchNo) {
		return ledgerDao.findLedgerById(sourceId,wareBatchNo);
	}

	
	public int updataLedger(List<LedgerDto> ledger) {
		return ledgerDao.updataLedger(ledger);
	}

	
	public int deleteLedger(String sourceId, String wareBatchNo) {
		return ledgerDao.deleteLedger(sourceId,wareBatchNo);
	}

	
	public int findWareBatchNo(LedgerDto ledgerDto) {
		return ledgerDao.findWareBatchNo(ledgerDto);
	}

}

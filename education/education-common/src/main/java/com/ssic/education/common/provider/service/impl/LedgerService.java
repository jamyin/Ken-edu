package com.ssic.education.common.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProLedgerDao;
import com.ssic.education.common.provider.dto.LedgerDto;
import com.ssic.education.common.provider.service.ILedgerService;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;

@Service
public class LedgerService implements ILedgerService {

	@Autowired
	private ProLedgerDao ledgerDao;

	@Override
	public DataGrid findAllLedger(LedgerDto ld, PageHelper ph) {
		return ledgerDao.findAllLedger(ld, ph);
	}

	@Override
	public int saveLedger(List<LedgerDto> ledger) {
		return ledgerDao.saveLedger(ledger);
	}

	@Override
	public List<LedgerDto> findLedgerById(String sourceId,
			String wareBatchNo) {
		return ledgerDao.findLedgerById(sourceId,wareBatchNo);
	}

	@Override
	public int updataLedger(List<LedgerDto> ledger) {
		return ledgerDao.updataLedger(ledger);
	}

	@Override
	public int deleteLedger(String sourceId, String wareBatchNo) {
		return ledgerDao.deleteLedger(sourceId,wareBatchNo);
	}

}

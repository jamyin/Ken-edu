package com.ssic.education.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.provider.dao.LedgerDao;
import com.ssic.education.provider.dto.LedgerDto;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.LedgerModel;
import com.ssic.education.provider.service.ILedgerService;

@Service
public class LedgerService implements ILedgerService {

	@Autowired
	private LedgerDao ledgerDao;

	@Override
	public DataGrid findAllLedger(LedgerDto ld, PageHelper ph) {
		return ledgerDao.findAllLedger(ld, ph);
	}

	@Override
	public List<TImsUsersDto> findAllDriver(String sourceId) {
		return ledgerDao.findAllDriver(sourceId);
	}

	@Override
	public int saveLedger(List<LedgerDto> ledger) {
		return ledgerDao.saveLedger(ledger);
	}

}

package com.ssic.education.handle.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.dao.ProLedgerDao;
import com.ssic.education.handle.mapper.ProLedgerMapper;
import com.ssic.education.handle.mapper.ProLedgerMasterMapper;
import com.ssic.education.handle.pojo.ProLedger;
import com.ssic.education.handle.pojo.ProLedgerMaster;
import com.ssic.education.handle.service.ILedgerService;

@Service
public class LedgerService implements ILedgerService {

	@Autowired
	private ProLedgerDao ledgerDao;

	@Autowired
	private ProLedgerMasterMapper lmm;

	@Autowired
	private ProLedgerMapper lm;

	@Override
	public DataGrid findAllLedger(LedgerDto ld, PageHelper ph) {
		return ledgerDao.findAllLedger(ld, ph);
	}

	@Override
	public int saveLedger(List<LedgerDto> ledger) {
		return ledgerDao.saveLedger(ledger);
	}

	@Override
	public List<LedgerDto> findLedgerByMasterId(String sourceId, String masterId) {
		return ledgerDao.findLedgerByMasterId(sourceId, masterId);
	}

	@Override
	public int updataLedger(List<LedgerDto> ledger) {
		return ledgerDao.updataLedger(ledger);
	}

	@Override
	public int deleteLedger(String sourceId, String wareBatchNo) {
		return ledgerDao.deleteLedger(sourceId, wareBatchNo);
	}

	@Override
	public int findWareBatchNo(LedgerDto ledgerDto) {
		return ledgerDao.findWareBatchNo(ledgerDto);
	}

	@Override
	public int importLedger(Map<ProLedgerMaster, List<ProLedger>> map) {
		for (ProLedgerMaster o : map.keySet()) {
			lmm.insertSelective(o);
			List<ProLedger> list = map.get(o);
			for (ProLedger oo : list) {
				lm.insertSelective(oo);
			}
		}
		return 0;
	}

}

package com.ssic.education.common.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProLedgerDao;
import com.ssic.education.common.mapper.ProLedgerMapper;
import com.ssic.education.common.pojo.ProLedger;
import com.ssic.education.common.provider.dto.LedgerDto;
import com.ssic.education.common.provider.service.ILedgerService;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;

@Service
public class LedgerService implements ILedgerService {

	@Autowired
	private ProLedgerDao ledgerDao;
	
	@Autowired
	private ProLedgerMapper mapper;

	@Override
	public DataGrid findAllLedger(LedgerDto ld, PageHelper ph) {
		return ledgerDao.findAllLedger(ld, ph);
	}

	@Override
	public int saveLedger(List<LedgerDto> ledger) {
		return ledgerDao.saveLedger(ledger);
	}

	/**
	 * 批量添加ledger
	 * 
	 * @param list
	 * @author zhangjiwei
	 * @since 2016.5.21
	 */
	public void addProLedger(List<ProLedger> list) {
		for (ProLedger o : list) {
			mapper.insertSelective(o);
		}
	}
	
}

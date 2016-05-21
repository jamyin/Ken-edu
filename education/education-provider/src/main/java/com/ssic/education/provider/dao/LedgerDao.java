package com.ssic.education.provider.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.provider.dto.LedgerDto;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.mapper.LedgerExMapper;

@Repository
public class LedgerDao {

	@Autowired
	private LedgerExMapper exMapper;

	public DataGrid findAllLedger(LedgerDto ld, PageHelper ph) {
		DataGrid dataGrid = new DataGrid();
		Long total = exMapper.countAllLedger(ld);
		dataGrid.setTotal(total);
		int beginRow = (ph.getPage() - 1) * ph.getRows();
		ph.setBeginRow(beginRow);
		dataGrid.setRows(exMapper.findAllLedger(ld, ph));
		return dataGrid;
	}

	public List<TImsUsersDto> findAllDriver(String sourceId) {
		return exMapper.findAllDriver(sourceId);
	}

	public int saveLedger(List<LedgerDto> ledger) {
		ledger.get(0).setCreateTime(new Date());
		ledger.get(0).setLastUpdateTime(ledger.get(0).getCreateTime());
		ledger.get(0).setStat(1);
		exMapper.insertLedger(ledger);
		return 0;
	}

}

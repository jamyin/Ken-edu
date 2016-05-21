package com.ssic.education.provider.service;

import java.util.List;

import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.provider.dto.LedgerDto;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.LedgerModel;

public interface ILedgerService {

	DataGrid findAllLedger(LedgerDto ld, PageHelper ph);

	List<TImsUsersDto> findAllDriver(String sourceId);

	int saveLedger(List<LedgerDto> ledger);

}

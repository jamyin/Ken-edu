package com.ssic.education.common.government.service;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.government.dto.ProLedgerDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

public interface ProLedgerService {

	public PageResult<ProSupplierDto> findPage(ProSupplierDto dto,PageQuery page);
	
	public PageResult<ProLedgerDto> findLedgerPage(ProLedgerDto proLedgerDto,PageQuery page);
	
	public ProLedgerDto findById(String id);
}

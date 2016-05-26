package com.ssic.education.handle.service;

import com.ssic.educateion.common.dto.ProLedgerDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

public interface ProLedgerService {

	public PageResult<ProSupplierDto> findPage(ProSupplierDto dto,PageQuery page);
	
	public PageResult<ProLedgerDto> findLedgerPage(ProLedgerDto proLedgerDto,PageQuery page);
	
	public ProLedgerDto findById(String id);
}

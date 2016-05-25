package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.provider.dto.LedgerDto;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.utils.model.PageQuery;

public interface ProLedgerMasterExMapper {

	Long countAllLedger(@Param("ledgerDto") LedgerDto ld);

	List<LedgerDto> findAllLedger(@Param("ledgerDto") LedgerDto ld,
			@Param("ph") PageHelper ph);
	
	int insertLedgerMaster(@Param("ledger")LedgerDto ledgerDto);

}

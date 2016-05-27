package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.utils.PageHelper;

public interface ProLedgerMasterExMapper {

	Long countAllLedger(@Param("ledgerDto") LedgerDto ld);

	List<LedgerDto> findAllLedger(@Param("ledgerDto") LedgerDto ld,
			@Param("ph") PageHelper ph);
	
	int insertLedgerMaster(@Param("ledger")LedgerDto ledgerDto);

	int updateLedgerMaster(@Param("ledger")LedgerDto ledgerDto);

	int deleteLedgerMaster(@Param("sourceId")String sourceId,@Param("masterId") String masterId);

}

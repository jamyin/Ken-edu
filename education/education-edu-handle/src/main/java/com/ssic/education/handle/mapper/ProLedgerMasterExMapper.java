package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.utils.model.PageQuery;

public interface ProLedgerMasterExMapper {

	Long countAllLedger(@Param("ledgerDto") LedgerDto ld);

	List<LedgerDto> findAllLedger(@Param("ledgerDto") LedgerDto ld,
			@Param("ph") PageHelper ph);
	
	List<LedgerDto> selectLedgerList(@Param("ledgerDto")LedgerDto ledgerDto);
	
	List<LedgerDto> selectLedgerListOrderby(@Param("ledgerDto")LedgerDto ledgerDto,@Param("page") PageQuery page);
	
	long countLedgerListOrderby(@Param("ledgerDto")LedgerDto ledgerDto);
	
	int insertLedgerMaster(@Param("ledger")LedgerDto ledgerDto);

	int updateLedgerMaster(@Param("ledger")LedgerDto ledgerDto);

	int deleteLedgerMaster(@Param("sourceId")String sourceId,@Param("masterId") String masterId);

}

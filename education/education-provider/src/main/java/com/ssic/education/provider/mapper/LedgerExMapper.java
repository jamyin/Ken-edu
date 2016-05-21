package com.ssic.education.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.pojo.ProRecycleOil;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.provider.dto.LedgerDto;
import com.ssic.education.provider.dto.RecycleOilDto;
import com.ssic.education.provider.dto.TImsUsersDto;

public interface LedgerExMapper {
	
	Long countAllLedger(@Param("ledgerDto")LedgerDto ld);

	List<LedgerDto> findAllLedger(@Param("ledgerDto")LedgerDto ld, @Param("ph")PageHelper ph);

	List<TImsUsersDto> findAllDriver(String sourceId);

	int insertLedger(@Param("ledgerList")List<LedgerDto> ledgerList);

}

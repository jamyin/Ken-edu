package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.LedgerAddressDto;
import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.utils.PageHelper;

public interface EduSchoolSupplierExMapper {

	List<LedgerAddressDto> findAllLedgerAddress(@Param("ledgerAddress")LedgerAddressDto lad, @Param("ph")PageHelper ph);

	Long countAllLedgerAddress(@Param("ledgerAddress")LedgerAddressDto lad);
	
	String findSchoolIdByReceiverId(@Param("ledgerDto") LedgerDto ld);
	
}

package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.provider.dto.LedgerAddressDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;

public interface EduSchoolSupplierExMapper {

	List<LedgerAddressDto> findAllLedgerAddress(@Param("ledgerAddress")LedgerAddressDto lad, @Param("ph")PageHelper ph);

	Long countAllLedgerAddress(@Param("ledgerAddress")LedgerAddressDto lad);
	

}

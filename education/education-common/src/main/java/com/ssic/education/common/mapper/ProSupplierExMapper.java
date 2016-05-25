package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.provider.dto.LedgerDto;
import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.common.provider.utils.PageHelper;

public interface ProSupplierExMapper {

	String findSupplierIdByName(@Param("supplierName")String supplierName);

	List<SupplierDto> findProSupplier(@Param("supplierDto")SupplierDto supplierDto,@Param("ph")PageHelper ph);

	ProSupplierDto findSupplierDetail(String id);

	SupplierDto findProSupplierById(String id);

	int updateByPrimaryKeySelective(SupplierDto record);
	
	int insert(SupplierDto record);

	List<SupplierDto> lookRelatingWares(@Param("dto") ProSupplierDto dto);

	List<SupplierDto> findSupplierCodeByReceiverId(@Param("supplierId")String supplierId);

	String findSupplierIdBySourceId(@Param("ledgerDto") LedgerDto ledgerDto);
	
	
}

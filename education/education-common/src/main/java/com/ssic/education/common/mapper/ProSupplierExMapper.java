package com.ssic.education.common.mapper;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProSupplierDto;

public interface ProSupplierExMapper {

	String findSupplierIdByName(@Param("supplierName")String supplierName);

	ProSupplierDto findSupplierDetail(String id);

}

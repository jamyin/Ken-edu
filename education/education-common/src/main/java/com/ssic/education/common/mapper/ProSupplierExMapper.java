package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProSupplierDto;

import com.ssic.education.common.dto.ProSupplierDto;

public interface ProSupplierExMapper {

	String findSupplierIdByName(@Param("supplierName")String supplierName);

	List<ProSupplierDto> findAllProSupplier();

	ProSupplierDto findSupplierDetail(String id);


}

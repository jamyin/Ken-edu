package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.provider.service.dto.SupplierDto;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.utils.model.PageQuery;

public interface ProSupplierExMapper {

	String findSupplierIdByName(@Param("supplierName")String supplierName);

	List<SupplierDto> findProSupplier(@Param("supplierDto")SupplierDto supplierDto,@Param("ph")PageHelper ph);

	ProSupplierDto findSupplierDetail(String id);

	ProSupplierDto findProSupplierById(String id);


}

package com.ssic.education.common.mapper;

import org.apache.ibatis.annotations.Param;

public interface ProSupplierExMapper {

	String findSupplierIdByName(@Param("supplierName")String supplierName);

}

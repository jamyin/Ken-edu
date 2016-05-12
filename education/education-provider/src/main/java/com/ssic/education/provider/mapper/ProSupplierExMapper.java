package com.ssic.education.provider.mapper;

import org.apache.ibatis.annotations.Param;

public interface ProSupplierExMapper {

	String findSupplierIdByName(@Param("supplierName")String supplierName);

}

package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.utils.model.PageQuery;

public interface ProLedgerExMapper {

	public List<ProSupplierDto> selectSupplierByReceiverId(@Param("proSupplierDto") ProSupplierDto proSupplierDto,@Param("page") PageQuery page);
	
	long countSupplier(@Param("proSupplierDto") ProSupplierDto proSupplierDto);
}

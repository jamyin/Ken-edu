package com.ssic.education.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.provider.dto.LedgerDto;
import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProWaresDto;

public interface WaresExMapper {

 List<ProWaresDto> findWares(@Param("warseDto")ProWaresDto waresDto,@Param("page") PageHelperDto ph);

List<ProWaresDto> findWaresById(@Param("proWaresDto")ProWaresDto proWaresDto);

List<SupplierDto> lookSupplier(@Param("dto")ProWaresDto dto);

String findWaresIdBySupplierId(@Param("ledgerDto") LedgerDto ledgerDto);


}

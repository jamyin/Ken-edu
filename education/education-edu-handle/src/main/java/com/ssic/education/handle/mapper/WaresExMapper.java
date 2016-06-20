package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.educateion.common.utils.PageHelperDto;

public interface WaresExMapper {

 List<ProWaresDto> findWares(@Param("warseDto")ProWaresDto waresDto,@Param("page") PageHelperDto ph);

List<ProWaresDto> findWaresById(@Param("proWaresDto")ProWaresDto proWaresDto);


int findAllWaresCount(@Param("dto")ProWaresDto waresDto);
<<<<<<< HEAD

ProWaresDto findWaresBySupplierId(@Param("ledger")LedgerDto ledger);

void deleteWares(@Param("warseDto") ProWaresDto waresDto);
=======

ProWaresDto findWaresBySupplierId(@Param("ledger")LedgerDto ledger);

void deleteWares(@Param("warseDto") ProWaresDto waresDto);
>>>>>>> branch 'master' of http://192.168.1.231/group-one/education.git


}

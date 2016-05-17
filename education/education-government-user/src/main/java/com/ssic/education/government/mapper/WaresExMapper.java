package com.ssic.education.government.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProWaresDto;
import com.ssic.education.government.dto.PageHelperDto;

public interface WaresExMapper {

 List<ProWaresDto> findWares(@Param("warseDto")ProWaresDto waresDto,@Param("page") PageHelperDto ph);

List<ProWaresDto> findWaresById(@Param("proWaresDto")ProWaresDto proWaresDto);


}

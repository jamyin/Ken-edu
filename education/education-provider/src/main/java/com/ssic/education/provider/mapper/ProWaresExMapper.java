package com.ssic.education.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProWaresDto;
import com.ssic.education.provider.pageModel.PageHelper;

public interface ProWaresExMapper {

 List<ProWaresDto> findWares(@Param("warseDto")ProWaresDto waresDto,@Param("page") PageHelperDto ph);

List<ProWaresDto> findWaresById(@Param("proWaresDto")ProWaresDto proWaresDto);


}

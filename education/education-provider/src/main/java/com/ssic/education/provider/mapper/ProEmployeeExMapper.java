package com.ssic.education.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProEmployeeDto;

public interface ProEmployeeExMapper {

	List<ProEmployeeDto> findAllEmployee(@Param("pe") ProEmployeeDto pe, @Param("phdto") PageHelperDto phdto);

}

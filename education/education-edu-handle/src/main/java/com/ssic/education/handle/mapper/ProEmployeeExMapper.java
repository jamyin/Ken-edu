package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.ProEmployeeDto;
import com.ssic.educateion.common.utils.PageHelperDto;

public interface ProEmployeeExMapper {

	List<ProEmployeeDto> findAllEmployee(@Param("pe") ProEmployeeDto pe, @Param("phdto") PageHelperDto phdto);

}

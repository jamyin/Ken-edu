package com.ssic.education.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.admin.dto.TImsMenuTypeDto;
import com.ssic.education.admin.pojo.MenuType;

public interface TImsMenuTypeExMapper {

	MenuType findById(@Param("menuTypeId") String menuTypeId);

	List<TImsMenuTypeDto> findAll();

}

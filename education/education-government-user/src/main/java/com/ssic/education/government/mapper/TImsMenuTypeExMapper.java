package com.ssic.education.government.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.government.dto.TImsMenuTypeDto;
import com.ssic.education.government.pojo.EduMenuType;

public interface TImsMenuTypeExMapper {

	EduMenuType findById(@Param("menuTypeId") String menuTypeId);

	List<TImsMenuTypeDto> findAll();

}

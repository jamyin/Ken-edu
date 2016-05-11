package com.ssic.education.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.provider.dto.TImsMenuTypeDto;
import com.ssic.education.provider.pojo.ProMenuType;

public interface TImsMenuTypeExMapper {

	ProMenuType findById(@Param("menuTypeId") String menuTypeId);

	List<TImsMenuTypeDto> findAll();

}

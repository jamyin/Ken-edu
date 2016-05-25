package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.pojo.ProNutritional;


public interface ProNutritionalExMapper {

	List<ProNutritional> selectAllNutritional();

	List<ProNutritional> selectAllNutritionalUnit();

	int addNutritionalBatch(@Param("list") List<ProNutritional> list);

}

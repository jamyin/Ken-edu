package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.handle.pojo.ProNutritional;


public interface ProNutritionalExMapper {

	List<ProNutritional> selectAllNutritional();

	List<ProNutritional> selectAllNutritionalUnit();

	int addNutritionalBatch(@Param("list") List<ProNutritional> list);

}

package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.RecycleOilDto;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.pojo.ProRecycleOil;

public interface RecycleOilExMapper {

	List<RecycleOilDto> findAllRecycleOil(@Param("recycleOilDto") RecycleOilDto rod,
			@Param("ph") PageHelper ph);

	RecycleOilDto findRecycleOilById(@Param("sourceId")String sourceId,@Param("id")String id);

	int updateByPrimaryKeySelective(RecycleOilDto rod);

	int insert(RecycleOilDto rod);

	int deleteRecycleOil(ProRecycleOil pro);

}

package com.ssic.education.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.pojo.ProRecycleOil;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.provider.dto.RecycleOilDto;

public interface RecycleOilExMapper {

	List<RecycleOilDto> findAllRecycleOil(@Param("recycleOilDto") RecycleOilDto rod,
			@Param("ph") PageHelper ph);

	RecycleOilDto findRecycleOilById(@Param("sourceId")String sourceId,@Param("id")String id);

	int updateByPrimaryKeySelective(RecycleOilDto rod);

	int insert(RecycleOilDto rod);

	int deleteRecycleOil(ProRecycleOil pro);

}

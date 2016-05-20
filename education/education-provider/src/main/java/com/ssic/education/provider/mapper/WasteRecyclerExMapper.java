package com.ssic.education.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.provider.dto.RecycleOilDto;

public interface WasteRecyclerExMapper {

	String findRecycleBySourceId(@Param("sourceId")String sourceId,@Param("type")String type);

	String findRecycleIdBySourceId(@Param("sourceId")String supplierId, @Param("type")String type);

}

package com.ssic.education.handle.mapper;

import org.apache.ibatis.annotations.Param;

public interface WasteRecyclerExMapper {

	String findRecycleBySourceId(@Param("sourceId")String sourceId,@Param("type")String type);

	String findRecycleIdBySourceId(@Param("sourceId")String supplierId, @Param("type")String type);

}

package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.EduTaskDto;
import com.ssic.education.utils.model.PageQuery;


public interface EduTaskExMapper {

	List<EduTaskDto> findTaskListById(@Param("id") String id,@Param("readstat") int readstat,@Param("query")  PageQuery query);

	int selectTaskAccount(@Param("id") String id,@Param("readstat") int readstat);

}

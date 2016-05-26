package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.EduTaskReadDto;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.education.utils.model.PageQuery;

public interface EduTaskReceiveExMapper {
	List<EduTaskReadDto> findReadList(@Param("receiveDto") EduTaskReceiveDto receiveDto,
			@Param("query") PageQuery query);

	int selectReadAccount(@Param("receiveDto") EduTaskReceiveDto receiveDto);

	int addTaskReceiveBatch(@Param("list") List<EduTaskReceiveDto> list);

}

package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.EduTaskReadDto;
import com.ssic.education.common.dto.EduTaskReceiveDto;
import com.ssic.education.utils.model.PageQuery;

public interface EduTaskReceiveExMapper {
	List<EduTaskReadDto> findReadList(@Param("receiveDto") EduTaskReceiveDto receiveDto,
			@Param("query") PageQuery query);

	int selectReadAccount(@Param("receiveDto") EduTaskReceiveDto receiveDto);

	int addReceiveTaskBatch(@Param("receiveDtolist") List<EduTaskReceiveDto> receiveDtolist);

}

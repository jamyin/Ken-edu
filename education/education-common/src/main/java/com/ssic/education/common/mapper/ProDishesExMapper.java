package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;

public interface ProDishesExMapper {
	
	List<ProWaresDto> selectWaresByContact(@Param("proWaresDto") ProWaresDto proWaresDto,@Param("page") PageQuery page);
	
	Long countWares(@Param("proWaresDto") ProWaresDto proWaresDto);
	
}

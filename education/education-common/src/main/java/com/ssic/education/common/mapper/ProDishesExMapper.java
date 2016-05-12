package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProDishesDto;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;

public interface ProDishesExMapper {
	
	List<ProWaresDto> selectWaresByContact(@Param("proDishesDto") ProDishesDto proDishesDto,@Param("page") PageQuery page);
	
	Long countWares(@Param("proDishesDto") ProDishesDto proDishesDto);
	
}

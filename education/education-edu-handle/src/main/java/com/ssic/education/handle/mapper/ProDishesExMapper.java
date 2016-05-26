package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.pojo.ProDishes;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.utils.model.PageQuery;

public interface ProDishesExMapper {
	
	List<ProWaresDto> selectWaresByContact(@Param("proWaresDto") ProWaresDto proWaresDto,@Param("page") PageQuery page);
	
	Long countWares(@Param("proWaresDto") ProWaresDto proWaresDto);

	int addWaresBatch(@Param("list") List<ProWares> list);

	int addDishesBatch(@Param("list") List<ProDishes> list);
}

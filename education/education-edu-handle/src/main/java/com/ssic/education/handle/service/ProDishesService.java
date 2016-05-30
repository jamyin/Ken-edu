package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.ProDishesDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

public interface ProDishesService {
	
	public PageResult<ProWaresDto> findPage(ProWaresDto proWaresDto,PageQuery page);

	public List<ProDishesDto> searchDishes(List<String> packageIdList);

}

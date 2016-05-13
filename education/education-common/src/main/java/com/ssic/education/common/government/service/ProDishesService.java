package com.ssic.education.common.government.service;

import com.ssic.education.common.dto.ProDishesDto;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

public interface ProDishesService {
	
	public PageResult<ProWaresDto> findPage(ProDishesDto proDishesDto,PageQuery page);

}

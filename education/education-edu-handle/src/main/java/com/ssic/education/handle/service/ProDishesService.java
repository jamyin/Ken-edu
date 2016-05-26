package com.ssic.education.handle.service;

import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

public interface ProDishesService {
	
	public PageResult<ProWaresDto> findPage(ProWaresDto proWaresDto,PageQuery page);

}

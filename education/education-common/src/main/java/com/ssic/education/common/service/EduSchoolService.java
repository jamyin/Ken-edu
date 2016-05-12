package com.ssic.education.common.service;

import com.ssic.education.common.dao.EduSchoolDao;
import com.ssic.education.government.dto.EduSchoolDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

public interface EduSchoolService {

	public PageResult<EduSchoolDto> list(EduSchoolDto dto,PageQuery page);
	
	public EduSchoolDto findById (String id);
}

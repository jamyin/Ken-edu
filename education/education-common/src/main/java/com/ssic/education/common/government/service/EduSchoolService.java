package com.ssic.education.common.government.service;

import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.education.common.dto.ProLicenseDto;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

import java.util.List;

public interface EduSchoolService {

	PageResult<EduSchoolDto> list(EduSchoolDto dto, PageQuery page);
	
	EduSchoolDto findById (String id);

	List<EduSchoolDto> queryAll();
	
	public List<ProSupplierDto> getSupplier(String schoolId);
	
	public List<ProLicenseDto> getProLicenseBySchId(ProLicenseDto dto);
	
	public Integer updateSchool(EduSchoolDto dto);
}

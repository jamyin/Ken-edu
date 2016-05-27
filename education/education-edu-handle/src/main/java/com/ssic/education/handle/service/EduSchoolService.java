package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.SupplierReviewedDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

public interface EduSchoolService {

	PageResult<EduSchoolDto> list(EduSchoolDto dto, PageQuery page);
	
	EduSchoolDto findById (String id);

	List<EduSchoolDto> queryAll();
	
	public List<ProSupplierDto> getSupplier(String schoolId);
	
	public List<ProLicenseDto> getProLicenseBySchId(ProLicenseDto dto);
	
	public Integer updateSchool(EduSchoolDto dto);
	
	public PageResult<SupplierReviewedDto> list(SupplierReviewedDto dto, PageQuery page);

	List<EduSchoolDto> searchEduScholDtoList(EduSchoolDto eduSchoolDto);
}

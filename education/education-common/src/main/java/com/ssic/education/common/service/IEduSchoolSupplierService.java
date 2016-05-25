package com.ssic.education.common.service;

import java.util.List;

import com.ssic.education.common.dto.EduSchoolSupplierDto;

public interface IEduSchoolSupplierService {

	List<EduSchoolSupplierDto> searchEduSchoolSupplierListDto(EduSchoolSupplierDto eduSchoolSupplierDto);
	
	EduSchoolSupplierDto searchEduSchoolSupplierDto(EduSchoolSupplierDto eduSchoolSupplierDto);
	
//	List<SchoolSupplierDto> findByPage(SchoolSupplierDto schoolSupplierDto,PageHelper ph);
//	
//	Integer findCountByPage(SchoolSupplierDto schoolSupplierDto,PageHelper ph);
//	
//	Integer insertSchoolSupplier(SchoolSupplierDto schoolSupplierDto);
//	
//	void deleteschoolSupplier(String id);
//	
//	List<SchoolSupplierDto> findBy(SchoolSupplierDto schoolSupplierDto);
//	
//	void updateschoolSupplier(SchoolSupplierDto schoolSupplierDto);

}
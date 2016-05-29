package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.EduSchoolSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;

public interface IEduSchoolSupplierService {

	List<EduSchoolSupplierDto> searchEduSchoolSupplierListDto(EduSchoolSupplierDto eduSchoolSupplierDto);
	
	EduSchoolSupplierDto searchEduSchoolSupplierDto(EduSchoolSupplierDto eduSchoolSupplierDto);

	String findSchoolIdByReceiverId(String receiverName,String sourceId);
	
	List<SupplierDto> searchEduSchoolSupplierListDto(String schoolId);
	
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

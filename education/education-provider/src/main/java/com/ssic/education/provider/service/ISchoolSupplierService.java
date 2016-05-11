package com.ssic.education.provider.service;

import java.util.List;

import com.ssic.education.provider.dto.SchoolSupplierDto;
import com.ssic.education.provider.pageModel.PageHelper;

public interface  ISchoolSupplierService {

	
	List<SchoolSupplierDto> findByPage(SchoolSupplierDto schoolSupplierDto,PageHelper ph);
	
	Integer findCountByPage(SchoolSupplierDto schoolSupplierDto,PageHelper ph);
	
	Integer insertSchoolSupplier(SchoolSupplierDto schoolSupplierDto);
	
	void deleteschoolSupplier(String id);
	
	List<SchoolSupplierDto> findBy(SchoolSupplierDto schoolSupplierDto);
	
	void updateschoolSupplier(SchoolSupplierDto schoolSupplierDto);
}

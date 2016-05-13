package com.ssic.education.common.service;

import java.util.List;

import com.ssic.education.common.dto.ProSupplierDto;


public interface ProSupplierService {
	
	public ProSupplierDto findById(String id);

	public List<ProSupplierDto> findAllProSupplier();
}

package com.ssic.education.handle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.handle.dao.ProSupplierDao;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.handle.service.ICorporateService;
@Service
public class CorporateService implements ICorporateService{
	
	@Autowired
	private ProSupplierDao supplierDao;

	
	public ProSupplier findSupplierById(String sourceId) {
		return supplierDao.findSupplierById(sourceId);
	}

}

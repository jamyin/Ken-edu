package com.ssic.education.common.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProSupplierDao;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.provider.service.ICorporateService;
@Service
public class CorporateService implements ICorporateService{
	
	@Autowired
	private ProSupplierDao supplierDao;

	@Override
	public ProSupplier findSupplierById(String sourceId) {
		return supplierDao.findSupplierById(sourceId);
	}

}

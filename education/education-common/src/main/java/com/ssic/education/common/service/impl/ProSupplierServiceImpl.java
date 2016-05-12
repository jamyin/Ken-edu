package com.ssic.education.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProSupplierDao;

@Service
public class ProSupplierServiceImpl {

	@Autowired
	private ProSupplierDao proSupplierDao;
	
	public ProSuplierDto findById(String id) {
		
	}
	
}

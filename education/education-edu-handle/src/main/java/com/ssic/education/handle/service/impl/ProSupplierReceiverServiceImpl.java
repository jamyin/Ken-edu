package com.ssic.education.handle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.handle.dao.ProSupplierReceiverDao;
import com.ssic.education.handle.service.IProSupplierReceiverService;
@Service
public class ProSupplierReceiverServiceImpl implements IProSupplierReceiverService {
	
	@Autowired
	private ProSupplierReceiverDao psrDao;

	@Override
	public int findBySupplierCode(String value, String supplierId) {
		return psrDao.findBySupplierCode(value,supplierId);
	}

}

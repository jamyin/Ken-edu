package com.ssic.education.common.provider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProSupplierDao;
import com.ssic.education.common.dto.ProSupplierDto;

@Service
public class SupplierServiceImpl implements ISupplierService{

	@Autowired
	private ProSupplierDao proSupplierDao;

	@Override
	public List<ProSupplierDto> findAllProSupplier() {
		return proSupplierDao.findAllProSupplier();
	}
	
	@Override
	public ProSupplierDto findProSupplierById(String id) {
		return proSupplierDao.findProSupplierById(id);
	}

	@Override
	public void updataProSupplier(ProSupplierDto psd) {
		proSupplierDao.updataProSupplier(psd);
	}
	
}

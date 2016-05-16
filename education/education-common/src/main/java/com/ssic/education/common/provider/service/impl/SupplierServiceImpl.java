package com.ssic.education.common.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProSupplierDao;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.provider.service.ISupplierService;
import com.ssic.education.common.provider.service.dto.SupplierDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;

@Service
public class SupplierServiceImpl implements ISupplierService{

	@Autowired
	private ProSupplierDao proSupplierDao;

	@Override
	public DataGrid findProSupplier(SupplierDto supplierDto,PageHelper ph) {
		return proSupplierDao.findProSupplier(supplierDto,ph);
	}
	
	@Override
	public ProSupplierDto findProSupplierById(String id) {
		return proSupplierDao.findProSupplierById(id);
	}

	@Override
	public void updataProSupplier(ProSupplier ps) {
		proSupplierDao.updataProSupplier(ps);
	}

	@Override
	public int deleteSupplier(String id) {
		return proSupplierDao.deleteSupplierById(id);
	}

	@Override
	public int saveSupplier(ProSupplier ps) {
		return proSupplierDao.saveSupplier(ps);
	}
	
}

package com.ssic.education.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProSupplierDao;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.service.ProSupplierService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class ProSupplierServiceImpl implements ProSupplierService{

	@Autowired
	private ProSupplierDao proSupplierDao;
	
	public ProSupplierDto findById(String id) {
		ProSupplier proSupplier =  proSupplierDao.selectByPrimaryKey(id);
		if (null != proSupplier) {
			return BeanUtils.createBeanByTarget(proSupplier, ProSupplierDto.class);
		}
		return null;
	}
	
}

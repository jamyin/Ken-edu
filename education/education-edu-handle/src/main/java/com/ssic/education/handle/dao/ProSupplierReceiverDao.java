package com.ssic.education.handle.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.handle.mapper.ProSupplierReceiverMapper;
import com.ssic.education.handle.pojo.ProSupplierReceiverExample;
@Repository
public class ProSupplierReceiverDao {

	@Autowired
	private ProSupplierReceiverMapper  mapper;
	
	public int findBySupplierCode(String value, String supplierId) {
		ProSupplierReceiverExample example = new ProSupplierReceiverExample();
		ProSupplierReceiverExample.Criteria criteria = example.createCriteria();
		criteria.andSupplierCodeEqualTo(value);
		criteria.andReceiverIdEqualTo(supplierId);
		return mapper.selectByExample(example).size();
	}
}

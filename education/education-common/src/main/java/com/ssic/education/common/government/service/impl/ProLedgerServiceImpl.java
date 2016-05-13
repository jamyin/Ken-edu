package com.ssic.education.common.government.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProLedgerDao;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.pojo.ProLedger;
import com.ssic.education.common.government.service.ProLedgerService;
import com.ssic.education.government.dto.ProLedgerDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class ProLedgerServiceImpl implements ProLedgerService{
	
	@Autowired
	private ProLedgerDao proLedgerDao;
	
	public PageResult<ProSupplierDto> findPage(String id,PageQuery page) {
		List<ProSupplierDto> results = proLedgerDao.findPage(id, page);
		page.setTotal(proLedgerDao.count(id));
		return new PageResult<>(page, results);
	}
	
	public PageResult<ProLedgerDto> findLedgerPage(ProLedgerDto proLedgerDto,PageQuery page) {
		List<ProLedgerDto> results = proLedgerDao.findList(proLedgerDto, page);
		page.setTotal(proLedgerDao.findCount(proLedgerDto));
		return new PageResult<>(page, results);
	}
	
	public ProLedgerDto findById(String id) {
		ProLedger proLedger = proLedgerDao.selectByPrimaryKey(id);
		if (null != proLedger) {
			return BeanUtils.createBeanByTarget(proLedger, ProLedgerDto.class);
		}
		return null;
	}
}

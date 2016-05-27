package com.ssic.education.handle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProLedgerDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.handle.dao.ProLedgerDao;
import com.ssic.education.handle.pojo.ProLedger;
import com.ssic.education.handle.service.ProLedgerService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class ProLedgerServiceImpl implements ProLedgerService{
	
	@Autowired
	private ProLedgerDao proLedgerDao;
	
	public PageResult<LedgerDto> selectLedgerPage(LedgerDto dto,PageQuery page) {
		List<LedgerDto> results = proLedgerDao.selectLedgerListOrderby(dto, page);
		page.setTotal(proLedgerDao.countLedgerListOrderby(dto));
		List<LedgerDto> ledgerDtos = proLedgerDao.selectLedgerList(dto);
		for (LedgerDto ledgerDto:results){
			List<LedgerDto> ledgerDtoA = new ArrayList<LedgerDto>();
			for (LedgerDto ledgerdto:ledgerDtos) {
				if (ledgerDto.getWareBatchNo() == ledgerdto.getWareBatchNo()) {
					ledgerDtoA.add(ledgerdto);
				}
			}
			ledgerDto.setLedgerDtos(ledgerDtoA);
		}
		return new PageResult<>(page, results);
	}
	
	public PageResult<ProSupplierDto> findPage(ProSupplierDto dto,PageQuery page) {
		List<ProSupplierDto> results = proLedgerDao.findPage(dto, page);
		page.setTotal(proLedgerDao.count(dto));
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

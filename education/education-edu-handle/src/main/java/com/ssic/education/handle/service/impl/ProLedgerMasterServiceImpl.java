package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.ProLedgerMasterDto;
import com.ssic.education.handle.dao.ProLedgerMasterDao;
import com.ssic.education.handle.pojo.ProLedgerMaster;
import com.ssic.education.handle.service.IProLedgerMasterService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class ProLedgerMasterServiceImpl implements IProLedgerMasterService {

	@Autowired
	private ProLedgerMasterDao proLedgerMasterDao;

	@Override
	public List<ProLedgerMasterDto> searchProLedgerMasterDto(ProLedgerMasterDto proLedgerMasterDto) {
		List<ProLedgerMaster> resultList = proLedgerMasterDao.searchProLedgerMasterDto(proLedgerMasterDto);
		return BeanUtils.createBeanListByTarget(resultList, ProLedgerMasterDto.class);
	}

	@Override
	public ProLedgerMasterDto searchProLedgerMasterDto(String masterId) {
		ProLedgerMaster pojo = proLedgerMasterDao.selectByPrimaryKey(masterId); 
		return BeanUtils.createBeanByTarget(pojo, ProLedgerMasterDto.class); 
	}

}

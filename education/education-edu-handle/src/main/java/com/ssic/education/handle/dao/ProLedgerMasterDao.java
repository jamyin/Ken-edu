package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.ProLedgerMasterDto;
import com.ssic.education.handle.mapper.ProLedgerMasterMapper;
import com.ssic.education.handle.pojo.ProLedgerMaster;
import com.ssic.education.handle.pojo.ProLedgerMasterExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class ProLedgerMasterDao extends MyBatisBaseDao<ProLedgerMaster>{

	@Getter
	@Autowired
	private ProLedgerMasterMapper mapper;

	public List<ProLedgerMaster> searchProLedgerMasterDto(ProLedgerMasterDto proLedgerMasterDto) {
		ProLedgerMasterExample example = new ProLedgerMasterExample();
		ProLedgerMasterExample.Criteria criteria = example.createCriteria();
		
		if(StringUtils.isNotEmpty(proLedgerMasterDto.getReceiverId())){
			criteria.andReceiverIdEqualTo(proLedgerMasterDto.getReceiverId());	
		}
		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		
		return mapper.selectByExample(example);
	}
	

}

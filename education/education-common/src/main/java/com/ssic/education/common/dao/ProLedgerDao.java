package com.ssic.education.common.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Getter;

import com.ssic.education.common.mapper.ProLedgerMapper;
import com.ssic.education.common.pojo.ProLedger;
import com.ssic.education.common.pojo.ProLedgerExample;
import com.ssic.education.government.dto.ProLedgerDto;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;

@Repository
public class ProLedgerDao extends MyBatisBaseDao<ProLedger>{

	@Getter
	@Autowired
	private ProLedgerMapper mapper;
	
	public List<ProLedgerDto> findListByReceiverId(String id) {
		ProLedgerExample example = new ProLedgerExample();
		ProLedgerExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(id)) {
			criteria.andReceiverIdEqualTo(id);
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		List<ProLedger> proLedgers = mapper.selectByExample(example);
		return BeanUtils.createBeanListByTarget(proLedgers, ProLedgerDto.class);
	}
	
	
}

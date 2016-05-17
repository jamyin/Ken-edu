package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssic.education.common.mapper.ProLicenseMapper;
import com.ssic.education.common.pojo.ProLicense;
import com.ssic.education.common.pojo.ProLicenseExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.ListResult;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProLicenseDao extends MyBatisBaseDao<ProLicense>{

	@Getter
	@Autowired
	private ProLicenseMapper mapper;
	
	public List<ProLicense> findById (String id, Integer cerSource) {
		ProLicenseExample example = new ProLicenseExample();
		ProLicenseExample.Criteria criteria = example.createCriteria();	
		if (StringUtils.isNotBlank(id)) {
			criteria.andRelationIdEqualTo(id);			
		}
		if (null != cerSource) {
			criteria.andCerSourceEqualTo(cerSource.shortValue());
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		List<ProLicense> proLicenses = mapper.selectByExample(example);
		return proLicenses;
	}
}
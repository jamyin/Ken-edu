package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.education.handle.mapper.ProLicenseExMapper;
import com.ssic.education.handle.mapper.ProLicenseMapper;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.pojo.ProLicenseExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class ProLicenseDao extends MyBatisBaseDao<ProLicense>{

	@Getter
	@Autowired
	private ProLicenseMapper mapper;

	@Autowired
	private ProLicenseExMapper exmapper;
	
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

	public void updateImage(ProLicense license) {
		// TODO Auto-generated method stub
		mapper.insert(license);
	}

	public List<ProLicense> lookImage(ProLicense license) {
		// TODO Auto-generated method stub
		return exmapper.lookImage(license);
	}

	public int alterImage(ProLicense license) {
		// TODO Auto-generated method stub
		
		return exmapper.alterImage(license);
	}

	public List<ProLicense> searchProLicenseList(ProLicenseDto proLicenseDto) {
		ProLicenseExample example = new ProLicenseExample();
		ProLicenseExample.Criteria criteria = example.createCriteria();	

		if(StringUtils.isNotEmpty(proLicenseDto.getRelationId())){
			criteria.andRelationIdEqualTo(proLicenseDto.getRelationId());
		}
		
		if(proLicenseDto.getCerSource()!=null){
			criteria.andCerSourceEqualTo(proLicenseDto.getCerSource());
		}
		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.selectByExample(example);
	}

	public List<ProLicense> selectByRelationId(String id) {
		// TODO Auto-generated method stub
		return exmapper.selectByRelationId(id);
	}
}

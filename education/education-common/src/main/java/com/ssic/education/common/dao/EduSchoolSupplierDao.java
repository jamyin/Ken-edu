package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.EduSchoolSupplierDto;
import com.ssic.education.common.mapper.EduSchoolSupplierMapper;
import com.ssic.education.common.pojo.EduSchoolSupplier;
import com.ssic.education.common.pojo.EduSchoolSupplierExample;
import com.ssic.education.common.pojo.EduSchoolSupplierExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.StringUtils;

@Repository
public class EduSchoolSupplierDao  extends MyBatisBaseDao<EduSchoolSupplier>{

	@Getter
	@Autowired
	private EduSchoolSupplierMapper mapper;

	public List<EduSchoolSupplier> searchEduSchoolSupplierDto(EduSchoolSupplierDto eduSchoolSupplierDto) {
		EduSchoolSupplierExample example = new EduSchoolSupplierExample();
		Criteria criteria = example.createCriteria();
		
		if(!StringUtils.isEmpty(eduSchoolSupplierDto.getSchoolId())){
			criteria.andSchoolIdEqualTo(eduSchoolSupplierDto.getSchoolId());
		}
		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.selectByExample(example);
	}
}
package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.mapper.EduSchoolMapper;
import com.ssic.education.common.pojo.EduSchool;
import com.ssic.education.common.pojo.EduSchoolExample;
import com.ssic.education.government.dto.EduSchoolDto;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;

@Repository
public class EduSchoolDao extends MyBatisBaseDao<EduSchool>{

	@Autowired
	@Getter
	private EduSchoolMapper mapper;	
	
	public List<EduSchoolDto> findPage(EduSchoolDto dto, PageQuery page) {
		EduSchoolExample example = new EduSchoolExample();
		EduSchoolExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(dto.getAddressCode())) {
			criteria.andAddressCodeEqualTo(dto.getAddressCode());
		}
		if (null != dto.getLevel()) {
			criteria.andLevelEqualTo(dto.getLevel());
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (null != page) {
			example.setOrderByClause("stat desc,create_time desc limit "+page.getStartNum() +"," + page.getPageSize());
		}
		return BeanUtils.createBeanListByTarget(mapper.selectByExample(example), EduSchoolDto.class);
	}
	
	public long count(EduSchoolDto dto) {
		EduSchoolExample example = new EduSchoolExample();
		EduSchoolExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(dto.getAddressCode())) {
			criteria.andAddressCodeEqualTo(dto.getAddressCode());
		}
		if (null != dto.getLevel()) {
			criteria.andLevelEqualTo(dto.getLevel());
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.countByExample(example);
	}
	
}

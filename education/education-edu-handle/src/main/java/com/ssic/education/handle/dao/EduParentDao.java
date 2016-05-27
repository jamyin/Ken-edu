package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.handle.dto.EduParentDto;
import com.ssic.education.handle.mapper.EduParentMapper;
import com.ssic.education.handle.pojo.EduParent;
import com.ssic.education.handle.pojo.EduParentExample;
import com.ssic.education.handle.pojo.EduParentExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;

@Repository
public class EduParentDao extends MyBatisBaseDao<EduParent> {

	@Getter
	@Autowired
	private EduParentMapper mapper;

	public List<EduParentDto> search(EduParentDto eduParentDto) {
		EduParentExample example = new EduParentExample();
		EduParentExample.Criteria criteria = example.createCriteria();
		assemblyParams(eduParentDto, criteria);
		List<EduParent> list = mapper.selectByExample(example);
		return BeanUtils.createBeanListByTarget(list, EduParentDto.class);
	}

	private void assemblyParams(EduParentDto eduParentDto, Criteria criteria) {
		// TODO Auto-generated method stub
		criteria.andStatEqualTo(DataStatus.ENABLED);
	}

}
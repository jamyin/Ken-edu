package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.EduCommitteeDto;
import com.ssic.education.common.mapper.EduCommitteeMapper;
import com.ssic.education.common.pojo.EduCommittee;
import com.ssic.education.common.pojo.EduCommitteeExample;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class EduCommitteeDao extends MyBatisBaseDao<EduCommittee> {

	@Getter
	@Autowired
	private EduCommitteeMapper mapper;

	public List<EduCommittee> queryCommittee(EduCommitteeDto eduCommitteeDto) {
		 EduCommitteeExample example = new  EduCommitteeExample();
		//EduAreaExample.Criteria criteria = example.createCriteria();
        //assemblyParams(eduAreaDto, criteria);
        example.setOrderByClause("name ASC");
		return mapper.selectByExample(example);
	}
	
	
	
	
}

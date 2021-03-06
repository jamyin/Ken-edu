package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.education.handle.mapper.EduCommitteeMapper;
import com.ssic.education.handle.pojo.EduCommittee;
import com.ssic.education.handle.pojo.EduCommitteeExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class EduCommitteeDao extends MyBatisBaseDao<EduCommittee> {

	@Getter
	@Autowired
	private EduCommitteeMapper mapper;

	public List<EduCommittee> queryCommittee(EduCommitteeDto eduCommitteeDto) {
		 EduCommitteeExample example = new  EduCommitteeExample();
		 EduCommitteeExample.Criteria criteria = example.createCriteria();
        //assemblyParams(eduAreaDto, criteria);
		 if(eduCommitteeDto!=null){
			 if(!StringUtils.isEmpty(eduCommitteeDto.getName())){
				 criteria.andNameLike("%" + eduCommitteeDto.getName() + "%");
			 }
			 if(eduCommitteeDto.getType()!=null){
				 criteria.andTypeEqualTo(eduCommitteeDto.getType());
			 }
		 }
		 
		criteria.andStatEqualTo(Short.valueOf("1"));
		 
        //example.setOrderByClause("name ASC");
		return mapper.selectByExample(example);
	}
	
	
	public List<EduCommittee> findAll() {
		 EduCommitteeExample example = new  EduCommitteeExample();
		 EduCommitteeExample.Criteria criteria = example.createCriteria();
		 criteria.andTypeEqualTo((short)DataStatus.EVA_TWO);
		 criteria.andStatEqualTo((short)DataStatus.ENABLED);
		 criteria.andAreaCodeIsNotNull();
		 example.setOrderByClause("name ASC");
		 return mapper.selectByExample(example);
	}
	
}

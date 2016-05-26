package com.ssic.education.edu.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.edu.dto.EduParentScChDto;
import com.ssic.education.edu.mapper.EduParentScChMapper;
import com.ssic.education.edu.pojo.EduParentScCh;
import com.ssic.education.edu.pojo.EduParentScChExample;
import com.ssic.education.edu.pojo.EduParentScChExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class EduParentScChDao extends MyBatisBaseDao<EduParentScCh> {

	@Autowired
	@Getter
	private EduParentScChMapper mapper;

	public List<EduParentScCh> searchParentScChDtoList(EduParentScChDto eduParentScChDto) {
		EduParentScChExample example = new EduParentScChExample();
		Criteria criteria = example.createCriteria();


		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.selectByExample(example);
	}

	
}
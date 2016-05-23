package com.ssic.education.wecaht.handle.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.wecaht.handle.dto.EduParentScChDto;
import com.ssic.education.wecaht.handle.mapper.EduParentScChMapper;
import com.ssic.education.wecaht.handle.pojo.EduParent;
import com.ssic.education.wecaht.handle.pojo.EduParentScCh;
import com.ssic.education.wecaht.handle.pojo.EduParentScChExample;
import com.ssic.education.wecaht.handle.pojo.EduParentScChExample.Criteria;

@Repository
public class EduParentScChDao extends MyBatisBaseDao<EduParentScCh> {

	@Autowired
	@Getter
	private EduParentScChMapper mapper;

	public List<EduParentScCh> searchFollowList(EduParentScChDto eduParentScChDto) {
		EduParentScChExample example = new EduParentScChExample();
		Criteria criteria = example.createCriteria();
		
		queryBySql(eduParentScChDto,criteria);
		
		return mapper.selectByExample(example);
	}

	private void queryBySql(EduParentScChDto eduParentScChDto, Criteria criteria) {

        criteria.andStatEqualTo(DataStatus.ENABLED);
    }

	
}
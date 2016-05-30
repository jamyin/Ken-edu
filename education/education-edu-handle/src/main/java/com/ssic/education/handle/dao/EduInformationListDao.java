package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.handle.mapper.EduInformationListMapper;
import com.ssic.education.handle.pojo.EduInformationList;
import com.ssic.education.handle.pojo.EduInformationListExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;


@Repository
public class EduInformationListDao  extends MyBatisBaseDao<EduInformationList>{

	@Getter
	@Autowired
	private EduInformationListMapper mapper;

	public List<EduInformationList> searchEduInformationList(PageQuery pageQuery) {
		EduInformationListExample example = new EduInformationListExample();
		EduInformationListExample.Criteria criteria = example.createCriteria();
		
		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.selectByExample(example);
	}

	public long count() {
		EduInformationListExample example = new EduInformationListExample();
		EduInformationListExample.Criteria criteria = example.createCriteria();
		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.countByExample(example);
	}

}

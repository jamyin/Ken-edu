package com.ssic.education.common.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.mapper.EduCanteenMapper;
import com.ssic.education.common.pojo.EduCanteen;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class EduCanteenDao extends MyBatisBaseDao<EduCanteen>{

	@Getter
	@Autowired
	private EduCanteenMapper mapper;
}

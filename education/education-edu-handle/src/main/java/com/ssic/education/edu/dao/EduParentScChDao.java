package com.ssic.education.edu.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.edu.mapper.EduParentScChMapper;
import com.ssic.education.edu.pojo.EduParentScCh;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class EduParentScChDao extends MyBatisBaseDao<EduParentScCh> {

	@Autowired
	@Getter
	private EduParentScChMapper mapper;

	
}
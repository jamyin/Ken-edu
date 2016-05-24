package com.ssic.education.wecaht.handle.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.wecaht.handle.mapper.EduParentScChMapper;
import com.ssic.education.wecaht.handle.pojo.EduParent;
import com.ssic.education.wecaht.handle.pojo.EduParentScCh;

@Repository
public class EduParentScChDao extends MyBatisBaseDao<EduParentScCh> {

	@Autowired
	@Getter
	private EduParentScChMapper mapper;

	
}
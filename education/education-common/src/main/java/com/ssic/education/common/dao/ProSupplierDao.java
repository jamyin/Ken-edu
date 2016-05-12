package com.ssic.education.common.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.mapper.ProSupplierMapper;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class ProSupplierDao extends MyBatisBaseDao<ProSupplier>{

	@Getter
	@Autowired
	private ProSupplierMapper mapper;
	
}

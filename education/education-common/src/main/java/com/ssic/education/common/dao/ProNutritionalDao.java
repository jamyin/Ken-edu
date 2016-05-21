package com.ssic.education.common.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.mapper.ProNutritionalMapper;
import com.ssic.education.common.pojo.ProNutritional;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class ProNutritionalDao extends MyBatisBaseDao<ProNutritional>{

	@Getter
	@Autowired
	private ProNutritionalMapper mapper;
}

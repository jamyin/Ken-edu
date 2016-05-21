package com.ssic.education.common.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssic.education.common.mapper.ProNutritionalMapper;
import com.ssic.education.common.pojo.ProNutritional;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

public class ProNutritionalDao extends MyBatisBaseDao<ProNutritional>{

	@Getter
	@Autowired
	private ProNutritionalMapper mapper;
}

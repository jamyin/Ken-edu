package com.ssic.education.common.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.mapper.ProDishesMapper;
import com.ssic.education.common.pojo.ProDishes;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class ProDishesDao extends MyBatisBaseDao<ProDishes>{

	@Getter
	@Autowired
	private ProDishesMapper mapper;
	
	
}

package com.ssic.education.provider.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProDishesDto;
import com.ssic.education.common.mapper.ProDishesMapper;
import com.ssic.education.common.pojo.ProDishes;
import com.ssic.education.common.pojo.ProWaresExample;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;

@Repository
public class ProDishesDao extends MyBatisBaseDao<ProDishes> {

	@Getter
	@Autowired
	private ProDishesMapper mapper;

}

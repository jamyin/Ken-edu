package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.handle.mapper.ProNutritionalExMapper;
import com.ssic.education.handle.mapper.ProNutritionalMapper;
import com.ssic.education.handle.pojo.ProNutritional;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class ProNutritionalDao extends MyBatisBaseDao<ProNutritional>{

	@Getter
	@Autowired
	private ProNutritionalMapper mapper;
	
	@Getter
	@Autowired
	private ProNutritionalExMapper mappers;

	public List<ProNutritional> selectAllNutritional() {
		/*ProNutritionalExample example = new ProNutritionalExample();
		ProNutritionalExample.Criteria criteria = example.createCriteria();
		criteria.andStatEqualTo(DataStatus.ENABLED);
        example.setOrderByClause("create_time desc");
		return mapper.selectByExample(example);*/
		return mappers.selectAllNutritional();
	}

	public List<ProNutritional> selectAllNutritionalUnit() {
		return mappers.selectAllNutritionalUnit();
	}

	public int addNutritionalBatch(List<ProNutritional> nutritionalList) {
		return mappers.addNutritionalBatch(nutritionalList);
	}
}

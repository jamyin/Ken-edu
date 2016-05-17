package com.ssic.education.government.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.government.dto.TImsMenuTypeDto;
import com.ssic.education.government.mapper.TImsMenuTypeExMapper;
import com.ssic.education.government.pojo.EduMenuType;

@Repository
public class TImsMenuTypeDao {

	@Autowired
	private TImsMenuTypeExMapper tImsMenuTypeExMapper;

	public List<TImsMenuTypeDto> finAll() {
		List<TImsMenuTypeDto> dtoList = tImsMenuTypeExMapper.findAll();
		return dtoList;
	}
	

	public EduMenuType getMenuTyoeById(String id) {
		return tImsMenuTypeExMapper.findById(id);
	}
}

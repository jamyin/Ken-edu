package com.ssic.education.provider.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.provider.dto.TImsMenuTypeDto;
import com.ssic.education.provider.mapper.TImsMenuTypeExMapper;
import com.ssic.education.provider.pojo.ProMenuType;

@Repository
public class TImsMenuTypeDao {

	@Autowired
	private TImsMenuTypeExMapper tImsMenuTypeExMapper;

	public List<TImsMenuTypeDto> finAll() {
		List<TImsMenuTypeDto> dtoList = tImsMenuTypeExMapper.findAll();
		return dtoList;
	}
	

	public ProMenuType getMenuTyoeById(String id) {
		return tImsMenuTypeExMapper.findById(id);
	}
}

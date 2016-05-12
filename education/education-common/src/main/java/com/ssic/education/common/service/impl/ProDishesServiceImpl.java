package com.ssic.education.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProDishesDao;
import com.ssic.education.common.dto.ProDishesDto;
import com.ssic.education.common.service.ProDishesService;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

@Service
public class ProDishesServiceImpl implements ProDishesService{

	@Autowired
	private ProDishesDao proDishesDao;
	
	public PageResult<ProWaresDto> findPage(ProDishesDto proDishesDto,PageQuery page){
		List<ProWaresDto> results = proDishesDao.findPage(proDishesDto, page);
		page.setTotal(proDishesDao.count(proDishesDto));
		return new PageResult<>(page, results);
	}
}

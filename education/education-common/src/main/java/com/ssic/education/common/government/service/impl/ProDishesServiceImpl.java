package com.ssic.education.common.government.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProDishesDao;
import com.ssic.education.common.dto.ProWaresDto;
import com.ssic.education.common.government.service.ProDishesService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

@Service
public class ProDishesServiceImpl implements ProDishesService{

	@Autowired
	private ProDishesDao proDishesDao;
	
	public PageResult<ProWaresDto> findPage(ProWaresDto proWaresDto,PageQuery page){
		List<ProWaresDto> results = proDishesDao.findPage(proWaresDto, page);
		page.setTotal(proDishesDao.count(proWaresDto));
		return new PageResult<>(page, results);
	}
}

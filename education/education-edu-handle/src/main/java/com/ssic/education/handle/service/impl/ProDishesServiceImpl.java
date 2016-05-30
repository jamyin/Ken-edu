package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.ProDishesDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.dao.ProDishesDao;
import com.ssic.education.handle.pojo.ProDishes;
import com.ssic.education.handle.service.ProDishesService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class ProDishesServiceImpl implements ProDishesService{

	@Autowired
	private ProDishesDao proDishesDao;
	
	public PageResult<ProWaresDto> findPage(ProWaresDto proWaresDto,PageQuery page){
		List<ProWaresDto> results = proDishesDao.findPage(proWaresDto, page);
		page.setTotal(proDishesDao.count(proWaresDto));
		return new PageResult<ProWaresDto>(page, results);
	}

	@Override
	public List<ProDishesDto> searchDishes(List<String> packageIdList) {
		List<ProDishes> dataList = proDishesDao.searchDishes(packageIdList);
				
		return BeanUtils.createBeanListByTarget(dataList, ProDishesDto.class);
	}
}

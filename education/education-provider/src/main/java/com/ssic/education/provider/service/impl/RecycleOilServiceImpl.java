package com.ssic.education.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.provider.dao.RecycleOilDao;
import com.ssic.education.provider.dto.RecycleOilDto;
import com.ssic.education.provider.service.IRecycleOilService;

@Service
public class RecycleOilServiceImpl implements IRecycleOilService {

	@Autowired
	private RecycleOilDao recycleOilDao;
	
	@Override
	public DataGrid findAllRecycleOil(RecycleOilDto recycleOilDto,
			PageHelper ph) {
		return recycleOilDao.findAllRecycleOil(recycleOilDto,ph);
	}

	@Override
	public RecycleOilDto findRecycleOilById(String sourceId,String id) {
		return recycleOilDao.findRecycleOilById(sourceId,id);
	}

	@Override
	public int updataRecycleOil(RecycleOilDto rod) {
		return recycleOilDao.updataRecycleOil(rod);
	}

	@Override
	public int deleteRecycleOil(String sourceId,String id) {
		return recycleOilDao.deleteRecycleOil(sourceId,id);
	}

	@Override
	public int saveRecycleOil(RecycleOilDto rod) {
		return recycleOilDao.saveRecycleOil(rod);
	}

	@Override
	public String findRecycleBySourceId(String sourceId) {
		return recycleOilDao.findRecycleBySourceId(sourceId);
	}
	
	
}

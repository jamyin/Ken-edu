package com.ssic.education.handle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.RecycleOilDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.dao.RecycleOilDao;
import com.ssic.education.handle.service.IRecycleOilService;

@Service
public class RecycleOilServiceImpl implements IRecycleOilService {

	@Autowired
	private RecycleOilDao recycleOilDao;
	
	public DataGrid findAllRecycleOil(RecycleOilDto recycleOilDto,
			PageHelper ph) {
		return recycleOilDao.findAllRecycleOil(recycleOilDto,ph);
	}


	public RecycleOilDto findRecycleOilById(String sourceId,String id) {
		return recycleOilDao.findRecycleOilById(sourceId,id);
	}


	public int updataRecycleOil(RecycleOilDto rod) {
		return recycleOilDao.updataRecycleOil(rod);
	}

	
	public int deleteRecycleOil(String sourceId,String id) {
		return recycleOilDao.deleteRecycleOil(sourceId,id);
	}

	
	public int saveRecycleOil(RecycleOilDto rod) {
		return recycleOilDao.saveRecycleOil(rod);
	}

	
	public String findRecycleBySourceId(String sourceId) {
		return recycleOilDao.findRecycleBySourceId(sourceId);
	}
	
	
}

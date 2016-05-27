package com.ssic.education.handle.service;

import com.ssic.educateion.common.dto.RecycleOilDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;

public interface IRecycleOilService {

	DataGrid findAllRecycleOil(RecycleOilDto recycleOilDto, PageHelper ph);

	RecycleOilDto findRecycleOilById(String sourceId,String id);

	int updataRecycleOil(RecycleOilDto rod);

	int deleteRecycleOil(String sourceId,String id);

	int saveRecycleOil(RecycleOilDto rod);

	String findRecycleBySourceId(String sourceId);

}

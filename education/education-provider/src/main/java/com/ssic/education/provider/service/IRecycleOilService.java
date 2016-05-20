package com.ssic.education.provider.service;

import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.provider.dto.RecycleOilDto;

public interface IRecycleOilService {

	DataGrid findAllRecycleOil(RecycleOilDto recycleOilDto, PageHelper ph);

	RecycleOilDto findRecycleOilById(String sourceId,String id);

	int updataRecycleOil(RecycleOilDto rod);

	int deleteRecycleOil(String sourceId,String id);

	int saveRecycleOil(RecycleOilDto rod);

	String findRecycleBySourceId(String sourceId);

}

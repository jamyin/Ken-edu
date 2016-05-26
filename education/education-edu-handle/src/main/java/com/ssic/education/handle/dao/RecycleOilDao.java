package com.ssic.education.handle.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.RecycleOilDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.mapper.ProRecycleOilMapper;
import com.ssic.education.handle.mapper.RecycleOilExMapper;
import com.ssic.education.handle.mapper.WasteRecyclerExMapper;
@Repository
public class RecycleOilDao {

	@Autowired
	private ProRecycleOilMapper mapper;
	
	@Autowired 
	private RecycleOilExMapper exMapper;
	
	@Autowired 
	private WasteRecyclerExMapper rExMapper;
	
	public DataGrid findAllRecycleOil(RecycleOilDto rod,
			PageHelper ph) {
		DataGrid dataGrid=new DataGrid();
		Long total=(long) exMapper.findAllRecycleOil(rod,null).size();
		dataGrid.setTotal(total);
		int beginRow=(ph.getPage()-1)*ph.getRows();
		ph.setBeginRow(beginRow);
		dataGrid.setRows(exMapper.findAllRecycleOil(rod,ph));
		return dataGrid;
	}

	public RecycleOilDto findRecycleOilById(String sourceId,String id) {
		return exMapper.findRecycleOilById(sourceId,id);
	}

	public int updataRecycleOil(RecycleOilDto rod) {
		rod.setRecyclerId(null);
		rod.setCreateTime(null);
		rod.setLastUpdateTime(new Date());
		return exMapper.updateByPrimaryKeySelective(rod);
	}

	public int deleteRecycleOil(String sourceId,String id) {
		RecycleOilDto rod = new RecycleOilDto();
		rod.setId(id);
		rod.setSupplierId(sourceId);
		rod.setStat((short) 0);
		rod.setLastUpdateTime(new Date());
		return exMapper.updateByPrimaryKeySelective(rod);
	}

	public int saveRecycleOil(RecycleOilDto rod) {
		String type="1";
		rod.setRecyclerId(rExMapper.findRecycleIdBySourceId(rod.getSupplierId(),type));
		rod.setCreateTime(new Date());
		rod.setLastUpdateTime(rod.getCreateTime());
		rod.setStat((short) 1);
		return exMapper.insert(rod);
	}

	public String findRecycleBySourceId(String sourceId) {
		String type="1";
		return rExMapper.findRecycleBySourceId(sourceId,type);
	}

}

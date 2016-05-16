package com.ssic.education.common.dao;

import java.util.Date;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.mapper.ProSupplierExMapper;
import com.ssic.education.common.mapper.ProSupplierMapper;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.provider.service.dto.SupplierDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

/**
 * 
 * @author pengpeng
 * @Date: 2016年5月12日 下午5:36:33
 */
@Repository
public class ProSupplierDao extends MyBatisBaseDao<ProSupplier> {

	@Getter
	@Autowired
	private ProSupplierMapper mapper;
	
	@Autowired
	private ProSupplierExMapper exMapper;

	public DataGrid findProSupplier(SupplierDto supplierDto, PageHelper ph) {
		DataGrid dataGrid=new DataGrid();
		Long total=(long) exMapper.findProSupplier(supplierDto,new PageHelper()).size();
		dataGrid.setTotal(total);
		int beginRow=(ph.getPage()-1)*ph.getRows();
		ph.setBeginRow(beginRow);
		dataGrid.setRows(exMapper.findProSupplier(supplierDto,ph));
		return dataGrid;
	}

	public ProSupplierDto findProSupplierById(String id) {
		return exMapper.findProSupplierById(id);
	}

	public void updataProSupplier(ProSupplier ps) {
		ps.setCreateTime(null);
		ps.setLastUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(ps);
	}

	public int deleteSupplierById(String id) {
		ProSupplier ps = new ProSupplier();
		ps.setId(id);
		ps.setStat(0);
		ps.setCreateTime(null);
		ps.setLastUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(ps);
		return mapper.updateByPrimaryKeySelective(ps);
	}

	public int saveSupplier(ProSupplier ps) {
		ps.setCreateTime(new Date());
		ps.setLastUpdateTime(ps.getCreateTime());
		return mapper.insert(ps);
	}

}

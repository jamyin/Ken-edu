package com.ssic.education.common.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.mapper.EduSchoolSupplierExMapper;
import com.ssic.education.common.provider.dto.LedgerAddressDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;

/**
* @ClassName: AreaServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 上午11:55:50
*
 */
@Repository
public class LedgerAddressDao {

	@Autowired
	private EduSchoolSupplierExMapper exMapper;

	public DataGrid findAllLedgerAddress(LedgerAddressDto lad, PageHelper ph) {
		DataGrid dataGrid = new DataGrid();
		Long total = exMapper.countAllLedgerAddress(lad);
		dataGrid.setTotal(total);
		int beginRow = (ph.getPage() - 1) * ph.getRows();
		ph.setBeginRow(beginRow);
		dataGrid.setRows(exMapper.findAllLedgerAddress(lad, ph));
		return dataGrid;
	}

}


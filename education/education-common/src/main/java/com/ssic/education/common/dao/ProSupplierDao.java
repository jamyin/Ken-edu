package com.ssic.education.common.dao;

import java.util.Date;
import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.mapper.ProSupplierExMapper;
import com.ssic.education.common.mapper.ProSupplierMapper;
import com.ssic.education.common.mapper.ProSupplierReceiverMapper;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.pojo.ProSupplierReceiver;
import com.ssic.education.common.pojo.ViewProSupplierExample;
import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.StringUtils;

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
	@Autowired
	private ProSupplierReceiverMapper  srMapper;
	
	private void assemblyParams(ProSupplierDto proSupplierDto, ViewProSupplierExample.Criteria criteria) {
		if (null != proSupplierDto) {
			if (StringUtils.isNotEmpty(proSupplierDto.getId())){
				criteria.andIdEqualTo(proSupplierDto.getId().trim());
			}
			if (StringUtils.isNotEmpty(proSupplierDto.getArea())){
				criteria.andAreaEqualTo(proSupplierDto.getArea().trim());
			}
			if (StringUtils.isNotBlank(proSupplierDto.getSupplierName())){
				criteria.andSupplierNameLike("%"+proSupplierDto.getSupplierName().trim()+"%");
			}
			if (StringUtils.isNotBlank(proSupplierDto.getAddress())){
				criteria.andAddressLike("%"+proSupplierDto.getAddress().trim()+"%");
			}
			if (StringUtils.isNotBlank(proSupplierDto.getSchoolIds())){
				criteria.andSchoolIdsLike("%"+proSupplierDto.getSchoolIds().trim()+"%");
			}
		}
	}

	public DataGrid findProSupplier(SupplierDto supplierDto, PageHelper ph) {
		DataGrid dataGrid=new DataGrid();
		Long total=(long) exMapper.findProSupplier(supplierDto,new PageHelper()).size();
		dataGrid.setTotal(total);
		int beginRow=(ph.getPage()-1)*ph.getRows();
		ph.setBeginRow(beginRow);
		dataGrid.setRows(exMapper.findProSupplier(supplierDto,ph));
		return dataGrid;
	}

	public SupplierDto findProSupplierById(String id) {
		return exMapper.findProSupplierById(id);
	}

	public void updataProSupplier(SupplierDto ps) {
		ps.setCreateTime(null);
		ps.setLastUpdateTime(new Date());
		exMapper.updateByPrimaryKeySelective(ps);
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

	public int saveSupplier(SupplierDto ps) {
		ps.setCreateTime(new Date());
		ps.setLastUpdateTime(ps.getCreateTime());
		ps.setStat(1);
		ProSupplier supplier =new ProSupplier();
		BeanUtils.copyProperties(ps, supplier);
		
		return mapper.insertSelective(supplier);
	}

	public List<SupplierDto> lookRelatingWares(ProSupplierDto dto) {
		// TODO Auto-generated method stub
		return exMapper.lookRelatingWares(dto);
	}

	public void saveSupplierReceiver(ProSupplierReceiver proSupplierReceiver) {
		// TODO Auto-generated method stub
		srMapper.insert(proSupplierReceiver);
	}
}

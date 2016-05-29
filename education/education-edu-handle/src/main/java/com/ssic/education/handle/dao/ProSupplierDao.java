package com.ssic.education.handle.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.mapper.ProSupplierExMapper;
import com.ssic.education.handle.mapper.ProSupplierMapper;
import com.ssic.education.handle.mapper.ProSupplierReceiverMapper;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.handle.pojo.ProSupplierExample;
import com.ssic.education.handle.pojo.ProSupplierExample.Criteria;
import com.ssic.education.handle.pojo.ProSupplierReceiver;
import com.ssic.education.handle.pojo.ProSupplierReceiverExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;

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
	
	public List<ProSupplierDto> findPage(ProSupplierDto dto, PageQuery page) {
		ProSupplierExample example = new ProSupplierExample();
		ProSupplierExample.Criteria criteria = example.createCriteria();
		if (null != dto.getReviewed()) {
			criteria.andReviewedEqualTo(dto.getReviewed());
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (null != page) {
            example.setOrderByClause("stat desc,create_time desc limit " + page.getStartNum() + "," + page.getPageSize());
        } else {
            example.setOrderByClause("create_time desc");
        }
		return BeanUtils.createBeanListByTarget(mapper.selectByExample(example), ProSupplierDto.class);
	}
	
	public long count(ProSupplierDto dto) {
		ProSupplierExample example = new ProSupplierExample();
		ProSupplierExample.Criteria criteria = example.createCriteria();
		if (null != dto.getReviewed()) {
			criteria.andReviewedEqualTo(dto.getReviewed());
		}
		if (StringUtils.isNotBlank(dto.getSupplierName())){
			criteria.andSupplierNameLike("%"+dto.getSupplierName().trim()+"%");
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.countByExample(example);
	}
	/*private void assemblyParams(ProSupplierDto proSupplierDto, ProSupplierExample.Criteria criteria) {
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
			if (null != proSupplierDto.getReviewed()) {
			}
		}
	}*/

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

	public List<SupplierDto> findSupplierCodeByReceiverId(String supplierId) {
		// TODO Auto-generated method stub
		return exMapper.findSupplierCodeByReceiverId(supplierId);
	}
	
	public ProSupplier findSupplierById(String sourceId) {
		return mapper.selectByPrimaryKey(sourceId);
	}

	public String findSupplierIdBySourceId(LedgerDto ledger) {
		return exMapper.findSupplierIdBySourceId(ledger);
	}

	public List<ProSupplierDto> searchSupplierListBySupplierId(
			String supplierId,String suppliName, Integer supplierType,Integer limit) {
		// TODO Auto-generated method stub
		return exMapper.searchSupplierListBySupplierId(supplierId,suppliName,supplierType,limit);
	}

	public ProSupplier findProSupplierByName(String name, String supplierId) {
//		ProSupplierReceiverExample psrExample = new ProSupplierReceiverExample();
//		com.ssic.education.handle.pojo.ProSupplierReceiverExample.Criteria psrCreate = psrExample
//				.createCriteria();
//		psrCreate.andReceiverIdEqualTo(supplierId);
//		psrCreate.and
//		List<ProSupplierReceiver> psrList = srMapper
//				.selectByExample(psrExample);
//		if (psrList.size() != 0) {
//			for (ProSupplierReceiver psr : psrList) {
//				ProSupplierExample example = new ProSupplierExample();
//				Criteria create = example.createCriteria();
//				create.andIdCardEqualTo(psr.getSupplierId());
//				create.andSupplierNameEqualTo(name);
//				List<ProSupplier> psList = mapper.selectByExample(example);
//				if (psList.size() != 0) {
//					return psList.get(0);
//				}
//			}
//		}
		return null;
	}

	public int importSupplier(Map<String, Map<ProSupplierReceiver, ProSupplier>> map) {
		int i=0;
		for (String str : map.keySet()) {
			Map<ProSupplierReceiver, ProSupplier> mpp = map.get(str);
			for (ProSupplierReceiver psr : mpp.keySet()) {
				srMapper.insertSelective(psr);
				ProSupplier supplier = mpp.get(psr);
				i+= mapper.insertSelective(supplier);
			}
		}
		return i;
	}
}

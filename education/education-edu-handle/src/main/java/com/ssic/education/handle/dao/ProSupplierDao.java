package com.ssic.education.handle.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.mapper.ProLicenseMapper;
import com.ssic.education.handle.mapper.ProSupplierExMapper;
import com.ssic.education.handle.mapper.ProSupplierMapper;
import com.ssic.education.handle.mapper.ProSupplierReceiverMapper;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.pojo.ProLicenseExample;
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
	private ProSupplierReceiverMapper srMapper;
	
	@Autowired
	private ProLicenseMapper plMapper;

	public List<ProSupplierDto> findSupplierListByIds(ProSupplierDto dto,
			PageQuery page) {
		return exMapper.findSupplierListByIds(dto, page);
	}

	public long countSupplierListByIds(ProSupplierDto dto) {
		return exMapper.countSupplierListByIds(dto);
	}

	public List<ProSupplierDto> findSupplierListByCommittee(ProSupplierDto dto,
			PageQuery page) {
		return exMapper.findSupplierListByCommittee(dto, page);
	}

	public long countSupplierListByCommittee(ProSupplierDto dto) {
		return exMapper.countSupplierListByCommittee(dto);
	}

	public List<ProSupplierDto> findPage(ProSupplierDto dto, PageQuery page) {
		ProSupplierExample example = new ProSupplierExample();
		ProSupplierExample.Criteria criteria = example.createCriteria();
		if (null != dto.getReviewed()) {
			criteria.andReviewedEqualTo(dto.getReviewed());
		}
		if (StringUtils.isNotBlank(dto.getSupplierName())) {
			criteria.andSupplierNameLike("%" + dto.getSupplierName().trim()
					+ "%");
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (null != page) {
			example.setOrderByClause("stat desc,create_time desc limit "
					+ page.getStartNum() + "," + page.getPageSize());
		} else {
			example.setOrderByClause("create_time desc");
		}
		return BeanUtils.createBeanListByTarget(
				mapper.selectByExample(example), ProSupplierDto.class);
	}

	public long count(ProSupplierDto dto) {
		ProSupplierExample example = new ProSupplierExample();
		ProSupplierExample.Criteria criteria = example.createCriteria();
		if (null != dto.getReviewed()) {
			criteria.andReviewedEqualTo(dto.getReviewed());
		}
		if (StringUtils.isNotBlank(dto.getSupplierName())) {
			criteria.andSupplierNameLike("%" + dto.getSupplierName().trim()
					+ "%");
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.countByExample(example);
	}

	/*
	 * private void assemblyParams(ProSupplierDto proSupplierDto,
	 * ProSupplierExample.Criteria criteria) { if (null != proSupplierDto) { if
	 * (StringUtils.isNotEmpty(proSupplierDto.getId())){
	 * criteria.andIdEqualTo(proSupplierDto.getId().trim()); } if
	 * (StringUtils.isNotEmpty(proSupplierDto.getArea())){
	 * criteria.andAreaEqualTo(proSupplierDto.getArea().trim()); } if
	 * (StringUtils.isNotBlank(proSupplierDto.getSupplierName())){
	 * criteria.andSupplierNameLike
	 * ("%"+proSupplierDto.getSupplierName().trim()+"%"); } if
	 * (StringUtils.isNotBlank(proSupplierDto.getAddress())){
	 * criteria.andAddressLike("%"+proSupplierDto.getAddress().trim()+"%"); } if
	 * (StringUtils.isNotBlank(proSupplierDto.getSchoolIds())){
	 * criteria.andSchoolIdsLike("%"+proSupplierDto.getSchoolIds().trim()+"%");
	 * } if (null != proSupplierDto.getReviewed()) { } } }
	 */

	public DataGrid findProSupplier(SupplierDto supplierDto, PageHelper ph) {
		DataGrid dataGrid = new DataGrid();
		Long total = (long) exMapper.findProSupplier(supplierDto,
				new PageHelper()).size();
		dataGrid.setTotal(total);
		if (ph != null) {
			int beginRow = (ph.getPage() - 1) * ph.getRows();
			ph.setBeginRow(beginRow);
		}
		dataGrid.setRows(exMapper.findProSupplier(supplierDto, ph));
		return dataGrid;
	}

	public SupplierDto findProSupplierById(String id) {
		return exMapper.findProSupplierById(id);
	}

	public void updataProSupplier(SupplierDto ps) {
		ps.setCreateTime(null);
		ps.setLastUpdateTime(new Date());
		exMapper.updateByPrimaryKeySelective(ps);
		ProLicense pl=null;
		if(ps.getFoodBusinessCode()!=null){
			pl=new ProLicense();
			pl.setLicNo(ps.getFoodBusinessCode());
			pl.setUpdater(ps.getUpdater());
			pl.setLastUpdateTime(ps.getLastUpdateTime());
			ProLicenseExample example=new ProLicenseExample();
			ProLicenseExample.Criteria criteria= example.createCriteria();
			criteria.andLicNameEqualTo("食品经营许可证");
			criteria.andLicTypeEqualTo(1);
			criteria.andRelationIdEqualTo(ps.getId());
			criteria.andStatEqualTo(1);
			int i = plMapper.updateByExampleSelective(pl, example);
			if(i==0){
				pl.setId(UUID.randomUUID().toString());
				pl.setLicName("食品经营许可证");
				pl.setLicType(1);
				pl.setRelationId(ps.getId());
				pl.setStat(1);
				pl.setCreator(pl.getUpdater());
				pl.setCreateTime(pl.getLastUpdateTime());
				pl.setCerSource((short)0);
				plMapper.insertSelective(pl);
			}
		}
		if(ps.getFoodCirculationCode()!=null){
			pl=new ProLicense();
			pl.setLicNo(ps.getFoodCirculationCode());
			pl.setUpdater(ps.getUpdater());
			pl.setLastUpdateTime(ps.getLastUpdateTime());
			ProLicenseExample example=new ProLicenseExample();
			ProLicenseExample.Criteria criteria= example.createCriteria();
			criteria.andLicNameEqualTo("食品流通许可证");
			criteria.andLicTypeEqualTo(2);
			criteria.andRelationIdEqualTo(ps.getId());
			criteria.andStatEqualTo(1);
			int i = plMapper.updateByExampleSelective(pl, example);
			if(i==0){
				pl.setId(UUID.randomUUID().toString());
				pl.setLicName("食品流通许可证");
				pl.setLicType(2);
				pl.setRelationId(ps.getId());
				pl.setStat(1);
				pl.setCreator(pl.getUpdater());
				pl.setCreateTime(pl.getLastUpdateTime());
				pl.setCerSource((short)0);
				plMapper.insertSelective(pl);
			}
		}
		if(ps.getFoodProduceCode()!=null){
			pl=new ProLicense();
			pl.setLicNo(ps.getFoodProduceCode());
			pl.setUpdater(ps.getUpdater());
			pl.setLastUpdateTime(ps.getLastUpdateTime());
			ProLicenseExample example=new ProLicenseExample();
			ProLicenseExample.Criteria criteria= example.createCriteria();
			criteria.andLicNameEqualTo("食品生产许可证");
			criteria.andLicTypeEqualTo(3);
			criteria.andRelationIdEqualTo(ps.getId());
			criteria.andStatEqualTo(1);
			int i = plMapper.updateByExampleSelective(pl, example);
			if(i==0){
				pl.setId(UUID.randomUUID().toString());
				pl.setLicName("食品生产许可证");
				pl.setLicType(3);
				pl.setRelationId(ps.getId());
				pl.setStat(1);
				pl.setCreator(pl.getUpdater());
				pl.setCreateTime(pl.getLastUpdateTime());
				pl.setCerSource((short)0);
				plMapper.insertSelective(pl);
			}
		}
		if(ps.getFoodServiceCode()!=null){
			pl=new ProLicense();
			pl.setLicNo(ps.getFoodServiceCode());
			pl.setUpdater(ps.getUpdater());
			pl.setLastUpdateTime(ps.getLastUpdateTime());
			ProLicenseExample example=new ProLicenseExample();
			ProLicenseExample.Criteria criteria= example.createCriteria();
			criteria.andLicNameEqualTo("餐饮服务许可证");
			criteria.andLicTypeEqualTo(0);
			criteria.andRelationIdEqualTo(ps.getId());
			criteria.andStatEqualTo(1);
			int i = plMapper.updateByExampleSelective(pl, example);
			if(i==0){
				pl.setId(UUID.randomUUID().toString());
				pl.setLicName("餐饮服务许可证");
				pl.setLicType(0);
				pl.setRelationId(ps.getId());
				pl.setStat(1);
				pl.setCreator(pl.getUpdater());
				pl.setCreateTime(pl.getLastUpdateTime());
				pl.setCerSource((short)0);
				plMapper.insertSelective(pl);
			}
		}
		if(ps.getBusinessLicense()!=null){
			pl=new ProLicense();
			pl.setLicNo(ps.getBusinessLicense());
			pl.setUpdater(ps.getUpdater());
			pl.setLastUpdateTime(ps.getLastUpdateTime());
			ProLicenseExample example=new ProLicenseExample();
			ProLicenseExample.Criteria criteria= example.createCriteria();
			criteria.andLicNameEqualTo("工商营业执照");
			criteria.andLicTypeEqualTo(4);
			criteria.andRelationIdEqualTo(ps.getId());
			criteria.andStatEqualTo(1);
			int i = plMapper.updateByExampleSelective(pl, example);
			if(i==0){
				pl.setId(UUID.randomUUID().toString());
				pl.setLicName("工商营业执照");
				pl.setLicType(4);
				pl.setRelationId(ps.getId());
				pl.setStat(1);
				pl.setCreator(pl.getUpdater());
				pl.setCreateTime(pl.getLastUpdateTime());
				pl.setCerSource((short)0);
				plMapper.insertSelective(pl);
			}
		}
	}

	public int deleteSupplierById(String id,String supplierId) {
		ProSupplier ps = new ProSupplier();
		ps.setId(id);
		ps.setStat(0);
		ps.setCreateTime(null);
		ps.setLastUpdateTime(new Date());
		ProSupplierReceiverExample example=new ProSupplierReceiverExample();
		ProSupplierReceiverExample.Criteria criteria = example.createCriteria();
		criteria.andSupplierIdEqualTo(id);
		criteria.andReceiverIdEqualTo(supplierId);
		srMapper.deleteByExample(example);
		return mapper.updateByPrimaryKeySelective(ps);
	}

	public int saveSupplier(SupplierDto ps) {
		ps.setCreateTime(new Date());
		ps.setLastUpdateTime(ps.getCreateTime());
		ps.setStat(1);
		ProSupplier supplier = new ProSupplier();
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
			String supplierId, String suppliName, Integer supplierType,
			Integer limit) {
		// TODO Auto-generated method stub
		return exMapper.searchSupplierListBySupplierId(supplierId, suppliName,
				supplierType, limit);
	}
	
	public List<ProSupplierDto> searchSchWareSuppListBySuppSchoolId(
			String supplierId,String schoolId, String suppliName, Integer supplierType,
			Integer limit) {
		// TODO Auto-generated method stub
		return exMapper.searchSchWareSuppListBySuppSchoolId(supplierId,schoolId, suppliName,
				supplierType, limit);
	}

	public ProSupplier findProSupplierByName(String name, String supplierId) {
		ProSupplierReceiverExample psrExample = new ProSupplierReceiverExample();
		com.ssic.education.handle.pojo.ProSupplierReceiverExample.Criteria psrCreate = psrExample
				.createCriteria();
		psrCreate.andReceiverIdEqualTo(supplierId);
		List<ProSupplierReceiver> psrList = srMapper
				.selectByExample(psrExample);
		if (psrList.size() != 0) {
			for (ProSupplierReceiver psr : psrList) {
				ProSupplierExample example = new ProSupplierExample();
				Criteria create = example.createCriteria();
				create.andIdEqualTo(psr.getSupplierId());
				create.andSupplierNameEqualTo(name);
				create.andStatEqualTo(1);
				List<ProSupplier> psList = mapper.selectByExample(example);
				if (psList.size() != 0) {
					return psList.get(0);
				}
			}
		}
		return null;
	}

	public int importSupplier(
			Map<String, Map<ProSupplierReceiver, ProSupplier>> map) {
		int i = 0;
		for (String str : map.keySet()) {
			Map<ProSupplierReceiver, ProSupplier> mpp = map.get(str);
			for (ProSupplierReceiver psr : mpp.keySet()) {
				srMapper.insertSelective(psr);
				ProSupplier supplier = mpp.get(psr);
				i += mapper.insertSelective(supplier);
			}
		}
		return i;
	}

	public List<ProSupplier> searchProSupplier(List<String> sourceIds) {
		ProSupplierExample example = new ProSupplierExample();
		ProSupplierExample.Criteria criteria = example.createCriteria();

		if (sourceIds != null && sourceIds.size() > 0) {
			criteria.andIdIn(sourceIds);
		}

		criteria.andStatEqualTo(DataStatus.ENABLED);

		return mapper.selectByExample(example);
	}

}

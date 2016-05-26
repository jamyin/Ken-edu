package com.ssic.education.handle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.dao.ProSupplierDao;
import com.ssic.education.handle.mapper.ProSupplierMapper;
import com.ssic.education.handle.mapper.ProSupplierReceiverMapper;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.handle.pojo.ProSupplierExample;
import com.ssic.education.handle.pojo.ProSupplierReceiver;
import com.ssic.education.handle.pojo.ProSupplierReceiverExample;
import com.ssic.education.handle.service.ISupplierService;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.UUIDGenerator;

@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private ProSupplierDao proSupplierDao;

	@Autowired
	private ProSupplierMapper mapper;

	@Autowired
	private ProSupplierReceiverMapper psrmapper;

	/**
	 * 根据供应商编码查询当前企业<code>supplierId</code>的供应商。由于编码在企业内部的唯一性，只可能有一个结果。
	 * 
	 * @param code
	 * @param supplierId
	 * @return
	 * @author zhangjiwei
	 * @since 2016.5.21
	 */
	public ProSupplier getSupplierByCode(String code, String supplierId) {
		ProSupplierReceiverExample ex = new ProSupplierReceiverExample();
		ProSupplierReceiverExample.Criteria c = ex.createCriteria();
		c.andReceiverIdEqualTo(supplierId);
		c.andSupplierCodeEqualTo(code);
		List<ProSupplierReceiver> list = psrmapper.selectByExample(ex);

		if (list.size() > 0) {
			List<String> ids = new ArrayList();
			for (ProSupplierReceiver o : list) {
				ids.add(o.getSupplierId());
			}
			ProSupplierExample pex = new ProSupplierExample();
			ProSupplierExample.Criteria pc = pex.createCriteria();
			pc.andIdIn(ids);
			pc.andStatEqualTo(1);
			
			List<ProSupplier> result = mapper.selectByExample(pex);
			
			// 由于编码在企业内部的唯一性，只可能有一个结果
			if (result.size() > 0) {
				return result.get(0);
			}
		}
		return null;
	}
	
	/**
	 * 根据供应商名称查询当前企业<code>supplierId</code>的供应商
	 * 
	 * @param name
	 * @param supplierId
	 * @return
	 * @author zhangjiwei
	 * @since 2016.5.21
	 */
	public ProSupplier getSupplierByName(String name, String supplierId) {
		ProSupplierReceiverExample ex = new ProSupplierReceiverExample();
		ProSupplierReceiverExample.Criteria c = ex.createCriteria();
		c.andReceiverIdEqualTo(supplierId);
		List<ProSupplierReceiver> list = psrmapper.selectByExample(ex);

		if (list.size() > 0) {
			List<String> ids = new ArrayList();
			for (ProSupplierReceiver o : list) {
				ids.add(o.getSupplierId());
			}
			ProSupplierExample pex = new ProSupplierExample();
			ProSupplierExample.Criteria pc = pex.createCriteria();
			pc.andIdIn(ids);
			pc.andSupplierNameEqualTo(name);
			pc.andStatEqualTo(1);
			
			List<ProSupplier> result = mapper.selectByExample(pex);
			
			// 由于名称的唯一性，只可能有一个结果
			if (result.size() > 0) {
				return result.get(0);
			}
		}
		return null;
	}

	@Override
	public DataGrid findProSupplier(SupplierDto supplierDto, PageHelper ph) {
		return proSupplierDao.findProSupplier(supplierDto, ph);
	}

	@Override
	public SupplierDto findProSupplierById(String id) {
		return proSupplierDao.findProSupplierById(id);
	}

	@Override
	public void updataProSupplier(SupplierDto ps) {
		proSupplierDao.updataProSupplier(ps);
	}

	@Override
	public int deleteSupplier(String id) {
		return proSupplierDao.deleteSupplierById(id);
	}

	@Override
	public int saveSupplier(SupplierDto ps) {
		return proSupplierDao.saveSupplier(ps);
	}

	@Override
	public List<SupplierDto> lookRelatingWares(ProSupplierDto dto) {
		// TODO Auto-generated method stub
		return proSupplierDao.lookRelatingWares(dto);
	}

	@Override
	public String saveOrUpdateSupplier(SupplierDto ps) {
		// TODO Auto-generated method stub
		ps.setId(UUIDGenerator.getUUID());
		ProSupplier proSupplier = BeanUtils.createBeanByTarget(ps,
				ProSupplier.class);
		proSupplierDao.insertSelective(proSupplier);
		return ps.getId();
	}

	@Override
	public void saveSupplierReceiver(ProSupplierReceiver proSupplierReceiver) {
		// TODO Auto-generated method stub
		proSupplierDao.saveSupplierReceiver(proSupplierReceiver);
	}

	@Override
	public List<SupplierDto> findSupplierCodeByReceiverId(String supplierId) {
		// TODO Auto-generated method stub
		return proSupplierDao.findSupplierCodeByReceiverId(supplierId);
	}

	@Override
	public ProSupplierDto searchProSupplierById(String sourceId) {
		// TODO Auto-generated method stub
		ProSupplier proSupplier =  proSupplierDao.selectByPrimaryKey(sourceId);
		return BeanUtils.createBeanByTarget(proSupplier, ProSupplierDto.class);
	}

	@Override
	public String findSupplierIdBySourceId(LedgerDto ledger) {
		// TODO Auto-generated method stub
		return proSupplierDao.findSupplierIdBySourceId(ledger);
	}

}

package com.ssic.education.common.provider.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProSupplierDao;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.mapper.ProSupplierMapper;
import com.ssic.education.common.mapper.ProSupplierReceiverMapper;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.pojo.ProSupplierExample;
import com.ssic.education.common.pojo.ProSupplierReceiver;
import com.ssic.education.common.pojo.ProSupplierReceiverExample;
import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.common.provider.service.ISupplierService;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.utils.util.UUIDGenerator;
import com.ssic.util.BeanUtils;

@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private ProSupplierDao proSupplierDao;

	@Autowired
	private ProSupplierMapper mapper;

	@Autowired
	private ProSupplierReceiverMapper psrmapper;

	/**
	 * 根据供应商编码查询自己<code>supplierId</code>的供应商
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
			
			List<ProSupplier> result = mapper.selectByExample(ex);
			
			// 根据当前企业下的供应商
			if (result.size() > 0) {
				return result.get(0);
			}
		}

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

}

package com.ssic.education.app.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.MaterialSupplierDto;
import com.ssic.education.app.dto.SupplierLicDto;
import com.ssic.education.app.mapper.SupplierInfoExMapper;
import com.ssic.education.handle.mapper.ProLedgerMapper;
import com.ssic.education.handle.mapper.ProLedgerMasterMapper;
import com.ssic.education.handle.mapper.ProLicenseMapper;
import com.ssic.education.handle.mapper.ProSupplierMapper;
import com.ssic.education.handle.mapper.ProSupplierReceiverMapper;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.pojo.ProLicenseExample;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.handle.pojo.ProSupplierExample;
import com.ssic.education.handle.pojo.ProSupplierReceiver;
import com.ssic.education.handle.pojo.ProSupplierReceiverExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.StringUtils;

/**		
 * <p>Title: SupplierInfoDao </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月23日 下午4:11:38	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月23日 下午4:11:38</p>
 * <p>修改备注：</p>
 */
@Repository
public class SupplierInfoDao {
	@Getter
	@Autowired
	private SupplierInfoExMapper mapper;

	@Getter
	@Autowired
	private ProLedgerMapper ledgerMapper;

	@Getter
	@Autowired
	private ProLicenseMapper licenseMapper;

	@Getter
	@Autowired
	private ProSupplierMapper SupplierMapper;

	@Getter
	@Autowired
	private ProLedgerMasterMapper ledgerMasterMapper;

	@Getter
	@Autowired
	private ProSupplierReceiverMapper supplierReceiverMapper;

	/**
	 * getSupplierInfoById：供应商资质查询
	 * @param supplier_id
	 * @author SeanYounG
	 * @date 2016年5月30日 下午12:00:24
	 */
	public SupplierLicDto getSupplierInfoById(String supplier_id) {
		return mapper.getSupplierInfoById(supplier_id);
	}

	/**
	 * getSupplierInfoById：供应商资质 带分页
	 * @param supplier_id
	 * @param pagequery
	 * @author SeanYoung
	 * @date 2016年5月30日 上午11:59:48
	 */
	public SupplierLicDto getSupplierById(String supplier_id) {
		ProSupplier proSupplier = SupplierMapper.selectByPrimaryKey(supplier_id);
		if (proSupplier != null) {
			return BeanUtils.createBeanByTarget(proSupplier, SupplierLicDto.class);
		}
		return null;
	}

	/**
	 * getSupplierInfoById：供应商资质 带分页
	 * @param supplier_id
	 * @param pagequery
	 * @author SeanYoung
	 * @date 2016年5月30日 上午11:59:48
	 */
	public List<MaterialSupplierDto> getSupplierByIds(List<String> ids, ProSupplier proSupplier, PageQuery query) {
		ProSupplierExample example = new ProSupplierExample();
		ProSupplierExample.Criteria critera = example.createCriteria();
		if (null != ids && !ids.isEmpty()) {
			critera.andIdIn(ids);
		}
		if (null != proSupplier) {
			if (StringUtils.isNotBlank(proSupplier.getSupplierName())) {
				critera.andSupplierNameLike("%" + proSupplier.getSupplierName() + "%");
			}
		}
		if (null != query) {
			example.setOrderByClause("stat desc,create_time desc limit " + query.getStartNum() + "," + query.getPageSize());
		}
		critera.andStatEqualTo(DataStatus.ENABLED);
		List<ProSupplier> proSupplierList = SupplierMapper.selectByExample(example);
		return BeanUtils.createBeanListByTarget(proSupplierList, MaterialSupplierDto.class);
	}

	//分页数量
	public int getSupplierByIdsCount(List<String> ids, ProSupplier proSupplier) {
		ProSupplierExample example = new ProSupplierExample();
		ProSupplierExample.Criteria critera = example.createCriteria();
		if (null != ids && !ids.isEmpty()) {
			critera.andIdIn(ids);
		}
		if (null != proSupplier) {
			if (StringUtils.isNotBlank(proSupplier.getSupplierName())) {
				critera.andSupplierNameLike("%" + proSupplier.getSupplierName() + "%");
			}
		}
		critera.andStatEqualTo(DataStatus.ENABLED);
		return SupplierMapper.countByExample(example);
	}

	public List<String> getSupplierReceiver(String receiverId) {
		ProSupplierReceiverExample example = new ProSupplierReceiverExample();
		ProSupplierReceiverExample.Criteria criteria = example.createCriteria();
		criteria.andReceiverIdEqualTo(receiverId);
		List<String> list = new ArrayList<String>();
		List<ProSupplierReceiver> supplierReceiver = supplierReceiverMapper.selectByExample(example);
		if (null != supplierReceiver && !supplierReceiver.isEmpty()) {
			for (ProSupplierReceiver proSupplierReceiver : supplierReceiver) {
				list.add(proSupplierReceiver.getSupplierId());
			}
			Set<String> set = new HashSet<String>(list);
			return new ArrayList<String>(set);
		}
		return null;
	}

	public List<MaterialSupplierDto> getSupplierListById(String supplier_id) {
		return mapper.getSupplierListById(supplier_id);
	}

	public List<ProLicense> getLic(String relationId) {
		ProLicenseExample example = new ProLicenseExample();
		ProLicenseExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(relationId)) {
			criteria.andRelationIdEqualTo(relationId);
			criteria.andCerSourceEqualTo((short) 0);
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return licenseMapper.selectByExample(example);
	}

	public List<ProLicense> getWaresLic(String relationId, short cerSource) {
		ProLicenseExample example = new ProLicenseExample();
		ProLicenseExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(relationId)) {
			criteria.andRelationIdEqualTo(relationId);
			criteria.andCerSourceEqualTo(cerSource);
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return licenseMapper.selectByExample(example);
	}

	public String getSupplierName(String supplierId) {
		ProSupplier proSupplier = SupplierMapper.selectByPrimaryKey(supplierId);
		if (proSupplier != null) {
			return proSupplier.getSupplierName();
		} else {
			return null;
		}
	}
}

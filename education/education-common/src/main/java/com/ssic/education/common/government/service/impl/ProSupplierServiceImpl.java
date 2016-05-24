package com.ssic.education.common.government.service.impl;

import com.ssic.education.common.dao.ProLicenseDao;
import com.ssic.education.common.dao.ProSupplierDao;
import com.ssic.education.common.dao.ViewProSupplierDao;
import com.ssic.education.common.dto.ProLicenseDto;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.government.service.ProSupplierService;
import com.ssic.education.common.pojo.ProLicense;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.pojo.ViewProSupplierWithBLOBs;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProSupplierServiceImpl implements ProSupplierService{

	@Autowired
	private ProSupplierDao proSupplierDao;
	@Autowired
	private ViewProSupplierDao viewProSupplierDao;
	@Autowired
	private ProLicenseDao proLicenseDao;

	public Integer updatePS(ProSupplierDto dto) {
		ProSupplier proSupplier = BeanUtils.createBeanByTarget(dto, ProSupplier.class);
		return proSupplierDao.updateByPrimaryKeySelective(proSupplier);
	}
	
	@Override
	public List<ProSupplierDto> querySupplierByParams(ProSupplierDto params) {
		List<ViewProSupplierWithBLOBs> viewProSuppliers = viewProSupplierDao.queryViewSupplier(params, null);

		if (null != viewProSuppliers && viewProSuppliers.size() > 0){
			return BeanUtils.createBeanListByTarget(viewProSuppliers, ProSupplierDto.class);
		}
		return null;
	}

	@Override
	public PageResult<ProSupplierDto> querySupplierByParams(ProSupplierDto params, PageQuery query) {
		int total = viewProSupplierDao.countViewSupplier(params);
		if (total > 0) {
			query.setTotal(total);
			List<ViewProSupplierWithBLOBs> viewProSuppliers = viewProSupplierDao.queryViewSupplier(params, query);
			if (null != viewProSuppliers && viewProSuppliers.size() > 0) {
				List<ProSupplierDto> result = BeanUtils.createBeanListByTarget(viewProSuppliers, ProSupplierDto.class);
				return new PageResult<>(query, result);
			}
		}
		return null;
	}
	
	public ProSupplierDto findById(String id) {
		ProSupplier proSupplier =  proSupplierDao.selectByPrimaryKey(id);
		List<ProLicense> proLicenses = proLicenseDao.findById(id,DataStatus.DISABLED);
		ProSupplierDto proSupplierDto = BeanUtils.createBeanByTarget(proSupplier, ProSupplierDto.class);
		List<ProLicenseDto> proLicenseDtos = BeanUtils.createBeanListByTarget(proLicenses, ProLicenseDto.class);		
		if (null != proSupplierDto) {
			proSupplierDto.setProLicenseDtoList(proLicenseDtos);
			return proSupplierDto;
//		ProSupplier proSupplier = proSupplierDao.selectByPrimaryKey(id);
//		if (null != proSupplier) {
//			return BeanUtils.createBeanByTarget(proSupplier, ProSupplierDto.class);
		}
		return null;
	}
	
}

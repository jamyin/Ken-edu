package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.handle.dao.ProLicenseDao;
import com.ssic.education.handle.dao.ProSupplierDao;
import com.ssic.education.handle.dao.ViewProSupplierDao;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.handle.pojo.ViewProSupplierWithBLOBs;
import com.ssic.education.handle.service.ProSupplierService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

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
	
	public List<ProSupplierDto> findAll(ProSupplierDto dto) {
		return proSupplierDao.findPage(dto, null);
	}

	public List<ProSupplierDto> querySupplierByParams(ProSupplierDto params) {
		List<ViewProSupplierWithBLOBs> viewProSuppliers = viewProSupplierDao.queryViewSupplier(params, null);

		if (null != viewProSuppliers && viewProSuppliers.size() > 0){
			return BeanUtils.createBeanListByTarget(viewProSuppliers, ProSupplierDto.class);
		}
		return null;
	}

	public PageResult<ProSupplierDto> findSupplierPageBySchoolId(ProSupplierDto dto, PageQuery query) {
		List<ProSupplierDto> results = proSupplierDao.findSupplierListBySchoolId(dto, query);
		query.setTotal(proSupplierDao.countSupplierListBySchoolId(dto));
		return new PageResult<>(query, results);
	}
	
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

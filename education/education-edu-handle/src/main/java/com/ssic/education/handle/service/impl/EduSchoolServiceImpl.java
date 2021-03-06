package com.ssic.education.handle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.SupplierReviewedDto;
import com.ssic.education.handle.dao.EduSchoolDao;
import com.ssic.education.handle.dao.ProLicenseDao;
import com.ssic.education.handle.dao.ProSupplierDao;
import com.ssic.education.handle.pojo.EduSchool;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduSchoolServiceImpl implements EduSchoolService{

	@Autowired
	private EduSchoolDao eduSchoolDao;
	
	@Autowired
	private ProLicenseDao proLicenseDao;
	
	@Autowired
	private ProSupplierDao  proSupplierDao;
	
	public PageResult<SupplierReviewedDto> list(SupplierReviewedDto dto, PageQuery page) {
		EduSchoolDto eduSchoolDto = BeanUtils.createBeanByTarget(dto, EduSchoolDto.class);
		ProSupplierDto proSupplierDto = BeanUtils.createBeanByTarget(dto, ProSupplierDto.class);
		List<EduSchoolDto> results = eduSchoolDao.findPage(eduSchoolDto, page);
		List<ProSupplierDto> resultSu = proSupplierDao.findSupplierListByCommittee(proSupplierDto, page);
		List<SupplierReviewedDto> supplierReviewedDtos = new ArrayList<SupplierReviewedDto>();
		List<SupplierReviewedDto> supplierReviewedDtoE = BeanUtils.createBeanListByTarget(results, SupplierReviewedDto.class);
		supplierReviewedDtos.addAll(supplierReviewedDtoE);
		List<SupplierReviewedDto> supplierReviewedDtoP = BeanUtils.createBeanListByTarget(resultSu, SupplierReviewedDto.class);
		supplierReviewedDtos.addAll(supplierReviewedDtoP);
		page.setTotal(Math.round((double)(eduSchoolDao.count(eduSchoolDto)+proSupplierDao.countSupplierListByCommittee(proSupplierDto))/2));
		System.out.println(eduSchoolDao.count(eduSchoolDto)+"+"+proSupplierDao.countSupplierListByCommittee(proSupplierDto));
		return new PageResult<SupplierReviewedDto>(page, supplierReviewedDtos);
	}
	
	public PageResult<EduSchoolDto> list(EduSchoolDto dto, PageQuery page) {
		List<EduSchoolDto> results = eduSchoolDao.findPage(dto, page);
		page.setTotal(eduSchoolDao.count(dto));
		return new PageResult<EduSchoolDto>(page, results);
	}
	
	public EduSchoolDto findById (String id) {
		if (StringUtils.isNotBlank(id)) {
			EduSchool eduSchool = eduSchoolDao.selectByPrimaryKey(id);
			if (null != eduSchool) {
				return BeanUtils.createBeanByTarget(eduSchool, EduSchoolDto.class);
			}
		}		
		return null;
	}

	public List<ProSupplierDto> getSupplier(String schoolId) {
		if (StringUtils.isNotBlank(schoolId)) {
			return eduSchoolDao.getSupplier(schoolId);
		}
		return null;
	}
	
	public List<EduSchoolDto> queryAll(){
		return eduSchoolDao.findPage(null, null);
	}
	
	public Integer updateSchool(EduSchoolDto dto) {
		EduSchool eduSchool = BeanUtils.createBeanByTarget(dto, EduSchool.class);
		return eduSchoolDao.updateByPrimaryKeySelective(eduSchool);
	}
	
	public List<ProLicenseDto> getProLicenseBySchId(ProLicenseDto dto) {
		return BeanUtils.createBeanListByTarget(proLicenseDao.findById(dto.getId(), dto.getCerSource().intValue()), ProLicenseDto.class);
	}

	@Override
	public List<EduSchoolDto> searchEduScholDtoList(EduSchoolDto eduSchoolDto) {
		List<EduSchool> dataList = eduSchoolDao.searchEduScholDtoList(eduSchoolDto);
		List<EduSchoolDto> resultList = BeanUtils.createBeanListByTarget(dataList, EduSchoolDto.class);
		return resultList;
	}
}
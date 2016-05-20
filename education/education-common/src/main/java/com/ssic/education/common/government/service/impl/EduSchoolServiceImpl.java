package com.ssic.education.common.government.service.impl;

import com.ssic.education.common.dao.EduSchoolDao;
import com.ssic.education.common.dao.ProLicenseDao;
import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.education.common.dto.ProLicenseDto;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.government.service.EduSchoolService;
import com.ssic.education.common.pojo.EduSchool;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduSchoolServiceImpl implements EduSchoolService{

	@Autowired
	private EduSchoolDao eduSchoolDao;
	
	@Autowired
	private ProLicenseDao proLicenseDao;
	
	public PageResult<EduSchoolDto> list(EduSchoolDto dto, PageQuery page) {
		List<EduSchoolDto> results = eduSchoolDao.findPage(dto, page);
		page.setTotal(eduSchoolDao.count(dto));
		return new PageResult<>(page, results);
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
}
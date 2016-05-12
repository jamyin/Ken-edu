package com.ssic.education.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.EduSchoolDao;
import com.ssic.education.common.pojo.EduSchool;
import com.ssic.education.common.service.EduSchoolService;
import com.ssic.education.government.dto.EduSchoolDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduSchoolServiceImpl implements EduSchoolService{

	@Autowired
	private EduSchoolDao eduSchoolDao;
	
	public PageResult<EduSchoolDto> list(EduSchoolDto dto,PageQuery page) {
		List<EduSchoolDto> results = eduSchoolDao.findPage(dto, page);
		page.setTotal(eduSchoolDao.count(dto));
		return new PageResult<>(page, results);
	}
	
	public EduSchoolDto findById (String id) {
		EduSchool eduSchool = eduSchoolDao.selectByPrimaryKey(id);
		return BeanUtils.createBeanByTarget(eduSchool, EduSchool.class);
	}
	
	
}

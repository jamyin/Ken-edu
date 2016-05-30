package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.SchoolDto;
import com.ssic.education.app.service.ISchoolService;
import com.ssic.education.handle.dao.SchoolDao;
import com.ssic.education.handle.pojo.EduSchool;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

/**	
* @ClassName: SchoolServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 下午2:20:58
*
 */
@Service
public class SchoolsServiceImpl implements ISchoolService{

    @Autowired
    private SchoolDao schoolDao;

	@Override
	public PageResult<SchoolDto> findSchoolList(SchoolDto schoolDto,
			PageQuery query,  Integer isPage) {
		List<EduSchool> list = schoolDao.findSchoolList(schoolDto, query , isPage);
		List<SchoolDto> schoolDtoList = BeanUtils.createBeanListByTarget(list, SchoolDto.class);
		int total = schoolDao.selectSchoolAccount(schoolDto);
		query.setTotal(total);
		return new PageResult<SchoolDto>(query, schoolDtoList);
	}

	@Override
	public PageResult<EduSchoolDto> findSchoolDetialList(String id,EduSchoolDto eduSchoolDto,
			PageQuery query) {
		List<EduSchool> list = schoolDao.findSchoolDetialList(id,eduSchoolDto, query);
		List<EduSchoolDto> dtoList = BeanUtils.createBeanListByTarget(list, EduSchoolDto.class);
		int total = schoolDao.selectSchoolDetialAccount(id,eduSchoolDto);
		query.setTotal(total);
		return new PageResult<EduSchoolDto>(query, dtoList);
	}

}


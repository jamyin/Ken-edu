package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssic.education.app.service.ISchoolService;
import com.ssic.education.common.dao.SchoolDao;
import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.education.common.pojo.EduSchool;
import com.ssic.util.BeanUtils;
import com.ssic.util.model.PageQuery;
import com.ssic.util.model.PageResult;

/**	
* @ClassName: SchoolServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 下午2:20:58
*
 */
public class SchoolServiceImpl implements ISchoolService{

    @Autowired
    private SchoolDao schoolDao;

	@Override
	public PageResult<EduSchoolDto> findSchoolList(EduSchoolDto eduSchoolDto,
			PageQuery query) {
		List<EduSchool> list = schoolDao.findSchoolList(eduSchoolDto, query);
		List<EduSchoolDto> schoolDtoList = BeanUtils.createBeanListByTarget(list, EduSchoolDto.class);
		int total = schoolDao.selectSchoolAccount(eduSchoolDto);
		query.setTotal(total);
		return new PageResult<EduSchoolDto>(query, schoolDtoList);
	}


}


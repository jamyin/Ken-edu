package com.ssic.education.common.dao;

import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.education.common.mapper.EduSchoolMapper;
import com.ssic.education.common.pojo.EduSchool;
import com.ssic.education.common.pojo.EduSchoolExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * @author pengpeng
 * @Date: 2016年5月12日 下午5:36:21
 */
@Repository
public class EduSchoolDao extends MyBatisBaseDao<EduSchool>{

	@Autowired
	@Getter
	private EduSchoolMapper mapper;	
	
	public List<EduSchoolDto> findPage(EduSchoolDto dto, PageQuery page) {
		EduSchoolExample example = new EduSchoolExample();
		EduSchoolExample.Criteria criteria = example.createCriteria();
		assemblyParams(dto, criteria);
		if (null != page) {
			example.setOrderByClause("stat desc,create_time desc limit "+page.getStartNum() +"," + page.getPageSize());
		}else{
			example.setOrderByClause("create_time desc");
		}
		return BeanUtils.createBeanListByTarget(mapper.selectByExample(example), EduSchoolDto.class);
	}

	public long count(EduSchoolDto dto) {
		EduSchoolExample example = new EduSchoolExample();
		EduSchoolExample.Criteria criteria = example.createCriteria();
		assemblyParams(dto, criteria);
		return mapper.countByExample(example);
	}

	private void assemblyParams(EduSchoolDto dto, EduSchoolExample.Criteria criteria) {
		if (null != dto){
			if (null != dto.getLevel()) {
				criteria.andLevelEqualTo(dto.getLevel());
			}
		}

		criteria.andStatEqualTo(DataStatus.ENABLED);
	}
}

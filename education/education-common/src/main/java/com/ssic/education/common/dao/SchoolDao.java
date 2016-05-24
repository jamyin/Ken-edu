package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.education.common.mapper.EduSchoolExMapper;
import com.ssic.education.common.mapper.EduSchoolMapper;
import com.ssic.education.common.pojo.EduSchool;
import com.ssic.education.common.pojo.EduSchoolExample;
import com.ssic.education.common.pojo.EduSchoolExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.StringUtils;

/**
 * @ClassName: SchoolDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ken Yin
 * @date 2016年5月13日 上午9:24:21
 *
 */
@Repository
public class SchoolDao extends MyBatisBaseDao<EduSchool> {

	@Getter
	@Autowired
	private EduSchoolMapper mapper;

	@Getter
	@Autowired
	private EduSchoolExMapper mappers;

	/**
	 * @Title: findSchoolList
	 * @Description: 查询学校列表-分页
	 * @author Ken Yin  
	 * @date 2016年5月13日 上午9:25:55
	 * @return List<EduSchool>    返回类型
	 */
	public List<EduSchool> findSchoolList(EduSchoolDto eduSchoolDto,PageQuery query) {
		EduSchoolExample example = new EduSchoolExample();
		EduSchoolExample.Criteria criteria = example.createCriteria();
		assemblyParams(eduSchoolDto, criteria);
		if(query != null && query.getPageSize() > 0){
			example.setOrderByClause("create_time DESC limit "+query.getStartNum() +"," + query.getPageSize());
		}
		List<EduSchool> list = mapper.selectByExample(example);
		return list;
	}

	private void assemblyParams(EduSchoolDto eduSchoolDto, Criteria criteria) {
		if (null != eduSchoolDto) {
			if (StringUtils.isNotEmpty(eduSchoolDto.getId())){
				criteria.andIdEqualTo(eduSchoolDto.getId().trim());
			}
			if (StringUtils.isNotBlank(eduSchoolDto.getSchoolName())){
				criteria.andSchoolNameLike("%"+eduSchoolDto.getSchoolName().trim()+"%");
			}	
			if (StringUtils.isNotBlank(eduSchoolDto.getLevel())) {
				criteria.andLevelLike("%" + eduSchoolDto.getLevel().trim()+ "%");
			}
			if (StringUtils.isNotBlank(eduSchoolDto.getArea())){
				criteria.andAreaEqualTo(eduSchoolDto.getArea());
			}	
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
	}

	/**
	 * @Title: selectSchoolAccount
	 * @Description: 分页总条数
	 * @author Ken Yin  
	 * @date 2016年5月13日 上午9:27:48
	 * @return int    返回类型
	 */
	public int selectSchoolAccount(EduSchoolDto eduSchoolDto) {
		EduSchoolExample example = new EduSchoolExample();
		EduSchoolExample.Criteria criteria = example.createCriteria();
		assemblyParams(eduSchoolDto, criteria);  
		return mapper.countByExample(example);
	}

	public List<EduSchool> findSchoolDetialList(String id,EduSchoolDto eduSchoolDto,
			PageQuery query) {
		return mappers.findSchoolDetialList(id, eduSchoolDto, query);
	}

	public int selectSchoolDetialAccount(String id,EduSchoolDto eduSchoolDto) {
		return mappers.findSchoolDetialListAccount(id, eduSchoolDto);
	}

}


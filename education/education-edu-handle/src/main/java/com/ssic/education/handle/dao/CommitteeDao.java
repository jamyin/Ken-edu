package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.education.handle.mapper.EduCommitteeMapper;
import com.ssic.education.handle.pojo.EduCommittee;
import com.ssic.education.handle.pojo.EduCommitteeExample;
import com.ssic.education.handle.pojo.EduCommitteeExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.StringUtils;

/**
 * @ClassName: CommitteeDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ken Yin
 * @date 2016年5月23日 下午5:29:31
 *
 */
@Repository
public class CommitteeDao extends MyBatisBaseDao<EduCommittee> {

	@Getter
	@Autowired
	private EduCommitteeMapper mapper;

	/**
	 * @Title: findCommitteeList
	 * @Description: 查询学校列表-分页
	 * @author Ken Yin  
	 * @date 2016年5月13日 上午9:25:55
	 * @return List<EduCommittee>    返回类型
	 */
	public List<EduCommittee> findCommitteeList(EduCommitteeDto eduCommitteeDto, PageQuery query) {
		EduCommitteeExample example = new EduCommitteeExample();
		EduCommitteeExample.Criteria criteria = example.createCriteria();
		assemblyParams(eduCommitteeDto, criteria);
		if (query != null && query.getPageSize() > 0) {
			example.setOrderByClause("create_time DESC limit " + query.getStartNum() + "," + query.getPageSize());
		}
		List<EduCommittee> list = mapper.selectByExample(example);
		return list;
	}

	public int selectCommitteeAccount(EduCommitteeDto eduCommitteeDto) {
		EduCommitteeExample example = new EduCommitteeExample();
		EduCommitteeExample.Criteria criteria = example.createCriteria();
		assemblyParams(eduCommitteeDto, criteria);
		return mapper.countByExample(example);
	}

	private void assemblyParams(EduCommitteeDto eduCommitteeDto, Criteria criteria) {
		if (null != eduCommitteeDto) {
			if (StringUtils.isNotEmpty(eduCommitteeDto.getId())) {
				criteria.andIdEqualTo(eduCommitteeDto.getId().trim());
			}
			if (StringUtils.isNotBlank(eduCommitteeDto.getName())) {
				criteria.andNameLike("%" + eduCommitteeDto.getName().trim() + "%");
			}
			if (eduCommitteeDto.getType() != null) {
				criteria.andTypeEqualTo(eduCommitteeDto.getType());
			}
		}
		criteria.andStatEqualTo(DataStatus.SHORT_ENABLED);
	}

	public EduCommittee getbyId(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	public List<EduCommittee> findCommitteeListNoPage(
			EduCommitteeDto eduCommitteeDto) {
		EduCommitteeExample example = new EduCommitteeExample();
		EduCommitteeExample.Criteria criteria = example.createCriteria();
		assemblyParams(eduCommitteeDto, criteria);
		return mapper.selectByExample(example);
	}
}

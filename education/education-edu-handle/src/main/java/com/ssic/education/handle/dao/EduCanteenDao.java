package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.EduCanteenDto;
import com.ssic.education.handle.mapper.EduCanteenMapper;
import com.ssic.education.handle.pojo.EduCanteen;
import com.ssic.education.handle.pojo.EduCanteenExample;
import com.ssic.education.handle.pojo.EduCanteenExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.StringUtils;

@Repository
public class EduCanteenDao extends MyBatisBaseDao<EduCanteen>{

	@Getter
	@Autowired
	private EduCanteenMapper mapper;

	public List<EduCanteen> searchEduCanteenDto(EduCanteenDto eduCanteenDto) {
		EduCanteenExample example = new EduCanteenExample();
		Criteria criteria = example.createCriteria();
		
		if(!StringUtils.isEmpty(eduCanteenDto.getId())){
			criteria.andIdEqualTo(eduCanteenDto.getId());
		}
		
		if(!StringUtils.isEmpty(eduCanteenDto.getSchoolId())){
			criteria.andSchoolIdEqualTo(eduCanteenDto.getSchoolId());
		}
		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.selectByExample(example);
	}
}

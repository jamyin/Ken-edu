package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.education.handle.mapper.EduTaskReceiveMapper;
import com.ssic.education.handle.pojo.EduTaskReceive;
import com.ssic.education.handle.pojo.EduTaskReceiveExample;
import com.ssic.education.handle.pojo.EduTaskReceiveExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;


@Repository
public class EduTaskReceiveDao  extends MyBatisBaseDao<EduTaskReceive>{

	@Getter
	@Autowired
	private EduTaskReceiveMapper mapper;

	public List<EduTaskReceive> searchEduTaskReceive(EduTaskReceiveDto eduTaskReceiveDto,PageQuery pageQuery) {
		EduTaskReceiveExample example = new EduTaskReceiveExample();
		EduTaskReceiveExample.Criteria criteria = example.createCriteria();
		
		queryBySql(criteria,eduTaskReceiveDto);
		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.selectByExample(example);
	}

	public long count(EduTaskReceiveDto eduTaskReceiveDto) {
		EduTaskReceiveExample example = new EduTaskReceiveExample();
		EduTaskReceiveExample.Criteria criteria = example.createCriteria();
		
		queryBySql(criteria,eduTaskReceiveDto);
		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.countByExample(example);
	}

	private void queryBySql(Criteria criteria,EduTaskReceiveDto eduTaskReceiveDto) {
//		if(StringUtils.isNotEmpty(eduTaskReceiveDto.get){
//			criteria.andCreateIdEqualTo(eduTaskReceiveDto.getCreateId());
//		}
		
		if(StringUtils.isNotEmpty(eduTaskReceiveDto.getReceiveId())){
			criteria.andReceiveIdEqualTo(eduTaskReceiveDto.getReceiveId());
		}
		
	}

}

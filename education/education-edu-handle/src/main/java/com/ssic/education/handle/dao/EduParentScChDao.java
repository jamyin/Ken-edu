package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.handle.dto.EduParentScChDto;
import com.ssic.education.handle.mapper.EduParentScChMapper;
import com.ssic.education.handle.pojo.EduParentScCh;
import com.ssic.education.handle.pojo.EduParentScChExample;
import com.ssic.education.handle.pojo.EduParentScChExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class EduParentScChDao extends MyBatisBaseDao<EduParentScCh> {

	@Autowired
	@Getter
	private EduParentScChMapper mapper;

	public List<EduParentScCh> searchParentScChDtoList(EduParentScChDto eduParentScChDto) {
		EduParentScChExample example = new EduParentScChExample();
		Criteria criteria = example.createCriteria();

		if(!StringUtils.isEmpty(eduParentScChDto.getParentId())){
			criteria.andParentIdEqualTo(eduParentScChDto.getParentId());
		}
		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.selectByExample(example);
	}

	
}
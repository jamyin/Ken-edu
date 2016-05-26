package com.ssic.education.edu.dao;

import lombok.Getter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.edu.dto.EduParentPackCommentDto;
import com.ssic.education.edu.mapper.EduParentPackCommentMapper;
import com.ssic.education.edu.pojo.EduParentPackComment;
import com.ssic.education.edu.pojo.EduParentPackCommentExample;
import com.ssic.education.edu.pojo.EduParentPackCommentExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class EduParentPackCommentDao extends MyBatisBaseDao<EduParentPackComment> {

	@Autowired
	@Getter
	private EduParentPackCommentMapper mapper;

	public void searchComment(EduParentPackCommentDto eduParentPackCommentDto) {
		EduParentPackCommentExample example = new EduParentPackCommentExample();
		Criteria criteria = example.createCriteria();
		
		if(!StringUtils.isEmpty(eduParentPackCommentDto.getPackageId())){
			criteria.andPackageIdEqualTo(eduParentPackCommentDto.getPackageId());
		}

		criteria.andStatEqualTo(DataStatus.ENABLED);
		mapper.selectByExample(example);
	}

}
package com.ssic.education.wecaht.handle.dao;

import lombok.Getter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.wecaht.handle.dto.EduParentPackCommentDto;
import com.ssic.education.wecaht.handle.mapper.EduParentPackCommentMapper;
import com.ssic.education.wecaht.handle.pojo.EduParentPackComment;
import com.ssic.education.wecaht.handle.pojo.EduParentPackCommentExample;
import com.ssic.education.wecaht.handle.pojo.EduParentPackCommentExample.Criteria;

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
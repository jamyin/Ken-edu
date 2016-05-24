package com.ssic.education.wecaht.handle.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.wecaht.handle.mapper.EduParentPackCommentMapper;
import com.ssic.education.wecaht.handle.pojo.EduParentPackComment;

@Repository
public class EduParentPackCommentDao extends MyBatisBaseDao<EduParentPackComment> {

	@Autowired
	@Getter
	private EduParentPackCommentMapper mapper;

}
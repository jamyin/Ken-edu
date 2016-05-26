package com.ssic.education.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.edu.dao.EduParentPackCommentDao;
import com.ssic.education.edu.dto.EduParentPackCommentDto;
import com.ssic.education.edu.pojo.EduParentPackComment;
import com.ssic.education.edu.service.IEduParentPackCommentService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduParentPackCommentServiceImpl implements IEduParentPackCommentService {

	@Autowired
	private EduParentPackCommentDao eduParentPackCommentDao;

	public void saveComment(EduParentPackCommentDto eduParentPackCommentDto) {
		EduParentPackComment eduParentPackComment = BeanUtils.createBeanByTarget(eduParentPackCommentDto, EduParentPackComment.class);
		eduParentPackCommentDao.insertSelective(eduParentPackComment);
	}

	public void searchComment(EduParentPackCommentDto eduParentPackCommentDto) {
		// TODO Auto-generated method stub
		eduParentPackCommentDao.searchComment(eduParentPackCommentDto);
	}

}

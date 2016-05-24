package com.ssic.education.wecaht.handle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.wecaht.handle.dao.EduParentPackCommentDao;
import com.ssic.education.wecaht.handle.dto.EduParentPackCommentDto;
import com.ssic.education.wecaht.handle.pojo.EduParentPackComment;
import com.ssic.education.wecaht.handle.service.IEduParentPackCommentService;

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

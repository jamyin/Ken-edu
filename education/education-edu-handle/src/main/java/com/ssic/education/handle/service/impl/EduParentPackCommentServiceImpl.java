package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.handle.dao.EduParentPackCommentDao;
import com.ssic.education.handle.dto.EduParentPackCommentDto;
import com.ssic.education.handle.pojo.EduParentPackComment;
import com.ssic.education.handle.service.IEduParentPackCommentService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduParentPackCommentServiceImpl implements IEduParentPackCommentService {

	@Autowired
	private EduParentPackCommentDao eduParentPackCommentDao;

	public void saveComment(EduParentPackCommentDto eduParentPackCommentDto) {
		EduParentPackComment eduParentPackComment = BeanUtils.createBeanByTarget(eduParentPackCommentDto, EduParentPackComment.class);
		eduParentPackCommentDao.insertSelective(eduParentPackComment);
	}

	public List<EduParentPackCommentDto> searchComment(EduParentPackCommentDto eduParentPackCommentDto) {
		// TODO Auto-generated method stub
		List<EduParentPackComment> resultList = eduParentPackCommentDao.searchComment(eduParentPackCommentDto);
		List<EduParentPackCommentDto> dataList = BeanUtils.createBeanListByTarget(resultList, EduParentPackCommentDto.class);
		return dataList;
	}

}

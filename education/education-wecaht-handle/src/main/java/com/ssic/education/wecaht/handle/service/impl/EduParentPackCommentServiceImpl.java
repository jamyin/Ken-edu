package com.ssic.education.wecaht.handle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.wecaht.handle.dao.EduParentPackCommentDao;
import com.ssic.education.wecaht.handle.service.IEduParentPackCommentService;

@Service
public class EduParentPackCommentServiceImpl implements IEduParentPackCommentService {

	@Autowired
	private EduParentPackCommentDao eduParentPackCommentDao;

}

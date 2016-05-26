package com.ssic.education.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.edu.dao.EduParentScChDao;
import com.ssic.education.edu.dto.EduParentScChDto;
import com.ssic.education.edu.pojo.EduParentScCh;
import com.ssic.education.edu.service.IEduParentScChService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduParentScChServiceImpl implements IEduParentScChService {

	@Autowired
	private EduParentScChDao eduParentScChDao;
	
	public int saveFollow(EduParentScChDto eduParentScChDto) {
		EduParentScCh eduParentScCh = BeanUtils.createBeanByTarget(eduParentScChDto, EduParentScCh.class);
		return eduParentScChDao.insertSelective(eduParentScCh);
	}
	
	public int updateFollow(EduParentScChDto eduParentScChDto) {
		EduParentScCh eduParentScCh = BeanUtils.createBeanByTarget(eduParentScChDto, EduParentScCh.class);
		return eduParentScChDao.updateByPrimaryKeySelective(eduParentScCh);
	}
	

}

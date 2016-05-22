package com.ssic.education.wecaht.handle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.wecaht.handle.dao.EduParentScChDao;
import com.ssic.education.wecaht.handle.dto.EduParentScChDto;
import com.ssic.education.wecaht.handle.pojo.EduParentScCh;
import com.ssic.education.wecaht.handle.service.IEduParentScChService;

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
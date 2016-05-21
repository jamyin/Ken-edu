package com.ssic.education.wecaht.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.wecaht.handle.dao.EduParentDao;
import com.ssic.education.wecaht.handle.dto.EduParentDto;
import com.ssic.education.wecaht.handle.service.IEduParentService;

@Service
public class EduParentServiceImpl implements IEduParentService {

	@Autowired
	private EduParentDao eduParentDao;
	
	public List<EduParentDto> search(EduParentDto eduParentDto) {
		// TODO Auto-generated method stub
		return eduParentDao.search(eduParentDto);
	}

}

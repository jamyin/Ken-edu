package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.handle.dao.EduParentDao;
import com.ssic.education.handle.dto.EduParentDto;
import com.ssic.education.handle.service.IEduParentService;

@Service
public class EduParentServiceImpl implements IEduParentService {

	@Autowired
	private EduParentDao eduParentDao;
	
	public List<EduParentDto> search(EduParentDto eduParentDto) {
		// TODO Auto-generated method stub
		return eduParentDao.search(eduParentDto);
	}

}

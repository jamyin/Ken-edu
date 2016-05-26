package com.ssic.education.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.edu.dao.EduParentDao;
import com.ssic.education.edu.dto.EduParentDto;
import com.ssic.education.edu.service.IEduParentService;

@Service
public class EduParentServiceImpl implements IEduParentService {

	@Autowired
	private EduParentDao eduParentDao;
	
	public List<EduParentDto> search(EduParentDto eduParentDto) {
		// TODO Auto-generated method stub
		return eduParentDao.search(eduParentDto);
	}

}

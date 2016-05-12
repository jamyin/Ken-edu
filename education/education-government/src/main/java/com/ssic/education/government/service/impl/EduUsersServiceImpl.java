package com.ssic.education.government.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.government.dao.EduUsersDao;
import com.ssic.education.government.dto.EduUsersDto;
import com.ssic.education.government.service.EduUsersService;

@Service
public class EduUsersServiceImpl implements EduUsersService {

	@Autowired
	private EduUsersDao eduUsersDao;
	

	@Override
	public EduUsersDto checkUser(EduUsersDto usersDto) {
		// TODO Auto-generated method stub
		return eduUsersDao.checkUser(usersDto);
	}

}

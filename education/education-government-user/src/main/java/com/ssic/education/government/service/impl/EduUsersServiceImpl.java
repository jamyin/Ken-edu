package com.ssic.education.government.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.government.dao.EduUsersDao;
import com.ssic.education.government.dto.EduUsersDto;
import com.ssic.education.government.pojo.EduUsers;
import com.ssic.education.government.service.EduUsersService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduUsersServiceImpl implements EduUsersService {

	@Autowired
	private EduUsersDao eduUsersDao;
	
	public EduUsersDto checkUser(EduUsersDto usersDto) {
		// TODO Auto-generated method stub
		return eduUsersDao.checkUser(usersDto);
	}

	public boolean validateAccount(EduUsersDto usersDto) {
		// TODO Auto-generated method stub
		return eduUsersDao.validateAccount(usersDto);
	}

	public void save(EduUsersDto usersDto) {
		// TODO Auto-generated method stub
		eduUsersDao.save(usersDto);
	}
	
	public EduUsersDto getUserInfo(EduUsersDto usersDto) {
		return BeanUtils.createBeanByTarget(eduUsersDao.selectByPrimaryKey(usersDto.getId()), EduUsersDto.class);
	}

	public Integer update(EduUsersDto usersDto) {
		EduUsers eduUsers = BeanUtils.createBeanByTarget(usersDto, EduUsers.class);
		return eduUsersDao.updateByPrimaryKeySelective(eduUsers);
	}
}

package com.ssic.education.app.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.mapper.AppUsersMapper;
import com.ssic.education.handle.mapper.EduUsersMapper;

@Repository
public class EduAppUsersDao {

	@Autowired
	@Getter
	private AppUsersMapper appUsersMapper;

	@Autowired
	@Getter
	private EduUsersMapper usersMapper;

	public EduAppUserDto appLogin(EduUsersInfoDto userDto) {
		EduAppUserDto appUser = appUsersMapper.selectLoginInfo(userDto);
		return appUser;
	}
}

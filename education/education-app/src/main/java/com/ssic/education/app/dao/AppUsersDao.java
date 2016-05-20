package com.ssic.education.app.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.mapper.AppUsersMapper;

@Repository
public class AppUsersDao {

	@Autowired
	@Getter
	private AppUsersMapper appUsersMapper;

	public EduAppUserDto appLogin(EduUsersInfoDto userDto) {
		EduAppUserDto appUser = appUsersMapper.selectLoginInfo(userDto);
		return appUser;
	}
}

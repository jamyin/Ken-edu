package com.ssic.education.app.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.AppEduUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.mapper.AppUsersMapper;

@Repository
public class AppUsersDao {

	@Autowired
	@Getter
	private AppUsersMapper appUsersMapper;

	public AppEduUserDto appLogin(EduUsersInfoDto userDto) {
		AppEduUserDto appUser = appUsersMapper.selectLoginInfo(userDto);
		return appUser;
	}

	public int updatePwd(EduUsersInfoDto userDto) {
		int appUser = appUsersMapper.updatePwd(userDto);
		return appUser;
	}

}

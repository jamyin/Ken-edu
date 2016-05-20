package com.ssic.education.app.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.mapper.AppUsersMapper;
import com.ssic.education.government.dto.EduUsersDto;
import com.ssic.education.government.mapper.EduUsersMapper;
import com.ssic.util.base.MyBatisBaseDao;

@Repository
public class EduAppUsersDao extends MyBatisBaseDao<EduUsersDto> {

	@Autowired
	@Getter
	private EduUsersMapper mapper;
	@Autowired
	private AppUsersMapper appUsersMapper;

	public EduAppUserDto appLogin(EduUsersInfoDto userDto) {
		EduAppUserDto appUser = appUsersMapper.selectLoginInfo(userDto);
		return appUser;
	}
}

package com.ssic.education.app.mapper;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;

public interface AppUsersMapper {

	//List<TImsUsersDto> findBy(@Param("user") TImsUsersDto user);

	EduAppUserDto selectLoginInfo(@Param("user") EduUsersInfoDto user);

	int updatePwd(@Param("user") EduUsersInfoDto user);
}

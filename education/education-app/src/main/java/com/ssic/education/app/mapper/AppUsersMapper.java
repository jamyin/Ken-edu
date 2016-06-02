package com.ssic.education.app.mapper;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.app.dto.AppEduUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;

public interface AppUsersMapper {

	AppEduUserDto selectLoginInfo(@Param("user") EduUsersInfoDto user);

	int updatePwd(@Param("user") EduUsersInfoDto user);
}

package com.ssic.education.app.service;

import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;

public interface IEduAppUsersService {

	public EduAppUserDto appLogin(EduUsersInfoDto user);

}

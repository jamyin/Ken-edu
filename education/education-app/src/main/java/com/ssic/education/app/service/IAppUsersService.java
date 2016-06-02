package com.ssic.education.app.service;

import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;

public interface IAppUsersService {
	
	public EduAppUserDto appLogin(EduUsersInfoDto user);

	public int eduUpdatePwd(String oldPwd, String account, String newPwd);
	
	
}

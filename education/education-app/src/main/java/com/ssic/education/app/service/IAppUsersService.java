package com.ssic.education.app.service;

import com.ssic.education.app.dto.AppEduUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;

public interface IAppUsersService {

	public AppEduUserDto appLogin(EduUsersInfoDto user);

	public int eduUpdatePwd(String account, String oldPwd, String newPwd);

}

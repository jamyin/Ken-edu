package com.ssic.education.app.service;

import com.ssic.education.app.dto.AppEduUserDto;
import com.ssic.education.app.dto.AppProUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.handle.pojo.ProUsers;

public interface IAppUsersService {

	public AppEduUserDto eduLogin(EduUsersInfoDto user);

	public AppProUserDto proLogin(ProUsers user);

	public int eduUpdatePwd(String account, String oldPwd, String newPwd);

	public int proUpdatePwd(String account, String oldPwd, String newPwd);

}

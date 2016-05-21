package com.ssic.education.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.dao.AppUsersDao;
import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.service.IEduAppUsersService;
import com.ssic.education.app.token.TokenUtil;

@Service
public class EduAppUsersServiceImpl implements IEduAppUsersService {

	@Autowired
	private AppUsersDao eduUsersDao;

	@Override
	public synchronized EduAppUserDto appLogin(EduUsersInfoDto user) {
		//user.setPassword(MD5Util.md5(user.getPassword()));
		//user.setPassword(user.getPassword());
		EduAppUserDto result = eduUsersDao.appLogin(user);
		if (result != null) {
			result.setToken(TokenUtil.getToken(user.getUserAccount()).getSignature());
			//TODO 第一次登陆创建Token 第二次登录刷新Token 待实现
		}
		return result;
	}

	@Override
	public int updatePwd(String oldPwd, String account, String newPwd) {
		EduUsersInfoDto user = new EduUsersInfoDto();
		user.setPassword(oldPwd);
		user.setUserAccount(account);
		EduAppUserDto result = eduUsersDao.appLogin(user);
		if (result != null) {
			user.setPassword(newPwd);
			return eduUsersDao.updatePwd(user);
		} else {
			return 0;
		}
	}

}

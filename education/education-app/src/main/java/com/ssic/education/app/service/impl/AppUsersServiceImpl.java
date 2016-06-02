package com.ssic.education.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.dao.AppUsersDao;
import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.service.IAppUsersService;
import com.ssic.education.app.token.TokenUtil;
import com.ssic.education.handle.dao.CommitteeDao;
import com.ssic.education.handle.pojo.EduCommittee;
import com.ssic.education.utils.util.StringUtils;

@Service
public class AppUsersServiceImpl implements IAppUsersService {

	@Autowired
	private AppUsersDao eduUsersDao;
	@Autowired
	private CommitteeDao committeeDao;

	@Override
	public synchronized EduAppUserDto appLogin(EduUsersInfoDto user) {
		EduAppUserDto result = eduUsersDao.appLogin(user);
		if (result != null) {
			if (result.getSourceType() == 0 || result.getSourceType() == 2) {
				EduCommittee ctte = committeeDao.getbyId(result.getSourceId());
				if (ctte != null) {
					if (StringUtils.isNotBlank(ctte.getAreaCode())) {
						result.setAreaCode(ctte.getAreaCode());
					}
				}
			}
			result.setToken(TokenUtil.getToken(user.getUserAccount()).getSignature());
			//TODO 第一次登陆创建Token 第二次登录刷新Token 待实现
		}
		return result;
	}

	@Override
	public int eduUpdatePwd(String account, String oldPwd, String newPwd) {
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

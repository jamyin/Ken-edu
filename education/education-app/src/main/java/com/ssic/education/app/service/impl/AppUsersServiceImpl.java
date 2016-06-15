package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.dao.AppProUsersDao;
import com.ssic.education.app.dao.AppUsersDao;
import com.ssic.education.app.dao.SupplierInfoDao;
import com.ssic.education.app.dto.AppEduUserDto;
import com.ssic.education.app.dto.AppProUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.service.IAppUsersService;
import com.ssic.education.app.token.TokenUtil;
import com.ssic.education.handle.dao.CommitteeDao;
import com.ssic.education.handle.pojo.EduCommittee;
import com.ssic.education.handle.pojo.ProUsers;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.redis.WdRedisDao;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.StringUtils;

@Service
public class AppUsersServiceImpl implements IAppUsersService {

	@Autowired
	private AppUsersDao eduUsersDao;
	@Autowired
	private AppProUsersDao proUsersDao;
	@Autowired
	private CommitteeDao committeeDao;
	@Autowired
	private SupplierInfoDao supplierDao;
	@Autowired
	private WdRedisDao<AppEduUserDto> eduRedisdao;
	@Autowired
	private WdRedisDao<AppProUserDto> proRedisdao;

	@Override
	public synchronized AppEduUserDto eduLogin(EduUsersInfoDto user) {
		AppEduUserDto result = eduUsersDao.appLogin(user);
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
			eduRedisdao.set(result, 5040);
		}
		return result;
	}

	@Override
	public synchronized AppProUserDto proLogin(ProUsers user) {

		List<ProUsers> list = proUsersDao.proUserLogin(user);
		if (null != list && !list.isEmpty()) {
			AppProUserDto apud = BeanUtils.createBeanByTarget(list.get(0), AppProUserDto.class);
			apud.setToken(TokenUtil.getToken(apud.getUserAccount()).getSignature());
			if (apud.getSourceId() != null) {
				String supplierName = supplierDao.getSupplierName(apud.getSourceId());
				if (supplierName != null)
					apud.setSupplierName(supplierName);
			}
			apud.setJob("驾驶员");
			proRedisdao.set(apud, 5040);
			return apud;
		} else {
			return null;
		}
	}

	@Override
	public synchronized AppProUserDto proLogin(String account, String password) {
		ProUsers user = new ProUsers();
		List<ProUsers> list = null;
		if (StringUtils.isNotBlank(account)) {
			if (StringUtils.isNotBlank(password)) {
				user.setUserAccount(account);
				user.setPassword(password);
				list = proUsersDao.proUserLogin(user);
			}
		}
		if (null != list && !list.isEmpty()) {
			AppProUserDto apud = BeanUtils.createBeanByTarget(list.get(0), AppProUserDto.class);
			apud.setToken(TokenUtil.getToken(apud.getUserAccount()).getSignature());
			if (apud.getSourceId() != null) {
				String supplierName = supplierDao.getSupplierName(apud.getSourceId());
				if (supplierName != null)
					apud.setSupplierName(supplierName);
			}
			apud.setJob("驾驶员");
			proRedisdao.set(apud, 5040);
			return apud;
		} else {
			return null;
		}
	}

	@Override
	public int eduUpdatePwd(String account, String oldPwd, String newPwd) {
		EduUsersInfoDto user = new EduUsersInfoDto();
		user.setPassword(oldPwd);
		user.setUserAccount(account);
		AppEduUserDto result = eduUsersDao.appLogin(user);
		if (result != null) {
			user.setPassword(newPwd);
			return eduUsersDao.updatePwd(user);
		} else {
			return 0;
		}
	}

	@Override
	public int proUpdatePwd(String account, String oldPwd, String newPwd) {
		ProUsers user = new ProUsers();
		user.setPassword(oldPwd);
		user.setUserAccount(account);
		List<ProUsers> result = proUsersDao.proUserLogin(user);
		if (null != result && !result.isEmpty() && result.size() == 1) {
			return proUsersDao.proUpdatePwd(result.get(0).getId(), newPwd);
		} else {
			return 0;
		}
	}

	@Override
	public void eduLogout(String token) {
		AppEduUserDto eduAppUser = eduRedisdao.get(token, AppEduUserDto.class);
		if (eduAppUser != null) {
			eduRedisdao.delete(eduAppUser, AppEduUserDto.class);
		}

	}

	@Override
	public void proLogout(String token) {
		AppProUserDto proAppUser = proRedisdao.get(token, AppProUserDto.class);
		if (proAppUser != null) {
			proRedisdao.delete(proAppUser, AppProUserDto.class);
		}

	}
}

package com.ssic.education.app.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.AppEduUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.mapper.AppUsersMapper;
import com.ssic.education.handle.mapper.ProUsersMapper;
import com.ssic.education.handle.pojo.ProUsers;
import com.ssic.education.handle.pojo.ProUsersExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.util.StringUtils;

/**
 * 用户系统DAO
 * @author SeanYoung
 */
@Repository
public class AppUsersDao {

	@Autowired
	@Getter
	private AppUsersMapper appUsersMapper;

	@Autowired
	@Getter
	private ProUsersMapper proUserMapper;

	public AppEduUserDto appLogin(EduUsersInfoDto userDto) {
		AppEduUserDto appUser = appUsersMapper.selectLoginInfo(userDto);
		return appUser;
	}

	public int updatePwd(EduUsersInfoDto userDto) {
		int appUser = appUsersMapper.updatePwd(userDto);
		return appUser;
	}

	/**
	 * 团餐公司APP登录
	 * @return
	 */
	public List<ProUsers> proUserLogin(ProUsers proUser) {
		ProUsersExample example = new ProUsersExample();
		ProUsersExample.Criteria criteria = example.createCriteria();
		if (proUser != null) {
			if (StringUtils.isNotBlank(proUser.getUserAccount())) {
				criteria.andUserAccountEqualTo(proUser.getUserAccount());
			}
			if (StringUtils.isNotBlank(proUser.getPassword())) {
				criteria.andPasswordEqualTo(proUser.getPassword());
			}
			criteria.andUserTypeEqualTo("1");
			criteria.andStatEqualTo(DataStatus.ENABLED);
		}
		return proUserMapper.selectByExample(example);
	}

	public int updateProPwd(ProUsers proUser) {
		return 0;
	}

	/**
	 * 团餐公司修改密码
	 * @param id
	 * @param password
	 * @return
	 */
	public int proUpdatePwd(String id, String password) {
		ProUsersExample example = new ProUsersExample();
		ProUsersExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		ProUsers proUser = new ProUsers();
		proUser.setPassword(password);
		proUserMapper.updateByExample(proUser, example);
		return 0;
	}
}

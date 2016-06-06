package com.ssic.education.app.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.handle.mapper.ProUsersMapper;
import com.ssic.education.handle.pojo.ProUsers;
import com.ssic.education.handle.pojo.ProUsersExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.util.StringUtils;

@Repository
public class AppProUsersDao {
	@Autowired
	@Getter
	private ProUsersMapper proUserMapper;

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

	public int proUpdatePwd(String id, String password) {
		ProUsersExample example = new ProUsersExample();
		ProUsersExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		ProUsers proUser = new ProUsers();
		proUser.setPassword(password);
		return proUserMapper.updateByExampleSelective(proUser, example);
	}
}

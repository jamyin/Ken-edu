package com.ssic.education.app.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.ProAppUserDto;
import com.ssic.education.handle.mapper.ProUsersMapper;
import com.ssic.education.handle.pojo.ProUsers;

@Repository
public class ProAppUserDao {
	@Autowired
	@Getter
	private ProUsersMapper proUserMapper;

	/**
	 * 团餐公司APP登录
	 * @return
	 */
	public ProAppUserDto proUserLogin(ProUsers proUser) {
		return null;
	}

	public int updateProPwd(ProUsers proUser) {
		return 0;
	}
}

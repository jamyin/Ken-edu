package com.ssic.education.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ssic.education.provider.dto.ProUsersDto;
import com.ssic.education.handle.pojo.ProUsers;
import com.ssic.education.provider.service.IProUsersService;
import com.ssic.education.provider.util.MD5Util;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.UUIDGenerator;

@Repository
public class ProUsersServiceImpl implements IProUsersService {

	@Override
	public String saveProUsers(ProUsersDto proUsersDto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

package com.ssic.education.provider.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.provider.mapper.ProUsersMapper;
import com.ssic.education.provider.pojo.ProUsers;
import com.ssic.util.base.MyBatisBaseDao;

@Repository
public class ProUsersDao extends MyBatisBaseDao<ProUsers> {
	@Getter
	@Autowired
	private ProUsersMapper mapper;

}
package com.ssic.education.provider.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.handle.mapper.ProUsersMapper;
import com.ssic.education.handle.pojo.ProUsers;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class ProUsersDao extends MyBatisBaseDao<ProUsers> {
	@Getter
	@Autowired
	private ProUsersMapper mapper;

}

package com.ssic.education.provider.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.mapper.ProPackagesMapper;

import com.ssic.education.common.pojo.ProPackages;

import com.ssic.education.utils.mybatis.MyBatisBaseDao;

@Repository
public class ProPackagesDao extends MyBatisBaseDao<ProPackages> {

	@Getter
	@Autowired
	private ProPackagesMapper mapper;

}

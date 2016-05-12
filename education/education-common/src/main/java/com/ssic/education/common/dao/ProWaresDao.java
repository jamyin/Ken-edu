package com.ssic.education.common.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.mapper.ProWaresMapper;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

/**
 * 
 * @author pengpeng
 * @Date: 2016年5月12日 下午5:36:28
 */
@Repository
public class ProWaresDao extends MyBatisBaseDao<ProWares>{

	@Getter
	@Autowired
	private ProWaresMapper mapper;
}

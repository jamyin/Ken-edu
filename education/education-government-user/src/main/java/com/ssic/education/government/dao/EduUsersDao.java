package com.ssic.education.government.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.government.dto.EduUsersDto;
import com.ssic.education.government.mapper.EduUsersMapper;
import com.ssic.education.government.pojo.EduUsers;
import com.ssic.education.government.pojo.EduUsersExample;
import com.ssic.education.utils.digest.MD5Coder;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;

@Repository
public class EduUsersDao extends MyBatisBaseDao<EduUsers>{

	@Autowired
	@Getter
	private EduUsersMapper mapper;

	public EduUsersDto checkUser(EduUsersDto usersDto) {
		EduUsersExample example = new EduUsersExample();
		EduUsersExample.Criteria criteria = example.createCriteria();
		
		if(StringUtils.isEmpty(usersDto.getUserAccount())){
			return null;
		}
		if(StringUtils.isEmpty(usersDto.getPassword())){
			return null;
		}
		
		criteria.andUserAccountEqualTo(usersDto.getUserAccount());
		
		try {
			criteria.andPasswordEqualTo(MD5Coder.encodeMD5Hex(usersDto.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<EduUsers> results = mapper.selectByExample(example);
		if(results.isEmpty()){
			return null;	
		}
		return BeanUtils.createBeanByTarget(results.get(0), EduUsersDto.class);
	}

	public boolean validateAccount(EduUsersDto usersDto) {
		EduUsersExample example = new EduUsersExample();
		EduUsersExample.Criteria criteria = example.createCriteria();
		
		criteria.andUserAccountEqualTo(usersDto.getUserAccount());	

		List<EduUsers> results = mapper.selectByExample(example);
		if(results!=null && results.size()>0){//有值
			return false;
		}else{
			return true;
		}
	}

	public void save(EduUsersDto usersDto) {
		EduUsers record = BeanUtils.createBeanByTarget(usersDto, EduUsers.class);
		mapper.insertSelective(record);
	}	


}

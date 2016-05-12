package com.ssic.education.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProWaresDao;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.common.service.ProWaresService;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class ProWaresServiceImpl implements ProWaresService{
	
	@Autowired
	private ProWaresDao proWaresDao;
	
	public ProWaresDto findById(String id) {
		ProWares proWares = proWaresDao.selectByPrimaryKey(id);
		if (null !=  proWares) {
			return BeanUtils.createBeanByTarget(proWares, ProWaresDto.class);
		}
		return null;
	}

}

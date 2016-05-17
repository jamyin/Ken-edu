package com.ssic.education.government.controller.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.government.controller.admin.service.AdminTabServiceI;
import com.ssic.education.government.dao.AdminTabDao;
import com.ssic.education.government.dto.AdminTabDto;

/*import com.ssic.education.provider.dao.AdminTabDao;
import com.ssic.education.provider.dto.AdminTabDto;
import com.ssic.education.provider.service.AdminTabServiceI;*/

@Service
public class AdminTabServiceImpl implements AdminTabServiceI {
	@Autowired
	private AdminTabDao adminTabDao;

	public List<AdminTabDto> findAll() {
		return adminTabDao.findAll();
	}

	@Override
	public AdminTabDto findById(String id) {
		return adminTabDao.findById(id);
	}

	@Override
	public AdminTabDto findByTabName(String tabName) {
		return adminTabDao.findByTabName(tabName);
	}
}

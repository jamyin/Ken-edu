package com.ssic.education.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.admin.dao.AdminTabDao;
import com.ssic.education.admin.dto.AdminTabDto;
import com.ssic.education.admin.service.AdminTabServiceI;

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

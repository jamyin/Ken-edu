package com.ssic.education.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.provider.dao.AdminTabDao;
import com.ssic.education.provider.dto.AdminTabDto;
import com.ssic.education.provider.service.AdminTabServiceI;

@Service
public class AdminTabServiceImpl implements AdminTabServiceI {
	@Autowired
	private AdminTabDao adminTabDao;

	public List<AdminTabDto> findAll() {
		return adminTabDao.findAll();
	}

	public AdminTabDto findById(String id) {
		return adminTabDao.findById(id);
	}

	public AdminTabDto findByTabName(String tabName) {
		return adminTabDao.findByTabName(tabName);
	}
}

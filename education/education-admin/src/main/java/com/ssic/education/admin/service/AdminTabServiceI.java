package com.ssic.education.admin.service;

import java.util.List;

import com.ssic.education.admin.dto.AdminTabDto;

public interface AdminTabServiceI {

	public List<AdminTabDto> findAll();

	public AdminTabDto findById(String id);

	public AdminTabDto findByTabName(String tabName);
}

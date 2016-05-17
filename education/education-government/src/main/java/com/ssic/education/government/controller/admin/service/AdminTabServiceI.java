package com.ssic.education.government.controller.admin.service;

import java.util.List;

import com.ssic.education.government.dto.AdminTabDto;

public interface AdminTabServiceI {

	public List<AdminTabDto> findAll();

	public AdminTabDto findById(String id);

	public AdminTabDto findByTabName(String tabName);
}

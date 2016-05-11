package com.ssic.education.provider.service;

import java.util.List;

import com.ssic.education.provider.dto.AdminTabDto;

public interface AdminTabServiceI {

	public List<AdminTabDto> findAll();

	public AdminTabDto findById(String id);

	public AdminTabDto findByTabName(String tabName);
}

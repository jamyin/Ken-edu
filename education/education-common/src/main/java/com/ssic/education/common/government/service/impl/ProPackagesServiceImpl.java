package com.ssic.education.common.government.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProPackagesDao;
import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.common.government.service.ProPackagesService;

@Service
public class ProPackagesServiceImpl implements ProPackagesService{

	@Autowired
	private ProPackagesDao proPackagesDao;
	
	public List<ProPackagesDto> getProPackages(ProPackagesDto dto) throws ParseException{
		return proPackagesDao.getProPackages(dto);
	}	
}

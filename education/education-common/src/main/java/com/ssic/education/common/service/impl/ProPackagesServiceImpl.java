package com.ssic.education.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProPackagesDao;
import com.ssic.education.common.service.ProPackagesService;
import com.ssic.education.government.dto.ProPackagesDto;

@Service
public class ProPackagesServiceImpl implements ProPackagesService{

	@Autowired
	private ProPackagesDao proPackagesDao;
	
	public List<ProPackagesDto> getProPackages(ProPackagesDto dto){
		return proPackagesDao.getProPackages(dto);
	}	
}

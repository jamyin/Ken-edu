package com.ssic.education.common.government.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProPackagesDao;
import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.common.government.service.ProPackagesService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

@Service
public class ProPackagesServiceImpl implements ProPackagesService{

	@Autowired
	private ProPackagesDao proPackagesDao;
	
	public List<ProPackagesDto> getProPackages(ProPackagesDto dto) throws ParseException{
		return proPackagesDao.getProPackages(dto);
	}	
	
	public PageResult<ProPackagesDto> fingPackagesPage(ProPackagesDto dto, PageQuery page) {
		List<ProPackagesDto> results = proPackagesDao.fingPackagesPage(dto, page);
		page.setTotal(proPackagesDao.fingPackagesCount(dto));
		return new PageResult<>(page, results);
	}
}

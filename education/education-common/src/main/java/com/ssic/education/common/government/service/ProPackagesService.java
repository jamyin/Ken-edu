package com.ssic.education.common.government.service;

import java.text.ParseException;
import java.util.List;

import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;


public interface ProPackagesService {
	
	public List<ProPackagesDto> getProPackages(ProPackagesDto dto) throws ParseException;
	
	public PageResult<ProPackagesDto> fingPackagesPage(ProPackagesDto dto, PageQuery page);
	
	public void save(ProPackagesDto dto, String jsonWares);
	
	public ProPackagesDto findById (String id);

	public List<ProPackagesDto> searchProSchoolPackage(String customerId,
			String timeDate);
}

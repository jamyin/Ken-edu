package com.ssic.education.common.government.service;

import java.text.ParseException;
import java.util.List;

import com.ssic.education.common.dto.ProPackagesDto;


public interface ProPackagesService {
	
	public List<ProPackagesDto> getProPackages(ProPackagesDto dto) throws ParseException;

}

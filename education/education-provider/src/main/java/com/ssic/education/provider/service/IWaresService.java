package com.ssic.education.provider.service;

import java.util.List;

import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProWaresDto;


public interface IWaresService {

	List<ProWaresDto> findAllWares(ProWaresDto waresDto, PageHelperDto phdto);

	void insertWares(ProWaresDto pro);

	String findSupplierIdByName(String supplierName);



}

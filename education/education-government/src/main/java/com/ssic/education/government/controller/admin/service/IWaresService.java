package com.ssic.education.government.controller.admin.service;

import java.util.List;

import com.ssic.education.common.dto.ProWaresDto;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.government.dto.PageHelperDto;


public interface IWaresService {

	List<ProWaresDto> findAllWares(ProWaresDto waresDto, PageHelperDto phdto);

	void insertWares(ProWaresDto pro);

	String findSupplierIdByName(String supplierName);

	List<ProWaresDto> findWares(ProWaresDto proWaresDto);

	void deleteWares(ProWaresDto waresDto);

	void updateImsUsers(ProWares proWares);



}

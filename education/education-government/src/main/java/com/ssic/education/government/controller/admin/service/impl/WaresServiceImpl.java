package com.ssic.education.government.controller.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dto.ProWaresDto;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.government.controller.admin.service.IWaresService;
import com.ssic.education.government.dao.WaresDao;
import com.ssic.education.government.dto.PageHelperDto;
@Service
public class WaresServiceImpl implements IWaresService {
	@Autowired
	private WaresDao dao;
	
	
	
	@Override
	public List<ProWaresDto> findAllWares(ProWaresDto waresDto, PageHelperDto phdto) {
		// TODO Auto-generated method stub
		return dao.findAllWares(waresDto,phdto);
	}



	@Override
	public void insertWares(ProWaresDto pro) {
		// TODO Auto-generated method stub
		dao.insertWares(pro);
	}



	@Override
	public String findSupplierIdByName(String supplierName) {
		// TODO Auto-generated method stub
		return dao.findSupplierIdByName(supplierName);
	}



	@Override
	public List<ProWaresDto> findWares(ProWaresDto proWaresDto) {
		// TODO Auto-generated method stub
		return dao.findWares(proWaresDto);
	}



	@Override
	public void deleteWares(ProWaresDto waresDto) {
		// TODO Auto-generated method stub
		dao.deleteWares(waresDto);
	}



	@Override
	public void updateImsUsers(ProWares proWares) {
		// TODO Auto-generated method stub
		dao.updateImsUsers(proWares);
	}



}

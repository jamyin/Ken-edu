package com.ssic.education.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.provider.dao.WaresDao;
import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProWaresDto;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.service.IWaresService;
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



	@Override
	public List<SupplierDto> lookSupplier(ProWaresDto dto) {
		// TODO Auto-generated method stub
		return dao.lookSupplier(dto);
	}



}

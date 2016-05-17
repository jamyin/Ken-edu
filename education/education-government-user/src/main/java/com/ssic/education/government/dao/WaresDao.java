package com.ssic.education.government.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProWaresDto;
import com.ssic.education.common.mapper.ProSupplierExMapper;
import com.ssic.education.common.mapper.ProWaresMapper;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.government.dto.PageHelperDto;
import com.ssic.education.government.mapper.WaresExMapper;
import com.ssic.education.utils.util.BeanUtils;


@Repository
public class WaresDao{
	@Autowired
	private ProWaresMapper  mapper;
	@Autowired
	private WaresExMapper  exmapper;
	@Autowired
	private ProSupplierExMapper supMapper;

	public List<ProWaresDto> findAllWares(ProWaresDto waresDto, PageHelperDto ph) {
		List<ProWaresDto> list = exmapper.findWares(waresDto,ph);
		return list;
	}


	public void insertWares(ProWaresDto pro) {
		// TODO Auto-generated method stub
		
		ProWares wares = new ProWares();
		 BeanUtils.copyProperties(pro,wares);
		 wares.setStat(1);
		 wares.setCreateTime(new Date());
		 wares.setLastUpdateTime(new Date());
		mapper.insertSelective(wares);
	}


	public String findSupplierIdByName(String supplierName) {
		// TODO Auto-generated method stub
		return supMapper.findSupplierIdByName(supplierName);
	}


	public List<ProWaresDto> findWares(ProWaresDto proWaresDto) {
		return	exmapper.findWaresById(proWaresDto);
		
	}


	public void deleteWares(ProWaresDto waresDto) {
		// TODO Auto-generated method stub
		String id=	waresDto.getId();
		mapper.deleteByPrimaryKey(id);
	}


	public void updateImsUsers(ProWares proWares) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKey(proWares);
	}


	

}
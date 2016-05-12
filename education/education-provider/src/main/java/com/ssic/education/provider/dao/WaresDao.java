package com.ssic.education.provider.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;









import com.ssic.education.common.mapper.ProWaresMapper;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProWaresDto;
import com.ssic.education.provider.mapper.ProSupplierExMapper;
import com.ssic.education.provider.mapper.ProWaresExMapper;
import com.ssic.education.utils.util.BeanUtils;


@Repository
public class WaresDao {
	@Autowired
	private ProWaresMapper  mapper;
	@Autowired
	private ProWaresExMapper  exmapper;
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
		mapper.insertSelective(wares);
	}


	public String findSupplierIdByName(String supplierName) {
		// TODO Auto-generated method stub
		return supMapper.findSupplierIdByName(supplierName);
	}


	

}

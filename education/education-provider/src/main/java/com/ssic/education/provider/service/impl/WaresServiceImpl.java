package com.ssic.education.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.mapper.ProWaresMapper;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.common.pojo.ProWaresExample;
import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.provider.dao.WaresDao;
import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProWaresDto;
import com.ssic.education.provider.service.IWaresService;
@Service
public class WaresServiceImpl implements IWaresService {
	@Autowired
	private WaresDao dao;
	
	@Autowired
	private ProWaresMapper mapper;
	
	/**
	 * 根据采购品名称，规格，生产商找采购品，只可能有一条有效记录
	 * 
	 * @param name
	 * @param spec
	 * @param manufacturer
	 * @return
	 * @author zhangjiwei
	 * @since 2016.5.21
	 */
	public ProWares findProWarsByNameSpecManu(String name, String spec, String manufacturer, String supplierId) {
		ProWaresExample ex = new ProWaresExample();
		ProWaresExample.Criteria c = ex.createCriteria();
		c.andWaresNameEqualTo(name);
		c.andSpecEqualTo(spec);
		c.andManufacturerEqualTo(manufacturer);
		c.andWayEqualTo(0);
		c.andSupplierIdEqualTo(supplierId);
		c.andStatEqualTo(1);
		List<ProWares> list = mapper.selectByExample(ex);
		// 只可能有一条有效记录
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 批量添加prowares
	 * 
	 * @param list
	 * @author zhangjiwei
	 * @since 2016.5.21
	 */
	public void addProWares(List<ProWares> list) {
		for (ProWares o : list) {
			mapper.insertSelective(o);
		}
	}
	
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

package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.educateion.common.utils.PageHelperDto;
import com.ssic.education.handle.dao.WaresDao;
import com.ssic.education.handle.mapper.ProWaresMapper;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.handle.pojo.ProWaresExample;
import com.ssic.education.handle.service.IWaresService;
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
	
	
	public List<ProWaresDto> findAllWares(ProWaresDto waresDto, PageHelperDto phdto) {
		// TODO Auto-generated method stub
		return dao.findAllWares(waresDto,phdto);
	}



	
	public void insertWares(ProWaresDto pro) {
		// TODO Auto-generated method stub
		dao.insertWares(pro);
	}



	
	public String findSupplierIdByName(String supplierName) {
		// TODO Auto-generated method stub
		return dao.findSupplierIdByName(supplierName);
	}



	
	public List<ProWaresDto> findWares(ProWaresDto proWaresDto) {
		// TODO Auto-generated method stub
		return dao.findWares(proWaresDto);
	}



	
	public void deleteWares(ProWaresDto waresDto) {
		// TODO Auto-generated method stub
		dao.deleteWares(waresDto);
	}



	
	public void updateImsUsers(ProWares proWares) {
		// TODO Auto-generated method stub
		dao.updateImsUsers(proWares);
	}



	//cwf
	public List<SupplierDto> lookSupplier(ProWaresDto dto) {
		// TODO Auto-generated method stub
		return null;//dao.lookSupplier(dto);
	}

	//cwf
	public ProWaresDto findWaresBySupplierId(LedgerDto ledger) {
		// TODO Auto-generated method stub
		return dao.findWaresBySupplierId(ledger);
	}



}

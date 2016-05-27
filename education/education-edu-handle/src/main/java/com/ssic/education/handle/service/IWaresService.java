package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.educateion.common.utils.PageHelperDto;
import com.ssic.education.handle.pojo.ProWares;


public interface IWaresService {

	List<ProWaresDto> findAllWares(ProWaresDto waresDto, PageHelperDto phdto);

	void insertWares(ProWaresDto pro);

	String findSupplierIdByName(String supplierName);

	List<ProWaresDto> findWares(ProWaresDto proWaresDto);

	void deleteWares(ProWaresDto waresDto);

	void updateImsUsers(ProWares proWares);

	List<SupplierDto> lookSupplier(ProWaresDto dto);

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
	ProWares findProWarsByNameSpecManu(String name, String spec, String manufacturer, String supplierId);
	
	/**
	 * 批量添加prowares
	 * 
	 * @param list
	 * @author zhangjiwei
	 * @since 2016.5.21
	 */
	void addProWares(List<ProWares> list);

	ProWaresDto findWaresBySupplierId(LedgerDto ledger);

}

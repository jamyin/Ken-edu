package com.ssic.education.common.government.service;

import java.text.ParseException;
import java.util.List;

import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;


public interface ProPackagesService {
	
	public List<ProPackagesDto> getProPackages(ProPackagesDto dto) throws ParseException;
	
	public PageResult<ProPackagesDto> fingPackagesPage(ProPackagesDto dto, PageQuery page);
	
	public void save(ProPackagesDto dto, String jsonWares, String jsonNutritional);
	
	public ProPackagesDto findById (String id);

	public List<ProPackagesDto> searchProSchoolPackage(String customerId,
			String timeDate);
	
	public void delete(String id);
	

	/**
	* @Title: addPackage
	* @Description: 添加菜谱
	* @author Ken Yin  
	* @date 2016年5月25日 下午2:34:34
	* @return int    返回类型
	 */
	public int addPackage(ProPackagesDto dto);
}

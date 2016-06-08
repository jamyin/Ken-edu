package com.ssic.education.handle.service;

import java.text.ParseException;
import java.util.List;

import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;


public interface ProPackagesService {
	
	public List<ProPackagesDto> getProPackages(ProPackagesDto dto) throws ParseException;
	
	public PageResult<ProPackagesDto> fingPackagesPage(ProPackagesDto dto, PageQuery page);
	
	public PageResult<ProPackagesDto> findPackagesPage(ProPackagesDto dto, PageQuery page);
	
	public void save(ProPackagesDto dto, String jsonWares, String jsonNutritional);
	
	public ProPackagesDto findById (String id);

	public List<ProPackagesDto> searchProSchoolPackage(String customerId,
			String timeDate,Integer type);
	
	public void delete(String id);
	

	/**
	* @Title: addPackage
	* @Description: 添加菜谱
	* @author Ken Yin  
	* @date 2016年5月25日 下午2:34:34
	* @return int    返回类型
	 */
	public int addPackage(ProPackagesDto dto);
	
	/**
	* @Title: searchPackages
	* @Description: 查询学校菜谱
	* @author Ken Yin  
	* @date 2016年5月26日 下午6:11:44
	* @return PageResult<ProPackagesDto>    返回类型
	 */
	public PageResult<ProPackagesDto> searchPackages(ProPackagesDto dto,
			PageQuery page);

	public void updatePackage(ProPackagesDto propackage);
}

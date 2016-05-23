package com.ssic.education.common.government.service.impl;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssic.education.common.dao.ProDishesDao;
import com.ssic.education.common.dao.ProNutritionalDao;
import com.ssic.education.common.dao.ProPackagesDao;
import com.ssic.education.common.dao.ProWaresDao;
import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.common.government.service.ProPackagesService;
import com.ssic.education.common.pojo.ProDishes;
import com.ssic.education.common.pojo.ProNutritional;
import com.ssic.education.common.pojo.ProPackages;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class ProPackagesServiceImpl implements ProPackagesService{

	@Autowired
	private ProPackagesDao proPackagesDao;
	
	@Autowired
	private ProWaresDao proWaresDao;
	
	@Autowired
	private ProDishesDao proDishesDao;
	
	@Autowired
	private ProNutritionalDao proNutritionalDao;
	
	
	public List<ProPackagesDto> getProPackages(ProPackagesDto dto) throws ParseException{
		return proPackagesDao.getProPackages(dto);
	}	
	
	public PageResult<ProPackagesDto> fingPackagesPage(ProPackagesDto dto, PageQuery page) {
		List<ProPackagesDto> results = proPackagesDao.fingPackagesPage(dto, page);
		page.setTotal(proPackagesDao.fingPackagesCount(dto));
		return new PageResult<>(page, results);
	}
	
	public void save(ProPackagesDto dto, String jsonWares){
		List<ProWaresDto> proWaresDtos =  new Gson().fromJson(jsonWares, new TypeToken<List<ProWaresDto>>(){}.getType());
		if (null != proWaresDtos && proWaresDtos.size()>0) {
			List<ProWares> proWaress = BeanUtils.createBeanListByTarget(proWaresDtos, ProWares.class);
			List<ProNutritional> proNutritionals = BeanUtils.createBeanListByTarget(proWaresDtos, ProWares.class);
			ProPackages proPackages = BeanUtils.createBeanByTarget(dto, ProPackages.class);
			proPackagesDao.insertSelective(proPackages);
			for (ProNutritional proNutritional:proNutritionals) {
				proNutritional.setPackageId(proPackages.getId());
				proNutritionalDao.insertSelective(proNutritional);
			}
			for (ProWares proWares : proWaress) {
				proWaresDao.insertSelective(proWares);
				ProDishes proDishes = new ProDishes();
				proDishes.setPackageId(proPackages.getId());
				proDishes.setWaresId(proWares.getId());
				proDishes.setWaresName(proWares.getWaresName());
				proDishesDao.insertSelective(proDishes);
			}
		}			
	}
	
	public ProPackagesDto findById (String id) {
		return proPackagesDao.findById(id);
	}

	@Override
	public List<ProPackagesDto> searchProSchoolPackage(String customerId,String timeDate) {
		List<ProPackages> dataList = proPackagesDao.searchProSchoolPackage(customerId,timeDate);
		List<ProPackagesDto> resultList = BeanUtils.createBeanListByTarget(dataList, ProPackagesDto.class);
		return resultList;
	}
}

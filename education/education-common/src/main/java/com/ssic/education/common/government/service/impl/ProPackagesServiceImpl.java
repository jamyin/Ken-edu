package com.ssic.education.common.government.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssic.education.common.dao.ProDishesDao;
import com.ssic.education.common.dao.ProNutritionalDao;
import com.ssic.education.common.dao.ProPackagesDao;
import com.ssic.education.common.dao.ProWaresDao;
import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.common.dto.ProWaresDto;
import com.ssic.education.common.government.service.ProPackagesService;
import com.ssic.education.common.pojo.ProDishes;
import com.ssic.education.common.pojo.ProNutritional;
import com.ssic.education.common.pojo.ProPackages;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.UUIDGenerator;

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
	
	@Autowired
	private ProDishesDao waresDao;
	
	
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

	public void delete(String id) {
		proPackagesDao.delete(id);
	}
	
	@Override
	public List<ProPackagesDto> searchProSchoolPackage(String customerId,String timeDate) {
		List<ProPackages> dataList = proPackagesDao.searchProSchoolPackage(customerId,timeDate);
		List<ProPackagesDto> resultList = BeanUtils.createBeanListByTarget(dataList, ProPackagesDto.class);
		return resultList;
	}
	
	/**
	 * Ken Yin 20160525
	 */
	@Override
	@Transactional
	public int addPackage(ProPackagesDto dto) {
		ProPackages proPackages = BeanUtils.createBeanByTarget(dto, ProPackages.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			proPackages.setSupplyDate(sdf.parse(dto.getSupplyDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		proPackages.setId(UUIDGenerator.getUUID());
		int packagesFlag = proPackagesDao.insertSelective(proPackages);
		int waresFlag = 0;
		int dishesFlag = 0;
		int nutritionalFlag = 0;
		if(packagesFlag > 0){
			//菜品
			String waresNames_ = dto.getWaresNames().substring(0,dto.getWaresNames().length()-1);   //去逗号
			String waresName[] = waresNames_.split(",");
			
			List<ProWares> waresList = new ArrayList<ProWares>();
			List<ProDishes> dishesList = new ArrayList<ProDishes>();
			for(int i = 0;i < waresName.length; i++){
				ProWares wares = new ProWares();
				wares.setId(UUIDGenerator.getUUID()); 
				wares.setWaresName(waresName[i]);
				wares.setCreateTime(new Date());
				wares.setStat(DataStatus.ENABLED);
				waresList.add(wares);
				
				ProDishes proDishes = new ProDishes();
				proDishes.setId(UUIDGenerator.getUUID()); 
				proDishes.setPackageId(proPackages.getId());
				proDishes.setWaresId(wares.getId());
				proDishes.setWaresName(wares.getWaresName());
				proDishes.setCreateTime(new Date());
				proDishes.setStat(DataStatus.ENABLED);
				dishesList.add(proDishes);
			}
			waresFlag = waresDao.addWaresBatch(waresList);
			dishesFlag = proDishesDao.addDishesBatch(dishesList);
			
			//营养
			String nutritionalNames_ = dto.getNutritionalNames().substring(0,dto.getNutritionalNames().length()-1);   //去逗号
			String nutritionalWeights_ = dto.getNutritionalWeights().substring(0,dto.getNutritionalWeights().length()-1);   //去逗号
			String nutritionalUnits_ = dto.getNutritionalUnits().substring(0,dto.getNutritionalUnits().length()-1);   //去逗号
			
			String nutritionalName[] = nutritionalNames_.split(",");
			String nutritionalWeight[] = nutritionalWeights_.split(",");
			String nutritionalUnit[] = nutritionalUnits_.split(",");
			
			List<ProNutritional> nutritionalList = new ArrayList<ProNutritional>();
			for(int i = 0;i < nutritionalName.length; i++){
				ProNutritional nutritional = new ProNutritional();
				nutritional.setId(UUIDGenerator.getUUID()); 
				nutritional.setPackageId(proPackages.getId());
				
				nutritional.setName(nutritionalName[i]);
				nutritional.setWeight(nutritionalWeight[i]);
				nutritional.setUnit(nutritionalUnit[i]);
				
				nutritional.setCreateTime(new Date());
				nutritional.setStat(DataStatus.ENABLED);
				nutritionalList.add(nutritional);
			}
			nutritionalFlag = proNutritionalDao.addNutritionalBatch(nutritionalList);
		}
		
		if(packagesFlag ==1 && waresFlag ==1 && dishesFlag ==1 && nutritionalFlag ==1){
			return 1;
		}
		return 0;
	}
}

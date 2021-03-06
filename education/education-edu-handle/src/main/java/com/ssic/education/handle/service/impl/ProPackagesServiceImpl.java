package com.ssic.education.handle.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.education.handle.dao.ProDishesDao;
import com.ssic.education.handle.dao.ProNutritionalDao;
import com.ssic.education.handle.dao.ProPackagesDao;
import com.ssic.education.handle.dao.ProWaresDao;
import com.ssic.education.handle.pojo.ProDishes;
import com.ssic.education.handle.pojo.ProNutritional;
import com.ssic.education.handle.pojo.ProPackages;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.handle.service.ProPackagesService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.StringUtils;
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
	
	public PageResult<ProPackagesDto> findPackagesPage(ProPackagesDto dto, PageQuery page) {
		List<ProPackagesDto> results = proPackagesDao.findPackagesPage(dto, page);
		page.setTotal(proPackagesDao.findPackagesCount(dto));
		return new PageResult<>(page, results);
	}
	
	public void save(ProPackagesDto dto, String jsonWares, String jsonNutritional){
		proPackagesDao.eidt(dto, jsonWares, jsonNutritional);	
	}
	
	public ProPackagesDto findById (String id) {
		return proPackagesDao.findById(id);
	}

	public void delete(String id) {
		proPackagesDao.delete(id);
	}
	
	@Override
	public List<ProPackagesDto> searchProSchoolPackage(String customerId,String timeDate,Integer type) {
		List<ProPackages> dataList = proPackagesDao.searchProSchoolPackage(customerId,timeDate,type);
		List<ProPackagesDto> resultList = BeanUtils.createBeanListByTarget(dataList, ProPackagesDto.class);
		return resultList;
	}
	
	/**
	 * Ken Yin 20160525
	 */
	@Override
	@Transactional
	public int addPackage(ProPackagesDto dto) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isNotEmpty(dto.getSupplyDateStr())){
			try {
				dto.setSupplyDate(sdf.parse(dto.getSupplyDateStr()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		ProPackages proPackages = BeanUtils.createBeanByTarget(dto, ProPackages.class);
		proPackages.setCustomerType((short)DataStatus.DISABLED);
		proPackages.setPackageName(proPackages.getType().toString());
		proPackages.setId(UUIDGenerator.getUUID());
		int packagesFlag = proPackagesDao.insertSelective(proPackages);
		int waresFlag = 0;
		int dishesFlag = 0;
		int nutritionalFlag = 0;
		if(packagesFlag > 0){
			//菜品
			String waresNames_ = dto.getWaresNames().substring(0,dto.getWaresNames().length()-1);   //去逗号
			String waresName[] = waresNames_.split(",");
			
//			List<ProWares> waresList = new ArrayList<ProWares>();
			List<ProDishes> dishesList = new ArrayList<ProDishes>();
			for(int i = 0;i < waresName.length; i++){
//				ProWares wares = new ProWares();
//				wares.setId(UUIDGenerator.getUUID()); 
//				wares.setWaresName(waresName[i]);
//				wares.setDishes(true);
//				wares.setCreateTime(new Date());
//				wares.setStat(DataStatus.ENABLED);
//				waresList.add(wares);
				
				ProDishes proDishes = new ProDishes();
				proDishes.setId(UUIDGenerator.getUUID()); 
				proDishes.setPackageId(proPackages.getId());
				proDishes.setName(waresName[i]);
				proDishes.setCreator(dto.getCreator());
				proDishes.setCreateTime(new Date());
				proDishes.setStat(DataStatus.ENABLED);
				dishesList.add(proDishes);
			}
//			waresFlag = waresDao.addWaresBatch(waresList);
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
		
		if(packagesFlag > 0 && waresFlag > 0 && dishesFlag > 0 && nutritionalFlag > 0){
			return 1;
		}
		return 0;
	}

	@Override
	public PageResult<ProPackagesDto> searchPackages(ProPackagesDto dto,
			PageQuery page) {
		List<ProPackagesDto> results = proPackagesDao.fingPackagesPage(dto, page);
		page.setTotal(proPackagesDao.fingPackagesCount(dto));
		return new PageResult<>(page, results);
	}

	@Override
	public void updatePackage(ProPackagesDto propackage) {
		ProPackages propack = BeanUtils.createBeanByTarget(propackage, ProPackages.class);
		proPackagesDao.updateByPrimaryKeySelective(propack);
	}

	@Override
	public List<ProPackagesDto> searchProPackages(List<String> packageIds) {
		List<ProPackages>  dataList = proPackagesDao.searchProPackages(packageIds);
		if(dataList!=null){
			return BeanUtils.createBeanListByTarget(dataList, ProPackagesDto.class);	
		}else{
			return null;
		}
		
	}
}

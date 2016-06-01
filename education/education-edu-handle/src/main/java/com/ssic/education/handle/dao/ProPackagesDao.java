package com.ssic.education.handle.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssic.educateion.common.dto.ProDishesDto;
import com.ssic.educateion.common.dto.ProNutritionalDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.education.handle.dto.EduParentPackCommentDto;
import com.ssic.education.handle.mapper.EduParentPackCommentExMapper;
import com.ssic.education.handle.mapper.EduParentPackCommentMapper;
import com.ssic.education.handle.mapper.EduSchoolExMapper;
import com.ssic.education.handle.mapper.ProDishesExMapper;
import com.ssic.education.handle.mapper.ProDishesMapper;
import com.ssic.education.handle.mapper.ProNutritionalExMapper;
import com.ssic.education.handle.mapper.ProNutritionalMapper;
import com.ssic.education.handle.mapper.ProPackagesMapper;
import com.ssic.education.handle.mapper.ProWaresMapper;
import com.ssic.education.handle.pojo.EduParentPackCommentExample;
import com.ssic.education.handle.pojo.ProDishes;
import com.ssic.education.handle.pojo.ProDishesExample;
import com.ssic.education.handle.pojo.ProNutritional;
import com.ssic.education.handle.pojo.ProNutritionalExample;
import com.ssic.education.handle.pojo.ProPackages;
import com.ssic.education.handle.pojo.ProPackagesExample;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.DateUtils;
import com.ssic.education.utils.util.UUIDGenerator;

/**
 * 
 * @author pengpeng
 * @Date: 2016年5月12日 下午5:36:42
 */
@Repository
public class ProPackagesDao extends MyBatisBaseDao<ProPackages>{

	@Getter
	@Autowired
	private ProPackagesMapper mapper;
	
	@Autowired
	private EduSchoolExMapper schoolMapper;
	
	@Autowired
	private ProNutritionalMapper nuMapper;
	
	@Autowired
	private ProWaresMapper pwMapper;
	
	@Autowired
	private ProDishesExMapper disExMapper;
	
	@Getter
	@Autowired
	private ProDishesMapper disMapper;
	
	@Autowired
	private ProNutritionalExMapper nuExMapper;
	
	@Autowired
	private EduParentPackCommentMapper eppcMapper;
	
	@Autowired
	private EduParentPackCommentExMapper eppcExMapper;
	
	@Transactional
	public void delete(String id) {
		ProPackages proPackages = this.selectByPrimaryKey(id);
		proPackages.setStat(DataStatus.DISABLED);
		this.updateByPrimaryKeySelective(proPackages);
		ProDishesExample example = new ProDishesExample();
		ProDishesExample.Criteria criteria = example.createCriteria();
		criteria.andPackageIdEqualTo(id);
		List<ProDishes> proDishess = disMapper.selectByExample(example);
		for (ProDishes proDishes : proDishess) {
			proDishes.setStat(DataStatus.DISABLED);
			disMapper.updateByPrimaryKeySelective(proDishes);
			ProWares proWares = pwMapper.selectByPrimaryKey(proDishes.getWaresId());
			proWares.setStat(DataStatus.DISABLED);
			pwMapper.updateByPrimaryKeySelective(proWares);
		}
		ProNutritionalExample exampleN = new ProNutritionalExample();
		ProNutritionalExample.Criteria criteriaN = exampleN.createCriteria();
		criteriaN.andPackageIdEqualTo(id);
		List<ProNutritional> proNutritionals = nuMapper.selectByExample(exampleN);
		for (ProNutritional proNutritional:proNutritionals) {
			proNutritional.setStat(DataStatus.DISABLED);
			nuMapper.updateByPrimaryKeySelective(proNutritional);
		}
	}
	
	public List<ProPackagesDto> getProPackages(ProPackagesDto dto) throws ParseException  {
		
		ProPackagesExample example = new ProPackagesExample();
		ProPackagesExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(dto.getSupplierId())) {
			criteria.andSupplierIdEqualTo(dto.getSupplierId());
		}
		if (null != dto.getCustomerType()) {
			criteria.andCustomerTypeEqualTo(dto.getCustomerType());
		}
		if (StringUtils.isNotBlank(dto.getCustomerId())) {
			criteria.andCustomerIdEqualTo(dto.getCustomerId());
		}
		SimpleDateFormat sdf=new SimpleDateFormat(DateUtils.YMD_DASH);  
		String str=sdf.format(new Date()); 
		SimpleDateFormat sdfh=new SimpleDateFormat(DateUtils.YMD_DASH_DATE_TIME);  
		Date startDate = sdfh.parse(str+" 00:00:00");
		Date endDate = sdfh.parse(str+" 23:59:59");
		if (StringUtils.isBlank(dto.getSupplyDateStr())) {
			criteria.andSupplyDateBetween(startDate, endDate);
		}
		else {			
			criteria.andSupplyDateBetween(sdfh.parse(dto.getSupplyDateStr()+" 00:00:00"),sdfh.parse(dto.getSupplyDateStr()+" 23:59:59"));
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		example.setOrderByClause("supply_phase asc");
		List<ProPackagesDto> proPackagesDtos =BeanUtils.createBeanListByTarget(mapper.selectByExample(example), ProPackagesDto.class);		
		for (ProPackagesDto proPackagesDto : proPackagesDtos) {
			ProDishesExample exampleDis = new ProDishesExample();
			ProDishesExample.Criteria criteriaDis = exampleDis.createCriteria();
			if (StringUtils.isNotBlank(proPackagesDto.getId())) {
				criteriaDis.andPackageIdEqualTo(proPackagesDto.getId());
			}	
			criteriaDis.andStatEqualTo(DataStatus.ENABLED);
			List<ProDishesDto> proDishesDtos = BeanUtils.createBeanListByTarget(disMapper.selectByExample(exampleDis), ProDishesDto.class);
			proPackagesDto.setProDishesDtos(proDishesDtos);
			ProNutritionalExample exampleNu = new ProNutritionalExample();
			ProNutritionalExample.Criteria criteriaNu = exampleNu.createCriteria();
			if (StringUtils.isNotBlank(proPackagesDto.getId())) {
				criteriaNu.andPackageIdEqualTo(proPackagesDto.getId());
			}
			criteriaNu.andStatEqualTo(DataStatus.ENABLED);
			List<ProNutritionalDto> proNutritionalDtos = BeanUtils.createBeanListByTarget(nuMapper.selectByExample(exampleNu), ProNutritionalDto.class);
			proPackagesDto.setProNutritionalDtos(proNutritionalDtos);
		}
		List<ProPackagesDto> propackagesDtos = new ArrayList<ProPackagesDto>();
		if (StringUtils.isNotBlank(dto.getSupplyDateStr())) {
			propackagesDtos = schoolMapper.getPackagesById(dto.getCustomerId(), dto.getSupplierId(),sdfh.parse(dto.getSupplyDateStr()+" 00:00:00"),sdfh.parse(dto.getSupplyDateStr()+" 23:59:59"));	
		}else {
			propackagesDtos = schoolMapper.getPackagesById(dto.getCustomerId(), dto.getSupplierId(),startDate,endDate);	
		}			
		for (ProPackagesDto propackagesDto:propackagesDtos) {
			ArrayList<ProPackagesDto> proArrayList = new ArrayList<ProPackagesDto>();
			EduParentPackCommentDto eduParentPackCommentDto = new EduParentPackCommentDto();
			eduParentPackCommentDto.setPackageId(propackagesDto.getId());
			Object sum = eppcExMapper.packagesComment(eduParentPackCommentDto);
			if (sum != null) {
				long listSize = findListByPackages(propackagesDto.getId());
				float b = (float)Math.round((double)((int)sum/3)/listSize);
				propackagesDto.setComment(b);
			} else {
				propackagesDto.setComment(DataStatus.DISABLED);
			}
			
			for (ProPackagesDto proPackagesDto : proPackagesDtos) {
				if (propackagesDto.getSupplyPhase() == proPackagesDto.getSupplyPhase()) {
					proArrayList.add(proPackagesDto);
				}
			}
			propackagesDto.setProPackagesDtos(proArrayList);
		}
		return propackagesDtos;
	}
	@Transactional
	public void eidt(ProPackagesDto dto, String jsonWares, String jsonNutritional) {
		List<ProWares> proWaress =  new Gson().fromJson(jsonWares, new TypeToken<List<ProWares>>(){}.getType());
		List<ProNutritional> proNutritionals = new Gson().fromJson(jsonNutritional, new TypeToken<List<ProNutritional>>(){}.getType());
		ProPackages proPackages = BeanUtils.createBeanByTarget(dto, ProPackages.class);
		this.updateByPrimaryKeySelective(proPackages);
		ProDishesExample exampleDis = new ProDishesExample();
		ProDishesExample.Criteria criteriaDis = exampleDis.createCriteria();
		if (StringUtils.isNotBlank(proPackages.getId())) {
			criteriaDis.andPackageIdEqualTo(proPackages.getId());
		}	
		criteriaDis.andStatEqualTo(DataStatus.ENABLED);
		List<ProDishes> proDishess = disMapper.selectByExample(exampleDis);
		for (ProDishes proDishes: proDishess) {
			proDishes.setStat(DataStatus.DISABLED);
			disMapper.updateByPrimaryKeySelective(proDishes);
			ProWares proWares = pwMapper.selectByPrimaryKey(proDishes.getWaresId());
			proWares.setStat(DataStatus.DISABLED);
			pwMapper.updateByPrimaryKeySelective(proWares);
		}
		ProNutritionalExample exampleNu = new ProNutritionalExample();
		ProNutritionalExample.Criteria criteriaNu = exampleNu.createCriteria();
		if (StringUtils.isNotBlank(proPackages.getId())) {
			criteriaNu.andPackageIdEqualTo(proPackages.getId());
		}
		criteriaNu.andStatEqualTo(DataStatus.ENABLED);
		List<ProNutritional> proNutritionallist = nuMapper.selectByExample(exampleNu);
		for (ProNutritional proNutritional : proNutritionallist) {
			proNutritional.setStat(DataStatus.DISABLED);
			nuMapper.updateByPrimaryKeySelective(proNutritional);
		}
		List<ProDishes> proDishesss = new ArrayList<ProDishes>();
		for (ProWares proWares : proWaress) {
			if (null != proWares && StringUtils.isNotBlank(proWares.getWaresName())) {
				proWares.setDishes(true);
				proWares.setId(UUIDGenerator.getUUID());
				proWares.setCreateTime(new Date());
				proWares.setStat(DataStatus.ENABLED);
			}			
		}
		disExMapper.addWaresBatch(proWaress);
		for (ProWares proWares : proWaress) {
			ProDishes proDishes = new ProDishes();
			proDishes.setWaresId(proWares.getId());
			proDishes.setWaresName(proWares.getWaresName());
			proDishes.setPackageId(proPackages.getId());
			proDishes.setId(UUIDGenerator.getUUID());
			proDishes.setCreateTime(new Date());
			proDishes.setStat(DataStatus.ENABLED);
			proDishesss.add(proDishes);
		}
		disExMapper.addDishesBatch(proDishesss);
		for (ProNutritional proNutritional :proNutritionals) {
			if (null != proNutritional && StringUtils.isNotBlank(proNutritional.getName())) {
				proNutritional.setPackageId(proPackages.getId());
				proNutritional.setId(UUIDGenerator.getUUID());
				proNutritional.setCreateTime(new Date());
				proNutritional.setStat(DataStatus.ENABLED);
			}
			
		}
		nuExMapper.addNutritionalBatch(proNutritionals);
	}
	
	public ProPackagesDto findById (String id) {
		ProPackages proPackages = this.selectByPrimaryKey(id);
		ProPackagesDto proPackagesDto = BeanUtils.createBeanByTarget(proPackages, ProPackagesDto.class);
		ProDishesExample exampleDis = new ProDishesExample();
		ProDishesExample.Criteria criteriaDis = exampleDis.createCriteria();
		if (StringUtils.isNotBlank(proPackagesDto.getId())) {
			criteriaDis.andPackageIdEqualTo(proPackagesDto.getId());
		}	
		criteriaDis.andStatEqualTo(DataStatus.ENABLED);
		List<ProDishesDto> proDishesDtos = BeanUtils.createBeanListByTarget(disMapper.selectByExample(exampleDis), ProDishesDto.class);
		proPackagesDto.setProDishesDtos(proDishesDtos);
		ProNutritionalExample exampleNu = new ProNutritionalExample();
		ProNutritionalExample.Criteria criteriaNu = exampleNu.createCriteria();
		if (StringUtils.isNotBlank(proPackagesDto.getId())) {
			criteriaNu.andPackageIdEqualTo(proPackagesDto.getId());
		}
		criteriaNu.andStatEqualTo(DataStatus.ENABLED);
		List<ProNutritionalDto> proNutritionalDtos = BeanUtils.createBeanListByTarget(nuMapper.selectByExample(exampleNu), ProNutritionalDto.class);
		proPackagesDto.setProNutritionalDtos(proNutritionalDtos);
		return proPackagesDto;
	}
	
	public List<ProPackagesDto> fingPackagesPage(ProPackagesDto dto,PageQuery page) {
		ProPackagesExample example = new ProPackagesExample();
		ProPackagesExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(dto.getCustomerId())) {
			criteria.andCustomerIdEqualTo(dto.getCustomerId());    //查询当前学校
		}
		if(dto.getType() != null){
			criteria.andTypeEqualTo(dto.getType());          //类型
		}
		if(StringUtils.isNotBlank(dto.getSupplyDateStr())){
			criteria.andSupplyDateEqualTo(DateUtils.parse(dto.getSupplyDateStr(), DateUtils.YMD_DASH));          //套餐日期
		}else{
			criteria.andSupplyDateEqualTo(DateUtils.parse(DateUtils.format(new Date(), DateUtils.YMD_DASH), DateUtils.YMD_DASH));	  //不传则默认查询当天
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (null != page) {
            example.setOrderByClause("stat desc,create_time desc limit " + page.getStartNum() + "," + page.getPageSize());
        } else {
            example.setOrderByClause("create_time desc");
        }
		List<ProPackagesDto> proPackagesDtos =BeanUtils.createBeanListByTarget(mapper.selectByExample(example), ProPackagesDto.class);
		for (ProPackagesDto proPackagesDto : proPackagesDtos) {
			ProDishesExample exampleDis = new ProDishesExample();
			ProDishesExample.Criteria criteriaDis = exampleDis.createCriteria();
			if (StringUtils.isNotBlank(proPackagesDto.getId())) {
				criteriaDis.andPackageIdEqualTo(proPackagesDto.getId());
			}	
			criteriaDis.andStatEqualTo(DataStatus.ENABLED);
			List<ProDishesDto> proDishesDtos = BeanUtils.createBeanListByTarget(disMapper.selectByExample(exampleDis), ProDishesDto.class);
			proPackagesDto.setProDishesDtos(proDishesDtos);
			ProNutritionalExample exampleNu = new ProNutritionalExample();
			ProNutritionalExample.Criteria criteriaNu = exampleNu.createCriteria();
			if (StringUtils.isNotBlank(proPackagesDto.getId())) {
				criteriaNu.andPackageIdEqualTo(proPackagesDto.getId());
			}
			criteriaNu.andStatEqualTo(DataStatus.ENABLED);
			List<ProNutritionalDto> proNutritionalDtos = BeanUtils.createBeanListByTarget(nuMapper.selectByExample(exampleNu), ProNutritionalDto.class);
			proPackagesDto.setProNutritionalDtos(proNutritionalDtos);
		}
		return proPackagesDtos;
	}
	
	public long fingPackagesCount(ProPackagesDto dto) {
		ProPackagesExample example = new ProPackagesExample();
		ProPackagesExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(dto.getCustomerId())) {
			criteria.andCustomerIdEqualTo(dto.getCustomerId());    //查询当前学校
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.countByExample(example);
	}

	public List<ProPackages> searchProSchoolPackage(String customerId,
			String timeDate,Integer type) {
		ProPackagesExample example = new ProPackagesExample();
		ProPackagesExample.Criteria criteria = example.createCriteria();
		
		if(StringUtils.isNotEmpty(customerId)){
			criteria.andCustomerIdEqualTo(customerId);	
		}
		if(type!=null){
			criteria.andTypeEqualTo(type);	
		}		
		if(!StringUtils.isNotEmpty(timeDate)){
			Date date = new Date();
			timeDate = DateUtils.format(date, DateUtils.YMD_DASH);
			criteria.andSupplyDateEqualTo(DateUtils.parse(timeDate, DateUtils.YMD_DASH));	
		}else{
			criteria.andSupplyDateEqualTo(DateUtils.parse(timeDate, DateUtils.YMD_DASH));
		}

		criteria.andStatEqualTo(DataStatus.ENABLED);
		
		example.setOrderByClause(" supply_phase asc");
		
		return mapper.selectByExample(example);
	}
	
	public List<ProPackagesDto> searchPackages(ProPackagesDto dto,PageQuery page) {
		ProPackagesExample example = new ProPackagesExample();
		ProPackagesExample.Criteria criteria = example.createCriteria();
		criteria.andCustomerIdEqualTo(dto.getCustomerId());    //查询当前学校
		if(dto.getType() != null){
			criteria.andTypeEqualTo(dto.getType());	
		}
		if(dto.getSupplyPhase() != null){
			criteria.andSupplyPhaseEqualTo(dto.getSupplyPhase());	
		}else{
			Date date = new Date();
			String timeDate = DateUtils.format(date, DateUtils.YMD_DASH);
			criteria.andSupplyDateEqualTo(DateUtils.parse(timeDate, DateUtils.YMD_DASH));
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (null != page) {
            example.setOrderByClause("stat desc,create_time desc limit " + page.getStartNum() + "," + page.getPageSize());
        } else {
            example.setOrderByClause("create_time desc");
        }
		List<ProPackagesDto> proPackagesDtos =BeanUtils.createBeanListByTarget(mapper.selectByExample(example), ProPackagesDto.class);
		for (ProPackagesDto proPackagesDto : proPackagesDtos) {
			ProDishesExample exampleDis = new ProDishesExample();
			ProDishesExample.Criteria criteriaDis = exampleDis.createCriteria();
			if (StringUtils.isNotBlank(proPackagesDto.getId())) {
				criteriaDis.andPackageIdEqualTo(proPackagesDto.getId());
			}	
			criteriaDis.andStatEqualTo(DataStatus.ENABLED);
			List<ProDishesDto> proDishesDtos = BeanUtils.createBeanListByTarget(disMapper.selectByExample(exampleDis), ProDishesDto.class);
			proPackagesDto.setProDishesDtos(proDishesDtos);
			ProNutritionalExample exampleNu = new ProNutritionalExample();
			ProNutritionalExample.Criteria criteriaNu = exampleNu.createCriteria();
			if (StringUtils.isNotBlank(proPackagesDto.getId())) {
				criteriaNu.andPackageIdEqualTo(proPackagesDto.getId());
			}
			criteriaNu.andStatEqualTo(DataStatus.ENABLED);
			List<ProNutritionalDto> proNutritionalDtos = BeanUtils.createBeanListByTarget(nuMapper.selectByExample(exampleNu), ProNutritionalDto.class);
			proPackagesDto.setProNutritionalDtos(proNutritionalDtos);
		}
		return proPackagesDtos;
	}
	
	public long findListByPackages(String packageId) {
		EduParentPackCommentExample example = new EduParentPackCommentExample();
		EduParentPackCommentExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(packageId)) {
			criteria.andPackageIdEqualTo(packageId);
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return eppcMapper.countByExample(example);
	}
}

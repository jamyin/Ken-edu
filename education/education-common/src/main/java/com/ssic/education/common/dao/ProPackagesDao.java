package com.ssic.education.common.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProDishesDto;
import com.ssic.education.common.dto.ProNutritionalDto;
import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.common.mapper.EduSchoolExMapper;
import com.ssic.education.common.mapper.EduSchoolMapper;
import com.ssic.education.common.mapper.ProDishesMapper;
import com.ssic.education.common.mapper.ProNutritionalMapper;
import com.ssic.education.common.mapper.ProPackagesMapper;
import com.ssic.education.common.pojo.ProDishesExample;
import com.ssic.education.common.pojo.ProNutritionalExample;
import com.ssic.education.common.pojo.ProPackages;
import com.ssic.education.common.pojo.ProPackagesExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.DateUtils;

import freemarker.core._RegexBuiltins.matchesBI;

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
	
	@Getter
	@Autowired
	private ProDishesMapper disMapper;
	
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
		if (null == dto.getSupplyDate()) {
			criteria.andSupplyDateBetween(startDate, endDate);
		}
		if (StringUtils.isNotBlank(dto.getSupplyDate())) {			
			criteria.andSupplyDateBetween(sdfh.parse(dto.getSupplyDate()+" 00:00:00"),sdfh.parse(dto.getSupplyDate()+" 23:59:59"));
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
		if (StringUtils.isNotBlank(dto.getSupplyDate())) {
			propackagesDtos = schoolMapper.getPackagesById(dto.getCustomerId(), dto.getSupplierId(),sdfh.parse(dto.getSupplyDate()+" 00:00:00"),sdfh.parse(dto.getSupplyDate()+" 23:59:59"));	
		}else {
			propackagesDtos = schoolMapper.getPackagesById(dto.getCustomerId(), dto.getSupplierId(),startDate,endDate);	
		}			
		for (ProPackagesDto propackagesDto:propackagesDtos) {
			ArrayList<ProPackagesDto> proArrayList = new ArrayList<ProPackagesDto>();
			for (ProPackagesDto proPackagesDto : proPackagesDtos) {
				if (propackagesDto.getSupplyPhase() == proPackagesDto.getSupplyPhase()) {
					proArrayList.add(proPackagesDto);
				}
			}
			propackagesDto.setProPackagesDtos(proArrayList);
		}
		return propackagesDtos;
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
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.countByExample(example);
	}
}

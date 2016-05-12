package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssic.education.common.mapper.ProDishesMapper;
import com.ssic.education.common.mapper.ProPackagesMapper;
import com.ssic.education.common.pojo.ProDishes;
import com.ssic.education.common.pojo.ProDishesExample;
import com.ssic.education.common.pojo.ProPackages;
import com.ssic.education.common.pojo.ProPackagesExample;
import com.ssic.education.government.dto.ProDishesDto;
import com.ssic.education.government.dto.ProPackagesDto;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;


public class ProPackagesDao extends MyBatisBaseDao<ProPackages>{

	@Getter
	@Autowired
	private ProPackagesMapper mapper;
	
	@Getter
	@Autowired
	private ProDishesMapper disMapper;
	
	public List<ProPackagesDto> getProPackages(ProPackagesDto dto) {
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
		if (null != dto.getSupplyDate()) {
			criteria.andSupplyDateEqualTo(dto.getSupplyDate());
		}
		List<ProPackagesDto> proPackagesDtos =BeanUtils.createBeanListByTarget(mapper.selectByExample(example), ProPackagesDto.class);
		for (ProPackagesDto proPackagesDto : proPackagesDtos) {
			ProDishesExample exampleDis = new ProDishesExample();
			ProDishesExample.Criteria criteriaDis = exampleDis.createCriteria();
			if (StringUtils.isNotBlank(proPackagesDto.getId())) {
				criteriaDis.andPackageIdEqualTo(proPackagesDto.getId());
			}			
			List<ProDishesDto> proDishesDtos = BeanUtils.createBeanListByTarget(disMapper.selectByExample(exampleDis), ProDishesDto.class);
			proPackagesDto.setProDishesDtos(proDishesDtos);
		}
		return proPackagesDtos;
	}
}

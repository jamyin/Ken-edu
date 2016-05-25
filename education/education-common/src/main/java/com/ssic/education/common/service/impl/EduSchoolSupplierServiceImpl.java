package com.ssic.education.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.EduSchoolSupplierDao;
import com.ssic.education.common.dto.EduCanteenDto;
import com.ssic.education.common.dto.EduSchoolSupplierDto;
import com.ssic.education.common.pojo.EduSchoolSupplier;
import com.ssic.education.common.service.IEduSchoolSupplierService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduSchoolSupplierServiceImpl implements IEduSchoolSupplierService{

	@Autowired
	private EduSchoolSupplierDao eduSchoolSupplierDao;
	
	
	@Override
	public List<EduSchoolSupplierDto> searchEduSchoolSupplierListDto(EduSchoolSupplierDto eduSchoolSupplierDto) {
		List<EduSchoolSupplier> dataList = eduSchoolSupplierDao.searchEduSchoolSupplierDto(eduSchoolSupplierDto);
		List<EduSchoolSupplierDto> resultList = BeanUtils.createBeanListByTarget(dataList, EduSchoolSupplierDto.class);
		return resultList;
	}
	
	@Override
	public EduSchoolSupplierDto searchEduSchoolSupplierDto(EduSchoolSupplierDto eduSchoolSupplierDto) {
		List<EduSchoolSupplier> dataList = eduSchoolSupplierDao.searchEduSchoolSupplierDto(eduSchoolSupplierDto);
		List<EduSchoolSupplierDto> resultList = BeanUtils.createBeanListByTarget(dataList, EduSchoolSupplierDto.class);
		if(!resultList.isEmpty()){
			return resultList.get(0);
		}
		return null;
	}


}

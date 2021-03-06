package com.ssic.education.handle.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduSchoolSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.education.handle.dao.EduSchoolSupplierDao;
import com.ssic.education.handle.pojo.EduSchoolSupplier;
import com.ssic.education.handle.service.IEduSchoolSupplierService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduSchoolSupplierServiceImpl implements IEduSchoolSupplierService{

	@Autowired
	private EduSchoolSupplierDao eduSchoolSupplierDao;
	
	
	
	public List<EduSchoolSupplierDto> searchEduSchoolSupplierListDto(EduSchoolSupplierDto eduSchoolSupplierDto) {
		List<EduSchoolSupplier> dataList = eduSchoolSupplierDao.searchEduSchoolSupplierDto(eduSchoolSupplierDto);
		List<EduSchoolSupplierDto> resultList = BeanUtils.createBeanListByTarget(dataList, EduSchoolSupplierDto.class);
		return resultList;
	}
	
	
	public EduSchoolSupplierDto searchEduSchoolSupplierDto(EduSchoolSupplierDto eduSchoolSupplierDto) {
		List<EduSchoolSupplier> dataList = eduSchoolSupplierDao.searchEduSchoolSupplierDto(eduSchoolSupplierDto);
		List<EduSchoolSupplierDto> resultList = BeanUtils.createBeanListByTarget(dataList, EduSchoolSupplierDto.class);
		if(!resultList.isEmpty()){
			return resultList.get(0);
		}
		return null;
	}

	
	public String findSchoolIdByReceiverId(String receiverName,String sourceId) {
		return eduSchoolSupplierDao.findSchoolIdByReceiverId(receiverName,sourceId);
	}
	
	public int save (EduSchoolSupplierDto eduSchoolSupplierDto) {
		EduSchoolSupplier enEduSchoolSupplier = BeanUtils.createBeanByTarget(eduSchoolSupplierDto, EduSchoolSupplier.class);
		if (StringUtils.isNotBlank(enEduSchoolSupplier.getId())) {
			return eduSchoolSupplierDao.updateByPrimaryKeySelective(enEduSchoolSupplier);
		}
		List<EduSchoolSupplier> eduSchoolSuppliers= eduSchoolSupplierDao.searchEduSchoolSupplierDto(eduSchoolSupplierDto);
		if (null != eduSchoolSuppliers && eduSchoolSuppliers.size()>0) {
			for (EduSchoolSupplier eduSchoolSupplier : eduSchoolSuppliers) {
				eduSchoolSupplier.setStat(DataStatus.DISABLED);
				eduSchoolSupplierDao.updateByPrimaryKeySelective(eduSchoolSupplier);
			}
		}		
		return eduSchoolSupplierDao.insertSelective(enEduSchoolSupplier);
	}


	@Override
	public List<SupplierDto> searchEduSchoolSupplierListDto(
			String schoolId) {
		return eduSchoolSupplierDao.searchEduSchoolSupplierListDto(schoolId);
	}


}

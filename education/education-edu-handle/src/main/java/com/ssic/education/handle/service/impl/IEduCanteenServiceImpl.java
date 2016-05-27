package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduCanteenDto;
import com.ssic.education.handle.dao.EduCanteenDao;
import com.ssic.education.handle.pojo.EduCanteen;
import com.ssic.education.handle.service.IEduCanteenService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class IEduCanteenServiceImpl implements IEduCanteenService {

	@Autowired
	private EduCanteenDao eduCanteenDao;

	
	public EduCanteenDto searchEduCanteenDto(EduCanteenDto eduCanteenDto) {
		List<EduCanteen> dataList = eduCanteenDao.searchEduCanteenDto(eduCanteenDto);
		List<EduCanteenDto> resultList = BeanUtils.createBeanListByTarget(dataList, EduCanteenDto.class);
		if(!resultList.isEmpty()){
			return resultList.get(0);
		}
		return null;
	}


	public List<EduCanteenDto> searchEduCanteenListDto(EduCanteenDto eduCanteenDto) {
		List<EduCanteen> dataList = eduCanteenDao.searchEduCanteenDto(eduCanteenDto);
		List<EduCanteenDto> resultList = BeanUtils.createBeanListByTarget(dataList, EduCanteenDto.class);
		return resultList;
	}
	
}

package com.ssic.education.common.government.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.EduCanteenDao;
import com.ssic.education.common.dto.EduCanteenDto;
import com.ssic.education.common.government.service.IEduCanteenService;
import com.ssic.education.common.pojo.EduCanteen;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class IEduCanteenServiceImpl implements IEduCanteenService {

	@Autowired
	private EduCanteenDao eduCanteenDao;

	@Override
	public EduCanteenDto searchEduCanteenDto(EduCanteenDto eduCanteenDto) {
		List<EduCanteen> dataList = eduCanteenDao.searchEduCanteenDto(eduCanteenDto);
		List<EduCanteenDto> resultList = BeanUtils.createBeanListByTarget(dataList, EduCanteenDto.class);
		if(!resultList.isEmpty()){
			return resultList.get(0);
		}
		return null;
	}

	@Override
	public List<EduCanteenDto> searchEduCanteenListDto(EduCanteenDto eduCanteenDto) {
		List<EduCanteen> dataList = eduCanteenDao.searchEduCanteenDto(eduCanteenDto);
		List<EduCanteenDto> resultList = BeanUtils.createBeanListByTarget(dataList, EduCanteenDto.class);
		return resultList;
	}
	
}

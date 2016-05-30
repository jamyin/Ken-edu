package com.ssic.education.handle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.education.handle.dao.InformationDao;
import com.ssic.education.handle.pojo.EduInformation;
import com.ssic.education.handle.service.IEduInformationService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduInformationServiceImpl implements IEduInformationService{

	@Autowired
	private InformationDao informationDao;

	@Override
	public int saveInfomation(EduInformationDto eduInformationDto) {
		// TODO Auto-generated method stub
		EduInformation eduInformation = BeanUtils.createBeanByTarget(eduInformationDto, EduInformation.class);
		return informationDao.insertSelective(eduInformation);
	}

}

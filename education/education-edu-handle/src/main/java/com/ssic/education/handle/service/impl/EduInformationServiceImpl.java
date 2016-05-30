package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.educateion.common.dto.EduInformationListDto;
import com.ssic.education.handle.dao.InformationDao;
import com.ssic.education.handle.pojo.EduInformation;
import com.ssic.education.handle.pojo.EduInformationList;
import com.ssic.education.handle.service.IEduInformationService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduInformationServiceImpl implements IEduInformationService {

	@Autowired
	private InformationDao informationDao;

	@Override
	public int saveInfomation(EduInformationDto eduInformationDto) {
		// TODO Auto-generated method stub
		EduInformation eduInformation = BeanUtils.createBeanByTarget(
				eduInformationDto, EduInformation.class);
		return informationDao.insertSelective(eduInformation);
	}

	@Override
	public EduInformationDto search(String infoId) {
		EduInformation pojo = informationDao.selectByPrimaryKey(infoId);
		return BeanUtils.createBeanByTarget(pojo, EduInformationDto.class);
	}

	@Override
	public PageResult<EduInformationDto> searchInfomation(EduInformationDto eduInformationDto,PageQuery pageQuery) {		
		List<EduInformation> results = informationDao.findInformationList(eduInformationDto,pageQuery);
		List<EduInformationDto> dataList = BeanUtils.createBeanListByTarget(results, EduInformationDto.class);
		pageQuery.setTotal(informationDao.selectInformationAccount(eduInformationDto));
		return new PageResult<EduInformationDto>(pageQuery, dataList);
}

}

package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.service.IInformationService;
import com.ssic.education.common.dao.InformationDao;
import com.ssic.education.common.dto.EduInformationDto;
import com.ssic.education.common.pojo.EduInformation;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

/**
 * @ClassName: InformationServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ken Yin
 * @date 2016年5月20日 上午11:02:07
 *
 */
@Service
public class InformationServiceImpl implements IInformationService{

	@Autowired
	private InformationDao informationDao;

	@Override
	public PageResult<EduInformationDto> findInformationList(EduInformationDto eduInformationDto,
			PageQuery query) {
		List<EduInformation> list = informationDao.findInformationList(eduInformationDto, query);
		List<EduInformationDto> InformationDtoList = BeanUtils.createBeanListByTarget(list, EduInformationDto.class);
		int total = informationDao.selectInformationAccount(eduInformationDto);
		query.setTotal(total);
		return new PageResult<EduInformationDto>(query, InformationDtoList);
	}

	@Override
	public EduInformationDto findInformationDetial(String id) {
		EduInformation eduInformation = informationDao.findInformationDetial(id);
		EduInformationDto dtoList = BeanUtils.createBeanByTarget(eduInformation, EduInformationDto.class);
		return dtoList;
	}


}


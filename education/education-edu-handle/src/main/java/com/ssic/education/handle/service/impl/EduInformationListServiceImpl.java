package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduInformationListDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.dao.EduInformationListDao;
import com.ssic.education.handle.pojo.EduInformationList;
import com.ssic.education.handle.service.IEduInformationListService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduInformationListServiceImpl implements IEduInformationListService {

	@Autowired
	private EduInformationListDao eduInformationListDao;

	@Override
	public void save(EduInformationListDto eduInformationListDto) {
		EduInformationList eduInformationList = BeanUtils.createBeanByTarget(eduInformationListDto, EduInformationList.class);
		eduInformationListDao.insertSelective(eduInformationList);
		
	}

	@Override
	public void saveList(List<EduInformationListDto> dataList) {
		//需要单独sql 处理
		for(EduInformationListDto dto : dataList){
			this.save(dto);
		}
	}

	@Override
	public PageResult<EduInformationListDto> searchEduInformationList(PageQuery pageQuery) {		
			List<EduInformationList> results = eduInformationListDao.searchEduInformationList(pageQuery);
			List<EduInformationListDto> dataList = BeanUtils.createBeanListByTarget(results, EduInformationListDto.class);
			pageQuery.setTotal(eduInformationListDao.count());
			return new PageResult<EduInformationListDto>(pageQuery, dataList);
	}

}

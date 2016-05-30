package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.EduInformationListDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

public interface IEduInformationListService {
	public void save(EduInformationListDto eduInformationListDto);

	public void saveList(List<EduInformationListDto> dataList);

	public PageResult<EduInformationListDto> searchEduInformationList(EduInformationListDto eduInformationListDto,
			PageQuery pageQuery); 
}

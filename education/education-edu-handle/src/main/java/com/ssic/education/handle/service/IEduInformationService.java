package com.ssic.education.handle.service;

import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

public interface IEduInformationService {

	int saveInfomation(EduInformationDto eduInformationDto);

	EduInformationDto search(String infoId);

	PageResult<EduInformationDto> searchInfomation(EduInformationDto eduInformationDto,PageQuery pageQuery);
}

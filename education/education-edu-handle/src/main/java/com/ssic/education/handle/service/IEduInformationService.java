package com.ssic.education.handle.service;

import com.ssic.educateion.common.dto.EduInformationDto;

public interface IEduInformationService {

	int saveInfomation(EduInformationDto eduInformationDto);

	EduInformationDto search(String infoId);
}

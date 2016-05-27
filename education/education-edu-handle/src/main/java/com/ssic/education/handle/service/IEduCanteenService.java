package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.EduCanteenDto;

public interface IEduCanteenService {

	public EduCanteenDto searchEduCanteenDto(EduCanteenDto eduCanteenDto);
	
	public List<EduCanteenDto> searchEduCanteenListDto(EduCanteenDto eduCanteenDto);
}

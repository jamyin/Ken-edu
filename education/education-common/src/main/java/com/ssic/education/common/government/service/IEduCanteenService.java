package com.ssic.education.common.government.service;

import java.util.List;

import com.ssic.education.common.dto.EduCanteenDto;

public interface IEduCanteenService {

	public EduCanteenDto searchEduCanteenDto(EduCanteenDto eduCanteenDto);
	
	public List<EduCanteenDto> searchEduCanteenListDto(EduCanteenDto eduCanteenDto);
}

package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.education.handle.dto.EduParentScChDto;

public interface IEduParentScChService {

	int saveFollow(EduParentScChDto eduParentScChDto);
	
	int updateFollow(EduParentScChDto eduParentScChDto);

	List<EduParentScChDto> searchParentScChDtoList(EduParentScChDto eduParentScChDto);

}

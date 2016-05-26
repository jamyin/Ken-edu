package com.ssic.education.edu.service;

import java.util.List;

import com.ssic.education.edu.dto.EduParentScChDto;

public interface IEduParentScChService {

	int saveFollow(EduParentScChDto eduParentScChDto);
	
	int updateFollow(EduParentScChDto eduParentScChDto);

	List<EduParentScChDto> searchParentScChDtoList(EduParentScChDto eduParentScChDto);

}

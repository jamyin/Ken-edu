package com.ssic.education.wecaht.handle.service;

import java.util.List;

import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.education.wecaht.handle.dto.EduParentScChDto;

public interface IEduParentScChService {

	int saveFollow(EduParentScChDto eduParentScChDto);
	
	int updateFollow(EduParentScChDto eduParentScChDto);

	List<EduParentScChDto> searchFollowList(EduParentScChDto eduParentScChDto);

}

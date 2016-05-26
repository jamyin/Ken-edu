package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.education.handle.dto.EduParentDto;

public interface IEduParentService {
	public List<EduParentDto> search(EduParentDto eduParentDto);
}

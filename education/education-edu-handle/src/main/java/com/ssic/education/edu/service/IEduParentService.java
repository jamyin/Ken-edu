package com.ssic.education.edu.service;

import java.util.List;

import com.ssic.education.edu.dto.EduParentDto;

public interface IEduParentService {
	public List<EduParentDto> search(EduParentDto eduParentDto);
}

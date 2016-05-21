package com.ssic.education.wecaht.handle.service;

import java.util.List;

import com.ssic.education.wecaht.handle.dto.EduParentDto;

public interface IEduParentService {
	public List<EduParentDto> search(EduParentDto eduParentDto);
}

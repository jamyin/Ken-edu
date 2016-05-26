package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.ProEmployeeDto;
import com.ssic.educateion.common.utils.PageHelperDto;

public interface IEmployeeService {

	List<ProEmployeeDto> findAllEmployee(ProEmployeeDto pe, PageHelperDto phdto);

	void insertEmployee(ProEmployeeDto pe);

}

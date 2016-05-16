package com.ssic.education.provider.service;

import java.util.List;

import com.ssic.education.common.pojo.ProEmployee;
import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProEmployeeDto;

public interface IEmployeeService {

	List<ProEmployeeDto> findAllEmployee(ProEmployeeDto pe, PageHelperDto phdto);

	void insertEmployee(ProEmployeeDto pe);

}

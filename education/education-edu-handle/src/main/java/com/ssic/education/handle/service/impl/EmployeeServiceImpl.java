package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.ProEmployeeDto;
import com.ssic.educateion.common.utils.PageHelperDto;
import com.ssic.education.handle.dao.EmployeeDao;
import com.ssic.education.handle.service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private  EmployeeDao dao;
	
	
	
	public List<ProEmployeeDto> findAllEmployee(ProEmployeeDto pe, PageHelperDto phdto) {
		// TODO Auto-generated method stub
		return dao.findAllEmployee(pe,phdto);
	}



	public void insertEmployee(ProEmployeeDto pe) {
		// TODO Auto-generated method stub
		dao.insertEmployee(pe);
	}

}

package com.ssic.education.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.provider.dao.EmployeeDao;
import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProEmployeeDto;
import com.ssic.education.provider.service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private  EmployeeDao dao;
	
	
	
	@Override
	public List<ProEmployeeDto> findAllEmployee(ProEmployeeDto pe, PageHelperDto phdto) {
		// TODO Auto-generated method stub
		return dao.findAllEmployee(pe,phdto);
	}



	@Override
	public void insertEmployee(ProEmployeeDto pe) {
		// TODO Auto-generated method stub
		dao.insertEmployee(pe);
	}

}

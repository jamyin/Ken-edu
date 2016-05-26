package com.ssic.education.handle.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.ProEmployeeDto;
import com.ssic.educateion.common.utils.PageHelperDto;
import com.ssic.education.handle.mapper.ProEmployeeExMapper;
import com.ssic.education.handle.mapper.ProEmployeeMapper;
import com.ssic.education.handle.pojo.ProEmployee;
import com.ssic.education.utils.util.BeanUtils;

@Repository
public class EmployeeDao {
	@Autowired
	private ProEmployeeMapper mapper;

	@Autowired
	private ProEmployeeExMapper exmapper;

	public List<ProEmployeeDto> findAllEmployee(ProEmployeeDto pe,
			PageHelperDto phdto) {
		// TODO Auto-generated method stub
		return exmapper.findAllEmployee(pe, phdto);
	}

	public void insertEmployee(ProEmployeeDto pe) {
		// TODO Auto-generated method stub
		ProEmployee record = new ProEmployee();
		BeanUtils.copyProperties(pe, record);

		record.setCreateTime(new Date());
		record.setLastUpdateTime(new Date());

		mapper.insertSelective(record);
	}

}

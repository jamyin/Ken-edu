package com.ssic.education.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.admin.service.ISchoolSupplierService;
import com.ssic.education.common.dao.SchoolSupplierDao;
import com.ssic.education.common.dto.PageHelperDto;
import com.ssic.education.common.dto.SchoolSupplierDto;
import com.ssic.education.common.pageModel.PageHelper;
import com.ssic.education.common.pojo.SchoolSupplier;
import com.ssic.util.BeanUtils;

@Service
public class SchoolSupplierServiceImpl implements ISchoolSupplierService{

	@Autowired
	private SchoolSupplierDao schoolSupplierDao;
	
	
	@Override
	public List<SchoolSupplierDto> findByPage(
			SchoolSupplierDto schoolSupplierDto, PageHelper ph) {
		// TODO Auto-generated method stub
	    PageHelperDto pageHelperDto = exChangePH(ph);
		List<SchoolSupplierDto> list = schoolSupplierDao.findExByPage(schoolSupplierDto, pageHelperDto);
		return list;
	}
	
	//分页转换
	public PageHelperDto exChangePH(PageHelper ph){
		PageHelperDto pageHelperDto = new PageHelperDto();
		pageHelperDto.setOrder(ph.getOrder());
		pageHelperDto.setPage(ph.getPage());
		pageHelperDto.setRows(ph.getRows());
		pageHelperDto.setSort(ph.getSort());
		pageHelperDto.setBeginRow((ph.getPage() - 1) * ph.getRows());
		return pageHelperDto;
	}

	@Override
	public Integer findCountByPage(SchoolSupplierDto schoolSupplierDto,
			PageHelper ph) {
		// TODO Auto-generated method stub
	    PageHelperDto pageHelperDto = exChangePH(ph);
		int count = schoolSupplierDao.findExCountByPage(schoolSupplierDto, pageHelperDto);
		return count;
	}
	
	

}

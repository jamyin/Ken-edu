package com.ssic.education.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssic.education.admin.service.ISchoolSupplierService;
import com.ssic.test.common.dao.SchoolSupplierDao;
import com.ssic.test.common.dto.PageHelperDto;
import com.ssic.test.common.dto.SchoolSupplierDto;
import com.ssic.test.common.pageModel.PageHelper;
import com.ssic.test.common.pojo.SchoolSupplier;
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

	@Override
	public Integer insertSchoolSupplier(SchoolSupplierDto schoolSupplierDto) {
		// TODO Auto-generated method stub
		SchoolSupplier schoolSupplier = new SchoolSupplier();
		BeanUtils.copyProperties(schoolSupplierDto, schoolSupplier);		
		return schoolSupplierDao.insertSchoolSupplier(schoolSupplier);
	}

	@Override
	@Transactional
	public void deleteschoolSupplier(String id) {
		// TODO Auto-generated method stub
		SchoolSupplier schoolSupplier = new SchoolSupplier();
		schoolSupplier.setId(id);
		//删除加工商
		schoolSupplierDao.deleteSchoolSupplier(schoolSupplier);
        //删除加工商学校关系
		schoolSupplierDao.deleteSchoolSupplierRel(id);
	}

	@Override
	public List<SchoolSupplierDto> findBy(SchoolSupplierDto schoolSupplierDto) {
		// TODO Auto-generated method stub
		PageHelperDto pageHelperDto = new PageHelperDto();
		pageHelperDto.setBeginRow(0);
		pageHelperDto.setRows(0);
		return schoolSupplierDao.findExByPage(schoolSupplierDto, pageHelperDto);
	}

	@Override
	public void updateschoolSupplier(SchoolSupplierDto schoolSupplierDto) {
		// TODO Auto-generated method stub
		SchoolSupplier schoolSupplier = new SchoolSupplier();
		BeanUtils.copyProperties(schoolSupplierDto, schoolSupplier);
		schoolSupplierDao.updateSchoolSupplier(schoolSupplier);
	}
	
	

}

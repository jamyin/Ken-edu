package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.education.handle.dao.ProLicenseDao;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.service.IProLicenseService;
import com.ssic.education.utils.util.BeanUtils;
@Service
public class ProLicenseServiceImpl implements IProLicenseService {

	@Autowired
	private ProLicenseDao dao;
	public void updateImage(ProLicense license) {
		// TODO Auto-generated method stub
		dao.updateImage(license);
	}
	public List<ProLicense> lookImage(ProLicense license) {
		// TODO Auto-generated method stub
		return dao.lookImage(license);
	}
	public int alterImage(ProLicense license) {
		// TODO Auto-generated method stub
		return dao.alterImage(license);
	}
	

	public void saveProLicense(ProLicenseDto proLicenseDto) {
		ProLicense proLicense = BeanUtils.createBeanByTarget(proLicenseDto, ProLicense.class);
		dao.insertSelective(proLicense);
	}
	public int saveLicense(ProLicense license) {
		return dao.insertSelective(license);
	}

}

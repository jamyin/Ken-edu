package com.ssic.education.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProLicenseDao;
import com.ssic.education.common.dto.ProLicenseDto;
import com.ssic.education.common.pojo.ProLicense;
import com.ssic.education.provider.service.IProLicenseService;
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
	public void alterImage(ProLicense license) {
		// TODO Auto-generated method stub
		dao.alterImage(license);
	}
	

	public void saveProLicense(ProLicenseDto proLicenseDto) {
		ProLicense proLicense = BeanUtils.createBeanByTarget(proLicenseDto, ProLicense.class);
		dao.insertSelective(proLicense);
	}

}

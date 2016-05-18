package com.ssic.education.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.ProLicenseDao;
import com.ssic.education.common.pojo.ProLicense;
import com.ssic.education.provider.service.IProLicenseService;
@Service
public class ProLicenseServiceImpl implements IProLicenseService {

	@Autowired
	private ProLicenseDao dao;
	@Override
	public void updateImage(ProLicense license) {
		// TODO Auto-generated method stub
		dao.updateImage(license);
	}
	@Override
	public List<ProLicense> lookImage(ProLicense license) {
		// TODO Auto-generated method stub
		return dao.lookImage(license);
	}

}

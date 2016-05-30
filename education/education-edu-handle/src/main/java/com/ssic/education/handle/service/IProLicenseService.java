package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.education.handle.pojo.ProLicense;

public interface IProLicenseService {

	void updateImage(ProLicense license);

	List<ProLicense> lookImage(ProLicense license);

	int alterImage(ProLicense license);

	public void saveProLicense(ProLicenseDto proLicenseDto);

	int saveLicense(ProLicense license);

	List<ProLicenseDto> searchProLicenseList(ProLicenseDto proLicenseDto);

	List<ProLicense> selectByRelationId(String id);
	
	
}

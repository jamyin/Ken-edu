package com.ssic.education.provider.service;

import java.util.List;

import com.ssic.education.common.dto.ProLicenseDto;
import com.ssic.education.common.pojo.ProLicense;

public interface IProLicenseService {

	void updateImage(ProLicense license);

	List<ProLicense> lookImage(ProLicense license);

	int alterImage(ProLicense license);

	public void saveProLicense(ProLicenseDto proLicenseDto);

	int saveLicense(ProLicense license);
}

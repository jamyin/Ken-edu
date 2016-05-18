package com.ssic.education.provider.service;

import java.util.List;

import com.ssic.education.common.pojo.ProLicense;

public interface IProLicenseService {

	void updateImage(ProLicense license);

	List<ProLicense> lookImage(ProLicense license);

}

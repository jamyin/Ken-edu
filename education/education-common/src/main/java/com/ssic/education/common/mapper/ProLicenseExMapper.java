package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.pojo.ProLicense;

public interface ProLicenseExMapper {

	List<ProLicense> lookImage(@Param("license")ProLicense license);

	int alterImage(@Param("proLicense") ProLicense license);

}

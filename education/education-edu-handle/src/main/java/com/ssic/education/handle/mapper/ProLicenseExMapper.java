package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.handle.pojo.ProLicense;

public interface ProLicenseExMapper {

	List<ProLicense> lookImage(@Param("license")ProLicense license);

	int alterImage(@Param("proLicense") ProLicense license);

	List<ProLicense> selectByRelationId(String id);

}

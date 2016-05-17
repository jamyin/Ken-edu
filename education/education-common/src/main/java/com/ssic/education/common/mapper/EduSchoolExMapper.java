package com.ssic.education.common.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProPackagesDto;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.pojo.EduSchool;
import com.ssic.util.model.PageQuery;


public interface EduSchoolExMapper {

	List<EduSchool> findSchoolDetialList(@Param("id") String id,@Param("query")  PageQuery query);

	int findSchoolDetialListAccount(@Param("id") String id);

	List<ProSupplierDto> getSupplierBySchoolId(@Param("schoolId") String schoolId);
	
	List<ProPackagesDto> getPackagesById(@Param("customerId") String customerId,@Param("supplierId") String supplierId,@Param("startDate") Date startDate,@Param("endDate") Date endDate);
}

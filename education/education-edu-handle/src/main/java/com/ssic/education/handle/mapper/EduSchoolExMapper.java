package com.ssic.education.handle.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.handle.pojo.EduSchool;
import com.ssic.education.utils.model.PageQuery;



public interface EduSchoolExMapper {

	List<EduSchool> findSchoolDetialList(@Param("id") String id, @Param("eduSchoolDto") EduSchoolDto eduSchoolDto, @Param("query")  PageQuery query);

	int findSchoolDetialListAccount(@Param("id") String id, @Param("eduSchoolDto") EduSchoolDto eduSchoolDto);

	List<ProSupplierDto> getSupplierBySchoolId(@Param("schoolId") String schoolId);
	
	List<ProPackagesDto> getPackagesById(@Param("customerId") String customerId,@Param("supplierId") String supplierId,@Param("startDate") Date startDate,@Param("endDate") Date endDate);
}

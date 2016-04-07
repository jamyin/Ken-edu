package com.ssic.education.common.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ssic.education.common.dto.PageHelperDto;
import com.ssic.education.common.dto.SchoolSupplierDto;
import com.ssic.education.common.dto.SchoolSupplierRel;

public interface SchoolSupplierExMapper {

	List<SchoolSupplierDto> findExByPage(@Param("schoolSupplier")SchoolSupplierDto schoolSupplier,@Param("phdto")PageHelperDto phdto);
	
	Integer findExCountByPage(@Param("schoolSupplier")SchoolSupplierDto schoolSupplier,@Param("phdto")PageHelperDto phdto);
	
	void deleteSchoolSupplierRel(@Param("supplierId") String supplierId);
	
	List<SchoolSupplierRel> findSchoolSupplierRel(@Param("lastUpdateTime")Date lastUpdateTime);
	
}

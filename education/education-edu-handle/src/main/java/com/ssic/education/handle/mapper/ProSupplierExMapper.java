package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.utils.model.PageQuery;

public interface ProSupplierExMapper {

	String findSupplierIdByName(@Param("supplierName")String supplierName);

	List<SupplierDto> findProSupplier(@Param("supplierDto")SupplierDto supplierDto,@Param("ph")PageHelper ph);

	ProSupplierDto findSupplierDetail(String id);

	SupplierDto findProSupplierById(String id);

	int updateByPrimaryKeySelective(SupplierDto record);
	
	int insert(SupplierDto record);

	List<SupplierDto> lookRelatingWares(@Param("dto") ProSupplierDto dto);

	List<SupplierDto> findSupplierCodeByReceiverId(@Param("supplierId")String supplierId);

	String findSupplierIdBySourceId(@Param("ledgerDto") LedgerDto ledgerDto);

	List<ProSupplierDto> searchSupplierListBySupplierId(@Param("supplierId") String supplierId,@Param("suppliName") String suppliName,@Param("supplierType") Integer supplierType,@Param("limit") Integer limit);
	
	List<ProSupplierDto> searchSchWareSuppListBySuppSchoolId(@Param("supplierId") String supplierId,@Param("schoolId")String schoolId,@Param("suppliName") String suppliName,@Param("supplierType") Integer supplierType,@Param("limit") Integer limit);
	
	List<ProSupplierDto> findSupplierListByCommittee(@Param("proSupplierDto") ProSupplierDto proSupplierDto,@Param("query") PageQuery page);
	
	long countSupplierListByCommittee(@Param("proSupplierDto") ProSupplierDto proSupplierDto);
	
	List<ProSupplierDto> findSupplierListBySchoolId(@Param("proSupplierDto") ProSupplierDto proSupplierDto,@Param("query") PageQuery page);
	
	long countSupplierListBySchoolId(@Param("proSupplierDto") ProSupplierDto proSupplierDto);
	
	List<ProSupplierDto> findSupplierListByIds(@Param("proSupplierDto") ProSupplierDto proSupplierDto,@Param("query") PageQuery page);
	
	long countSupplierListByIds(@Param("proSupplierDto") ProSupplierDto proSupplierDto);
}

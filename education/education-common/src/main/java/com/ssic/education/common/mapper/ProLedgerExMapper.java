package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.provider.dto.LedgerDto;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.utils.model.PageQuery;

public interface ProLedgerExMapper {

	public List<ProSupplierDto> selectSupplierByReceiverId(
			@Param("proSupplierDto") ProSupplierDto proSupplierDto,
			@Param("page") PageQuery page);

	long countSupplier(@Param("proSupplierDto") ProSupplierDto proSupplierDto);

	Long countAllLedger(@Param("ledgerDto") LedgerDto ld);

	List<LedgerDto> findAllLedger(@Param("ledgerDto") LedgerDto ld,
			@Param("ph") PageHelper ph);

	int insertLedger(@Param("ledgerList") List<LedgerDto> ledgerList);

	String findSchoolIdByReceiverId(@Param("ledgerDto") LedgerDto ld);

	String findWaresIdBySupplierId(@Param("ledgerDto") LedgerDto ledgerDto);

	String findSupplierIdBySourceId(@Param("ledgerDto") LedgerDto ledgerDto);

	public List<LedgerDto> findLedgerByWareBatchNo(
			@Param("sourceId") String sourceId,
			@Param("wareBatchNo") String wareBatchNo);

	public String findWareBatchNoById(String id);

	public int updateLedger(@Param("ledgerDto")LedgerDto ledger);

	public int deleteLedger(@Param("sourceId")String sourceId, @Param("wareBatchNo")String wareBatchNo);

}

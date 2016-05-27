package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.utils.PageHelper;
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

	public List<LedgerDto> findLedgerByMasterId(
			@Param("sourceId") String sourceId,
			@Param("masterId") String masterId);

	public String findWareBatchNoById(String id);

	public int updateLedger(@Param("ledgerDto")LedgerDto ledger);

	public int deleteLedger(@Param("sourceId")String sourceId, @Param("masterId")String masterId);

}

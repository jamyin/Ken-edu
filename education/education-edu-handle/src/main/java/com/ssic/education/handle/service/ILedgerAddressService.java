package com.ssic.education.handle.service;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.LedgerAddressDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;

public interface ILedgerAddressService {

	DataGrid findAllLedgerAddress(@Param("ledgerAddress")LedgerAddressDto lad, PageHelper ph);

}

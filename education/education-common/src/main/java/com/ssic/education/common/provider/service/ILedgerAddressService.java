package com.ssic.education.common.provider.service;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.provider.dto.LedgerAddressDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;

public interface ILedgerAddressService {

	DataGrid findAllLedgerAddress(@Param("ledgerAddress")LedgerAddressDto lad, PageHelper ph);

}

package com.ssic.education.common.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.LedgerAddressDao;
import com.ssic.education.common.provider.dto.LedgerAddressDto;
import com.ssic.education.common.provider.service.ILedgerAddressService;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;

@Service
public class LedgerAddressService implements ILedgerAddressService {

	@Autowired
	private LedgerAddressDao dao;

	@Override
	public DataGrid findAllLedgerAddress(LedgerAddressDto lad, PageHelper ph) {
		return dao.findAllLedgerAddress(lad,ph);
	}

	
	
}

package com.ssic.education.handle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.LedgerAddressDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.dao.LedgerAddressDao;
import com.ssic.education.handle.service.ILedgerAddressService;

@Service
public class LedgerAddressService implements ILedgerAddressService {

	@Autowired
	private LedgerAddressDao dao;

	@Override
	public DataGrid findAllLedgerAddress(LedgerAddressDto lad, PageHelper ph) {
		return dao.findAllLedgerAddress(lad,ph);
	}

	
	
}

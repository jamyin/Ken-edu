package com.ssic.education.common.provider.service;

import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;


public interface ISupplierService {

	DataGrid findProSupplier(SupplierDto supplierDto,PageHelper ph);

	SupplierDto findProSupplierById(String id);

	void updataProSupplier(SupplierDto ps);

	int deleteSupplier(String id);

	int saveSupplier(SupplierDto ps);
}

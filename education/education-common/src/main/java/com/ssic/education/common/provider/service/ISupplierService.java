package com.ssic.education.common.provider.service;

import java.util.List;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;


public interface ISupplierService {

	DataGrid findProSupplier(SupplierDto supplierDto,PageHelper ph);

	SupplierDto findProSupplierById(String id);

	void updataProSupplier(SupplierDto ps);

	int deleteSupplier(String id);

	int saveSupplier(SupplierDto ps);

	List<SupplierDto> lookRelatingWares(ProSupplierDto dto);
}

package com.ssic.education.common.provider.service;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.provider.service.dto.SupplierDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;


public interface ISupplierService {

	DataGrid findProSupplier(SupplierDto supplierDto,PageHelper ph);

	ProSupplierDto findProSupplierById(String id);

	void updataProSupplier(ProSupplier ps);

	int deleteSupplier(String id);

	int saveSupplier(ProSupplier ps);
}

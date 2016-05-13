package com.ssic.education.common.provider.service;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

import java.util.List;


public interface ISupplierService {

	List<ProSupplierDto> findAllProSupplier();

	ProSupplierDto findProSupplierById(String id);

	void updataProSupplier(ProSupplier ps);

	int deleteSupplier(String id);

	int saveSupplier(ProSupplier ps);
}

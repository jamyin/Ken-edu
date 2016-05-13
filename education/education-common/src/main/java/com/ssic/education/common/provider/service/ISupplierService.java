package com.ssic.education.common.provider.service;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

import java.util.List;


public interface ISupplierService {

	List<ProSupplierDto> findAllProSupplier();

	ProSupplierDto findProSupplierById(String id);

	void updataProSupplier(ProSupplierDto psd);
}

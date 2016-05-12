package com.ssic.education.app.service;

import org.springframework.stereotype.Service;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.util.model.PageQuery;
import com.ssic.util.model.PageResult;

/**
 * 供应商接口
* @ClassName: ISupplierService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 下午1:54:31
*
 */
@Service
public interface ISupplierService {

	//查询所有供应商-带分页
	PageResult<ProSupplierDto> findSupplierList(ProSupplierDto proSupplierDto, PageQuery query);

}


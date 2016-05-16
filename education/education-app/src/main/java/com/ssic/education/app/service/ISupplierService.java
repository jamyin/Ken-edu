package com.ssic.education.app.service;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

/**
 * 供应商接口
* @ClassName: ISupplierService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 下午1:54:31
*
 */
public interface ISupplierService {

	//查询所有供应商-带分页
	PageResult<ProSupplierDto> findSupplierList(ProSupplierDto proSupplierDto, PageQuery query);

	//根据Id查询供应商详细信息
	ProSupplierDto findSupplierDetail(String id);

}


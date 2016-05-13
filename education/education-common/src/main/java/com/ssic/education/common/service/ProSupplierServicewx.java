package com.ssic.education.common.service;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

import java.util.List;


public interface ProSupplierServicewx {

	/**
	 * <p>Description: 根据参数查询供应商 </p>
	 * <p>Company: 上海天坊信息科技有限公司</p>
	 * @param params 查询参数
	 * @return List<ProSupplierDto>
	 * @author wangxiang
	 * @date 2016/5/13 9:30
	 * @version 1.0
	 */
	List<ProSupplierDto> querySupplierByParams(ProSupplierDto params);

	/**
	 * <p>Description: 根据参数分页查询供应商 </p>
	 * <p>Company: 上海天坊信息科技有限公司</p>
	 * @param params 查询参数
	 * @param query 分页参数
	 * @return PageResult<ProSupplierDto>
	 * @author wangxiang
	 * @date 2016/5/13 9:32
	 * @version 1.0
	 */
	PageResult<ProSupplierDto> querySupplierByParams(ProSupplierDto params, PageQuery query);
}

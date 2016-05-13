package com.ssic.education.common.government.service;

import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

import java.util.List;

public interface ProWaresService {
	
	ProWaresDto findById(String id);

	/**
	 * <p>Description: 根据参数查询商品 </p>
	 * <p>Company: 上海天坊信息科技有限公司</p>
	 * @param
	 * @return
	 * @author wangxiang
	 * @date 2016/5/13 14:00
	 * @version 1.0
	 */
	List<ProWaresDto> queryWaresByParams(ProWaresDto params);

	/**
	 * <p>Description: TODO </p>
	 * <p>Company: 上海天坊信息科技有限公司</p>
	 * @param
	 * @return
	 * @author wangxiang
	 * @date 2016/5/13 14:01
	 * @version 1.0
	 */
	PageResult<ProWaresDto> queryWaresByParams(ProWaresDto params, PageQuery query);
}

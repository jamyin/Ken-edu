package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

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

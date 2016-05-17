package com.ssic.education.app.service;

import java.util.List;

import com.ssic.education.app.dto.WaresInfoDto;
import com.ssic.education.app.dto.WaresRelatedDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.util.model.Response;

/**		
 * <p>Title: IWaresInfoService </p>
 * <p>Description: 商品信息业务逻辑接口类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月16日 上午11:21:41	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月16日 上午11:21:41</p>
 * <p>修改备注：</p>
 */
public interface IWaresInfoService {
	//根据供应商ID查询商品列表
	List<WaresInfoDto> getWaresBySupplierId(String SupplierId);

	//根据供应商ID查询商品列表 带分页
	Response<List<WaresInfoDto>> getWaresBySupplierId(String SupplierId, PageQuery query);

	//根据商品的ID查询商品信息
	WaresRelatedDto findWarseById(String id);

}

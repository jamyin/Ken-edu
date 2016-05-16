package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.dao.WaresInfoDao;
import com.ssic.education.app.dto.WaresInfoDto;
import com.ssic.education.app.service.IWaresInfoService;

import com.ssic.education.utils.model.PageQuery;
import com.ssic.util.model.Response;

/**		
 * <p>Title: WaresInfoServiceImpl </p>
 * <p>Description:商品信息业务逻辑接口类 实现类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月16日 上午11:47:17	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月16日 上午11:47:17</p>
 * <p>修改备注：</p>
 */
@Service
public class WaresInfoServiceImpl implements IWaresInfoService {

	@Autowired
	private WaresInfoDao waresInfoDao;

	/**
	 * 根据供应商ID查询商品列表
	 * (non-Javadoc)   
	 * @see com.ssic.education.app.service.IWaresInfoService#getWaresBySupplierId(java.lang.String)
	 */
	@Override
	public List<WaresInfoDto> getWaresBySupplierId(String supplierId) {
		return waresInfoDao.findWarseBySupplier(supplierId);
	}

	/** 
	 * 根据供应商ID查询商品列表 带分页
	* (non-Javadoc)   
	* @see com.ssic.education.app.service.IWaresInfoService#getWaresBySupplierId(java.lang.String, com.ssic.education.utils.model.PageQuery)   
	*/
	@Override
	public Response<List<WaresInfoDto>> getWaresBySupplierId(String supplierId, PageQuery query) {
		// TODO 添加方法注释
		return null;
	}

}

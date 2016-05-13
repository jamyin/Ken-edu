package com.ssic.education.common.service;

import java.util.List;

import com.ssic.education.common.dto.ProWaresDto;

/**		
 * <p>Title: IProWaresService </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月12日 下午4:53:29	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月12日 下午4:53:29</p>
 * <p>修改备注：</p>
 */
public interface IProWaresService {
	public List<ProWaresDto> findWarseBySupplier(String Supplier);
}

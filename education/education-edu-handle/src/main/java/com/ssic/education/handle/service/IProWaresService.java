package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.dto.ProSchoolWareDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

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
	
	public PageResult<ProWaresDto> findWarsePageByParam(ProSchoolWareDto proSchoolWareDto,PageQuery query);
}

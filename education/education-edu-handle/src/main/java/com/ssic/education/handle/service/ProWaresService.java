package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.dto.ProSchoolWareDto;
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
	/**
	 * 
		 * 此方法描述的是：根据学校查询 对应的采购品信息 
		 * @author: cwftalus@163.com
		 * @version: 2016年5月29日 上午11:17:12
		 * @param SELECT * FROM `t_pro_wares` ware WHERE   EXISTS  (SELECT * FROM `t_pro_school_ware` sc_ware WHERE sc_ware.`school_id` = '000d804f-ffdc-432a-b9b7-85307a611423'  AND ware.`id` = sc_ware.`ware_id`)
	 */
	List<ProWaresDto> searchProWares(String schoolId,String waresName);
	
	public PageResult<ProWaresDto> findWarsePageByParam(ProSchoolWareDto proSchoolWareDto,PageQuery query);
}

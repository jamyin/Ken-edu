package com.ssic.education.app.service;

import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.app.dto.AppCanTeenDto;
import com.ssic.education.app.dto.MaterialSupplierDto;
import com.ssic.education.app.dto.SupplierLicDto;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

/**		
 * <p>Title: IProSupplierService </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月12日 上午10:57:16	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月12日 上午10:57:16</p>
 * <p>修改备注：</p>
 */
public interface IAppSupplierService {
	//查询所有供应商-带分页
		PageResult<ProSupplierDto> findSupplierList(ProSupplierDto proSupplierDto, PageQuery query);

		//根据Id查询供应商详细信息
		ProSupplierDto findSupplierDetail(String id);

		/**     
		 * findSupplierInfo：根据Id查询供应商详细信息
		 * @param supplier_id
		 * @author SeanYoung
		 * @date 2016年5月23日 下午4:21:39	 
		 */
		SupplierLicDto findSupplierInfo(String supplier_id);

		/**
		 * 
		 * @param supplierId
		 * @param schoolId
		 * @author SeanYoung
		 * @return
		 */
		SupplierLicDto findSupplierInfo(String supplierId, String schoolId);
		/**
		 * 
		 * @param id
		 * @return
		 */
		AppCanTeenDto findCanteenByid(String id);

		/**     
		 * findListByIds：查询所有供应商-带分页
		 * @param supplier_id
		 * @param proSupplier
		 * @param query
		 * @author SeanYoung
		 * @date 2016年5月30日 下午3:04:51	 
		 */
		PageResult<MaterialSupplierDto> findListByIds(String id, ProSupplier proSupplier, PageQuery query);
		/**
		 * 
		 * @param id
		 * @param schoolId
		 * @param proSupplier
		 * @param query
		 * @return
		 */
		PageResult<MaterialSupplierDto> findListByIds(String id, String schoolId, ProSupplier proSupplier, PageQuery query);

}


package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.handle.pojo.ProSupplierReceiver;


public interface ISupplierService {

	DataGrid findProSupplier(SupplierDto supplierDto,PageHelper ph);

	SupplierDto findProSupplierById(String id);

	void updataProSupplier(SupplierDto ps);

	int deleteSupplier(String id);

	int saveSupplier(SupplierDto ps);

	List<SupplierDto> lookRelatingWares(ProSupplierDto dto);
	
	/**
	 * 
		 * 此方法描述的是：修改或保存方法 返回供应商Id
		 * @author: cwftalus@163.com
		 * @version: 2016年5月20日 下午1:57:07
	 */
	String saveOrUpdateSupplier(SupplierDto ps);
	
	/**
	 * 根据供应商编码查询当前企业<code>supplierId</code>的供应商。由于编码在企业内部的唯一性，只可能有一个结果。
	 * 
	 * @param code
	 * @param supplierId
	 * @return
	 * @author zhangjiwei
	 * @since 2016.5.21
	 */
	ProSupplier getSupplierByCode(String code, String supplierId);
	
	/**
	 * 根据供应商名称查询当前企业<code>supplierId</code>的供应商
	 * 
	 * @param name
	 * @param supplierId
	 * @return
	 * @author zhangjiwei
	 * @since 2016.5.21
	 */
	ProSupplier getSupplierByName(String name, String supplierId);

	void saveSupplierReceiver(ProSupplierReceiver proSupplierReceiver);

	List<SupplierDto> findSupplierCodeByReceiverId(String supplierId);
	/**
	 * 
		 * 此方法描述的是：根据Id查询对象
		 * @author: cwftalus@163.com
		 * @version: 2016年5月24日 下午1:39:55
	 */
	ProSupplierDto searchProSupplierById(String sourceId);

	String findSupplierIdBySourceId(LedgerDto ledger);
}

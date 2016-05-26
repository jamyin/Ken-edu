package com.ssic.education.app.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.MaterialSupplierDto;
import com.ssic.education.app.dto.SupplierLicDto;
import com.ssic.education.app.mapper.SupplierInfoExMapper;
import com.ssic.education.common.mapper.ProSupplierMapper;
import com.ssic.education.common.pojo.ProLedger;
import com.ssic.education.common.pojo.ProLedgerExample;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.pojo.ProSupplierExample;

/**		
 * <p>Title: SupplierInfoDao </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月23日 下午4:11:38	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月23日 下午4:11:38</p>
 * <p>修改备注：</p>
 */
@Repository
public class SupplierInfoDao {
	@Getter
	@Autowired
	private SupplierInfoExMapper mapper;

	@Getter
	@Autowired
	private ProSupplierMapper SupplierMapper;

	public SupplierLicDto getSupplierInfoById(String supplier_id) {
		return mapper.getSupplierInfoById(supplier_id);
	}

	public List<MaterialSupplierDto> getSupplierListById(String supplier_id) {
		return mapper.getSupplierListById(supplier_id);
	}

	public String getSupplierName(String supplierId) {
		ProSupplier proSupplier = SupplierMapper.selectByPrimaryKey(supplierId);
		if (proSupplier != null) {
			return proSupplier.getSupplierName();
		} else {
			return null;
		}
	}
}

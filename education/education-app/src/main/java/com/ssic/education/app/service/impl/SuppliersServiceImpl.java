package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.dao.SupplierInfoDao;
import com.ssic.education.app.dto.MaterialSupplierDto;
import com.ssic.education.app.dto.SupplierLicDto;
import com.ssic.education.app.service.ISupplierService;
import com.ssic.education.common.dao.SupplierDao;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

/**	
* @ClassName: SupplierServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 下午2:20:58
*
 */
@Service
public class SuppliersServiceImpl implements ISupplierService {

	@Autowired
	private SupplierDao supplierDao;

	@Autowired
	private SupplierInfoDao supplierInfoDao;

	@Override
	public PageResult<ProSupplierDto> findSupplierList(ProSupplierDto proSupplierDto, PageQuery query) {
		List<ProSupplier> list = supplierDao.findSupplierList(proSupplierDto, query);
		List<ProSupplierDto> supplierDtoList = BeanUtils.createBeanListByTarget(list, ProSupplierDto.class);
		int total = supplierDao.selectSupplierAccount(proSupplierDto);
		query.setTotal(total);
		return new PageResult<ProSupplierDto>(query, supplierDtoList);
	}

	@Override
	public ProSupplierDto findSupplierDetail(String id) {
		return supplierDao.findSupplierDetail(id);
	}

	@Override
	public SupplierLicDto findSupplierInfo(String supplier_id) {
		SupplierLicDto sld = new SupplierLicDto();
		sld = supplierInfoDao.getSupplierInfoById(supplier_id);
		if (sld != null) {
			List<MaterialSupplierDto> msdList = supplierInfoDao.getSupplierListById(supplier_id);
			sld.setMaterialSupplierList(msdList);
		}
		return sld;
	}
}

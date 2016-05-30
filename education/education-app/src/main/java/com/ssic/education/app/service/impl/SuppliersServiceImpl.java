package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.app.dao.SupplierInfoDao;
import com.ssic.education.app.dto.MaterialSupplierDto;
import com.ssic.education.app.dto.SupplierLicDto;
import com.ssic.education.app.service.ISupplierService;
import com.ssic.education.handle.dao.SupplierDao;
import com.ssic.education.handle.pojo.ProSupplier;
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
		return supplierInfoDao.getSupplierById(supplier_id);
	}

	@Override
	public PageResult<MaterialSupplierDto> findListByIds(String supplier_id, ProSupplier proSupplier, PageQuery query) {
		List<String> list = this.supplierInfoDao.getSupplierReceiver(supplier_id);
		if (null != list && !list.isEmpty()) {
			List<MaterialSupplierDto> materialSupplierDto = this.supplierInfoDao.getSupplierByIds(list, proSupplier, query);
			int total = supplierInfoDao.getSupplierByIdsCount(list, proSupplier);
			query.setTotal(total);
			return new PageResult<MaterialSupplierDto>(query, materialSupplierDto);
		}
		return null;

	}
}

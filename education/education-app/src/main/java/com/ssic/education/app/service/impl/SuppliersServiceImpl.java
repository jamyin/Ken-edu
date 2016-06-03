package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.app.dao.SupplierInfoDao;
import com.ssic.education.app.dto.AppLicenseDto;
import com.ssic.education.app.dto.MaterialSupplierDto;
import com.ssic.education.app.dto.SupplierLicDto;
import com.ssic.education.app.service.ISupplierService;
import com.ssic.education.handle.dao.SupplierDao;
import com.ssic.education.handle.pojo.ProLicense;
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

	/**
	 * 查询供应商资质
	 * (non-Javadoc)   
	 * @see com.ssic.education.app.service.ISupplierService#findSupplierInfo(java.lang.String)
	 */
	@Override
	public SupplierLicDto findSupplierInfo(String supplier_id) {
		SupplierLicDto supplierLicDto = new SupplierLicDto();
		supplierLicDto = supplierInfoDao.getSupplierById(supplier_id);
		PageQuery query = new PageQuery();
		query.setPageSize(3);
		if (supplierLicDto != null) {
			PageResult<MaterialSupplierDto> findSupplierList = this.findListByIds(supplierLicDto.getId(), null, query);
			List<ProLicense> list = supplierInfoDao.getLic(supplierLicDto.getId());
			if (null != list && !list.isEmpty()) {
				for (ProLicense proLicense : list) {
					if (null != proLicense.getLicPic()) {
						String host = "http://192.168.1.242";
						String pic = host + proLicense.getLicPic();
						proLicense.setLicPic(pic);
					}
				}
				List<AppLicenseDto> applic = BeanUtils.createBeanListByTarget(list, AppLicenseDto.class);
				supplierLicDto.setAppLicense(applic);
			}
			if (findSupplierList != null) {
				supplierLicDto.setMaterialSupplierList(findSupplierList);
			}
			return supplierLicDto;
		}
		return null;
	}

	@Override
	public PageResult<MaterialSupplierDto> findListByIds(String id, ProSupplier proSupplier, PageQuery query) {
		List<String> list = this.supplierInfoDao.getSupplierReceiver(id);
		if (null != list && !list.isEmpty()) {
			List<MaterialSupplierDto> materialSupplierDto = this.supplierInfoDao.getSupplierByIds(list, proSupplier, query);
			int total = supplierInfoDao.getSupplierByIdsCount(list, proSupplier);
			query.setTotal(total);
			return new PageResult<MaterialSupplierDto>(query, materialSupplierDto);
		} else {
			return null;
		}

	}
}

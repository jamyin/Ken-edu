package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssic.education.app.service.ISupplierService;
import com.ssic.education.common.dao.SupplierDao;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.util.BeanUtils;


/**	
* @ClassName: SupplierServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 下午2:20:58
*
 */
public class SupplierServiceImpl implements ISupplierService{

    @Autowired
    private SupplierDao supplierDao;

	@Override
	public PageResult<ProSupplierDto> findSupplierList(ProSupplierDto proSupplierDto,
			PageQuery query) {
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

}


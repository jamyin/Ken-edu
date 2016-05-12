package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.app.service.ISupplierService;
import com.ssic.education.common.dao.SupplierDao;
import com.ssic.util.BeanUtils;
import com.ssic.util.model.PageQuery;
import com.ssic.util.model.PageResult;

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
		List<ProSupplierDto> list = supplierDao.findSupplierList(proSupplierDto, query);
		List<ProSupplierDto> supplierDtoList = BeanUtils.createBeanListByTarget(list, ProSupplierDto.class);
		int total = supplierDao.selectSupplierAccount(proSupplierDto);
		query.setTotal(total);
		return new PageResult<ProSupplierDto>(query, supplierDtoList);
	}

}


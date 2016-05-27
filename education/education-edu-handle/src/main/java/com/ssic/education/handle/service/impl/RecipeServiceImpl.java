package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.education.handle.dao.ProDishesDao;
import com.ssic.education.handle.dao.ProPackagesDao;
import com.ssic.education.handle.service.IRecipeService;
import com.ssic.education.utils.model.PageQuery;

/**		
 * <p>Title: RecipeServiceImpl </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月17日 下午4:29:42	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月17日 下午4:29:42</p>
 * <p>修改备注：</p>
 */
@Service
public class RecipeServiceImpl implements IRecipeService {
	@Autowired
	private ProPackagesDao packagesDao;
	@Autowired
	private ProDishesDao dishesDao;

	public List<ProPackagesDto> findPackageBySchool() {
		return null;
	}

	public List<ProPackagesDto> findAllPackage(ProPackagesDto dto, PageQuery page) {
		//return packagesDao.getProPackages(dto)
		return null;
	}
}

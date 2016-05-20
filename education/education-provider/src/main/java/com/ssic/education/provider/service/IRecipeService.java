package com.ssic.education.provider.service;

import java.util.List;

import com.ssic.education.provider.dto.ProPackagesDto;
import com.ssic.education.utils.model.PageQuery;

/**		
 * <p>Title: IRecipeService </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月17日 下午4:28:22	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月17日 下午4:28:22</p>
 * <p>修改备注：</p>
 */
public interface IRecipeService {
	public List<ProPackagesDto> findPackageBySchool();

	public List<ProPackagesDto> findAllPackage(ProPackagesDto dto, PageQuery page);
}

package com.ssic.education.app.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.mapper.LicExMapper;
import com.ssic.education.handle.pojo.ProLicense;

/**		
 * <p>Title: LicDao </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月24日 下午3:32:43	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月24日 下午3:32:43</p>
 * <p>修改备注：</p>
 */
@Repository
public class AppLicenseDao {
	@Getter
	@Autowired
	private LicExMapper licExMapper;

	public String getLicbyType(String relationId, int licType) {
		ProLicense lic = new ProLicense();
		lic.setRelationId(relationId);
		lic.setLicType(licType);
		return licExMapper.getLicbyType(lic);
	}
}

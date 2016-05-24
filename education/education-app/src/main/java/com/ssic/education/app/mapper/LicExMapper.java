package com.ssic.education.app.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.pojo.ProLicense;

/**		
 * <p>Title: LicExMapper </p>
 * <p>Description: 证书mapper接口</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月24日 下午3:31:29	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月24日 下午3:31:29</p>
 * <p>修改备注：</p>
 */
public interface LicExMapper {
	String getLicbyType(@Param("l") ProLicense l);
}

/**
 * 
 */
package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssic.education.app.dto.District;
import com.ssic.education.app.service.IAreaInfoService;
import com.ssic.util.model.Response;

/**		
 * <p>Title: AreaInfoServiceImpl </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年3月15日 下午4:26:28	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年3月15日 下午4:26:28</p>
 * <p>修改备注：</p>
 */
@Service
public class AreaInfoServiceImpl implements IAreaInfoService {

     /** 
     * (non-Javadoc)   
     * @see com.ssic.education.app.service.IAreaInfoService#getSubDistricetByParentCode(java.lang.String)   
     */
    @Override
    public Response<List<District>> getSubDistricetByParentCode(String parentDistrictCode) {
	
	return null;
    }

}


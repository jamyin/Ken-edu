/**
 * 
 */
package com.ssic.education.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssic.education.app.dto.District;
import com.ssic.util.model.Response;

/**		
 * <p>Title: IAreaInfoService </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年3月15日 下午4:20:42	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年3月15日 下午4:20:42</p>
 * <p>修改备注：</p>
 */
@Service
public interface IAreaInfoService {

    
    /**     
     * getSubDistricetByParentCode：根据父地区编码获取其子地区编码
     * @param parentDistrictCode
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年3月15日 下午4:37:59	 
     */
    Response<List<District>> getSubDistricetByParentCode(String parentDistrictCode);


}


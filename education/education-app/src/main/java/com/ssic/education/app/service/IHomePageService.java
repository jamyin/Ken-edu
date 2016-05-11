/**
 * 
 */
package com.ssic.education.app.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssic.education.app.dto.District;
import com.ssic.education.app.dto.School;
import com.ssic.test.common.dto.AddressStatistic;
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
public interface IHomePageService {

    
    /**     
     * getSubDistricetByParentCode：根据父地区编码获取其子地区编码
     * @param parentDistrictCode
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年3月15日 下午4:37:59	 
     */
    Response<List<District>> getSubDistricetByParentCode(String parentDistrictCode);

    
    /**     
     * getSubDistricetSchoolStatistic：获取父地区编码下所有地区信息以及学校信息统计
     * @param parentDistrictCode
     * @param schoolLevel
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月1日 下午5:12:34	 
     */
    Response<List<AddressStatistic>> getSubDistricetSchoolStatistic(String parentDistrictCode, Integer schoolLevel);


    
    /**     
     * getSchoolLevel：获取所有学校列表信息
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月5日 下午3:45:11	 
     */
    Response<Map<Integer, String>> getSchoolLevel();


    
    /**     
     * getSchoolList：获取学校及其对应供应商信息
     * @param lastUpdateTime
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月7日 上午11:48:21	 
     */
    Response<List<School>> getSchoolList(Date lastUpdateTime);


}


/**
 * 
 */
package com.ssic.education.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.District;
import com.ssic.education.app.service.IAreaInfoService;
import com.ssic.util.model.Response;

/**		
 * <p>Title: AreaInfoController </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年3月15日 下午3:24:52	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年3月15日 下午3:24:52</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping(value = "/area")
public class AreaInfoController {
    
    @Autowired
    private IAreaInfoService areaInfoService;

    /**     
     * getDistrictList：根据地区编码获取其下一级地区信息
     * @param parentDistrictCode
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年3月15日 下午4:41:00	 
     */
    @RequestMapping("/search/{parentDistrictCode}/{schoolLevel}")
    @ResponseBody
    public Response<List<District>> getDistrictSchoolStatistic(@PathVariable("parentDistrictCode")String parentDistrictCode, @PathVariable("schoolLevel")Integer schoolLevel) {	
	
	return areaInfoService.getSubDistricetSchoolStatistic(parentDistrictCode, schoolLevel);
    }
    
}


/**
 * 
 */
package com.ssic.education.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.District;
import com.ssic.education.app.dto.School;
import com.ssic.education.app.service.IHomePageService;
import com.ssic.test.common.dto.AddressStatistic;
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
@RequestMapping(value = "/home-page")
public class HomePageController {
    
    @Autowired
    private IHomePageService homePageService;
    
    /**     
     * getDistrictSchoolStatistic：根据地区编码获取其下一级地区信息，地区对应的学校
     * @param parentDistrictCode
     * @param schoolLevel -1 全部  0 幼儿园，1 小学，2 初中，3 高中，4 大学 
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月5日 上午10:56:33	 
     */
    @RequestMapping("/statistic/{parentDistrictCode}/{schoolLevel}")
    @ResponseBody
    public Response<List<AddressStatistic>> getDistrictSchoolStatistic(@PathVariable("parentDistrictCode")String parentDistrictCode, @PathVariable("schoolLevel")Integer schoolLevel) {	
	
	return homePageService.getSubDistricetSchoolStatistic(parentDistrictCode, schoolLevel);
    }
    
    
    /**     
     * getDistrict：根据地区父节点获取其子节点的所有地区信息
     * @param parentDistrictCode
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月7日 下午7:15:11	 
     */
    @RequestMapping("/district/{parentDistrictCode}")
    @ResponseBody
    public Response<List<District>> getDistrict(@PathVariable("parentDistrictCode")String parentDistrictCode) {	
	
	return homePageService.getSubDistricetByParentCode(parentDistrictCode);
    }
    
    
    /**     
     * getSchoolLevel：获取所有学校等级信息
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月7日 下午7:15:15	 
     */
    @RequestMapping("/school-level")
    @ResponseBody
    public Response<Map<Integer, String>> getSchoolLevel() {	
	
	return homePageService.getSchoolLevel();
    }
   
    
    /**     
     * getSchoolList：获取学校信息列表
     * @param lastUpdateTime 最后修改时间，如果有最后修改时间就增量获取于最后修改时间之后有修改的记录。
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月7日 下午7:15:19	 
     */
    @RequestMapping("/school-list")
    @ResponseBody
    public Response<List<School>> getSchoolList(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date lastUpdateTime) {	
	
	return homePageService.getSchoolList(lastUpdateTime);
    }
  
}


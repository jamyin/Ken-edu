/**
 * 
 */
package com.ssic.education.app.service.test;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssic.education.app.dto.District;
import com.ssic.education.app.dto.School;
import com.ssic.education.app.service.IHomePageService;
import com.ssic.education.app.test.BaseTestCase;
import com.ssic.education.common.dto.AddressStatistic;
import com.ssic.util.model.Response;

/**		
 * <p>Title: AreaInfoServiceTest </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年3月15日 下午4:49:06	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年3月15日 下午4:49:06</p>
 * <p>修改备注：</p>
 */
public class AreaInfoServiceTest extends BaseTestCase {

    protected static final Logger logger = LoggerFactory.getLogger(AreaInfoServiceTest.class);
    
    @Autowired
    private IHomePageService homePageService;
    
    @Test
    public void getSubDistricetSchoolStatisticTest() {
	logger.info(" ----- test getSubDistricetSchoolStatisticTest ----- ");
	Response<List<AddressStatistic>> response = homePageService.getSubDistricetSchoolStatistic("310000", 1);
	Assert.assertNotNull(response);
	Assert.assertTrue(CollectionUtils.isNotEmpty(response.getData()));
	
	for(AddressStatistic statistic : response.getData()) {
	     logger.info(statistic.toString());
	}
    }
    
    @Test
    public void getDistrictTest() {
	logger.info(" ----- test getDistrictTest ----- ");
	Response<List<District>> response = homePageService.getSubDistricetByParentCode("310000");
	Assert.assertNotNull(response);
	Assert.assertTrue(CollectionUtils.isNotEmpty(response.getData()));
	
	for(District district : response.getData()) {
	     logger.info(district.toString());
	}
    }
    
    
    @Test
    public void getSchoolLevelTest() {
	logger.info(" ----- test getSchoolLevelTest ----- ");
	Response<Map<Integer, String>> response = homePageService.getSchoolLevel();
	Assert.assertNotNull(response);
	Assert.assertTrue(MapUtils.isNotEmpty(response.getData()));
	
	for(Integer level : response.getData().keySet()) {
	    logger.info("level : {}  name : {}", level, response.getData().get(level));
	}
    }
    
    @Test
    public void getSchoolList() {
	logger.info(" ----- test getSchoolList ----- ");
	Response<List<School>> response = homePageService.getSchoolList(null);
	Assert.assertNotNull(response);
	Assert.assertTrue(CollectionUtils.isNotEmpty(response.getData()));
	
	for(School school : response.getData()) {
	     logger.info(school.toString());
	}
    }
    
}


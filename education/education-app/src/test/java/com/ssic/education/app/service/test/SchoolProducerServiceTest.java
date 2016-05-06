/**
 * 
 */
package com.ssic.education.app.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssic.education.app.dto.SupplierInfo;
import com.ssic.education.app.service.ISchoolProducerService;
import com.ssic.education.app.test.BaseTestCase;
import com.ssic.util.model.Response;

/**		
 * <p>Title: SchoolProducerServiceTest </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月25日 上午10:35:59	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月25日 上午10:35:59</p>
 * <p>修改备注：</p>
 */
public class SchoolProducerServiceTest extends BaseTestCase {


    protected static final Logger logger = LoggerFactory.getLogger(SchoolProducerServiceTest.class);
    
    @Autowired
    private ISchoolProducerService schoolProducerService;

    @Test
    public void getSupplierInfoTest() {
	String supplierId = "562895c6-f29c-4733-8ca5-0db6394dcdef";
	Response<SupplierInfo> response = schoolProducerService.getSupplierInfo(supplierId);
	Assert.assertNotNull(response);
	logger.info(response.getData().toString());
	
    }
}


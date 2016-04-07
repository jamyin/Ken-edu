/**
 * 
 */
package com.ssic.education.app.dao.test;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.ssic.education.app.test.BaseTestCase;
import com.ssic.education.common.dao.SchoolSupplierDao;
import com.ssic.education.common.dto.SchoolSupplierRel;

/**		
 * <p>Title: SchoolSupplierDaoTest </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月7日 上午10:41:25	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月7日 上午10:41:25</p>
 * <p>修改备注：</p>
 */
public class SchoolSupplierDaoTest extends BaseTestCase {

    protected static final Log logger = LogFactory.getLog(AddressDaoTest.class);
    
    @Autowired
    private SchoolSupplierDao schoolSupplierDao;
    
    @Test
    public void findSchoolSupplierRelTest() {
	List<SchoolSupplierRel> schools = schoolSupplierDao.findSchoolSupplierRel(null);
	Assert.isTrue(CollectionUtils.isNotEmpty(schools));
	for(SchoolSupplierRel school : schools) {
	    logger.info(school);
	}
	
	schools = schoolSupplierDao.findSchoolSupplierRel(null);
	Assert.isTrue(CollectionUtils.isNotEmpty(schools));
	for(SchoolSupplierRel school : schools) {
	    logger.info(school);
	}
    }

}


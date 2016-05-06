/**
 * 
 */
package com.ssic.education.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.ssic.education.app.dto.SupplierInfo;
import com.ssic.education.app.service.ISchoolProducerService;
import com.ssic.education.common.dao.SchoolSupplierDao;
import com.ssic.education.common.pojo.SchoolSupplier;
import com.ssic.util.BeanUtils;
import com.ssic.util.model.Response;

/**		
 * <p>Title: SchoolProducerServiceImpl </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月20日 下午3:49:20	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月20日 下午3:49:20</p>
 * <p>修改备注：</p>
 */
public class SchoolProducerServiceImpl implements ISchoolProducerService {
    
    @Autowired
    private SchoolSupplierDao schoolSupplierDao;

    /** 
    * (non-Javadoc)   
    * @see com.ssic.education.app.service.ISchoolProducerService#getSupplierInfo(java.lang.String)   
    */
    @Override
    public Response<SupplierInfo> getSupplierInfo(String id) {
	Response<SupplierInfo> response = new Response<>();
	SchoolSupplier supplier =  schoolSupplierDao.selectByPrimaryKey(id);
	SupplierInfo supplierInfo = BeanUtils.createBeanByTarget(supplier, SupplierInfo.class);
	response.setData(supplierInfo);
	return response;
    }

}


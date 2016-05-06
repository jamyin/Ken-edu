/**
 * 
 */
package com.ssic.education.app.service;

import org.springframework.stereotype.Service;
import com.ssic.education.app.dto.SupplierInfo;
import com.ssic.util.model.Response;

/**		
 * <p>Title: ISchoolProducerService </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月20日 下午3:16:50	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月20日 下午3:16:50</p>
 * <p>修改备注：</p>
 */
@Service
public interface ISchoolProducerService {

    Response<SupplierInfo> getSupplierInfo(String id);
}


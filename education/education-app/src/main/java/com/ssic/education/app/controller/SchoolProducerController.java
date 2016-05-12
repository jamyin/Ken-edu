/**
 * 
 */
package com.ssic.education.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.ProWaresDto;
import com.ssic.education.app.dto.SupplierInfo;
import com.ssic.util.model.Response;

/**		
 * <p>Title: SchoolProducerController </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月19日 下午4:46:49	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月19日 下午4:46:49</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping(value = "/school-producer")
public class SchoolProducerController {
    
    
    /**     
     * getSupplierInfo：根据供应商ID获取明细信息
     * @param id
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月20日 下午3:10:19	 
     */
    @RequestMapping("/supplier/{id}")
    @ResponseBody
    public Response<SupplierInfo> getSupplierInfo(@PathVariable("id")String id) {
	return null;
    }

}


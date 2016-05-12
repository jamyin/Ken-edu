package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.app.service.ISupplierService;
import com.ssic.util.constants.DataStatus;
import com.ssic.util.model.PageQuery;
import com.ssic.util.model.PageResult;
import com.ssic.util.model.Response;

/**
* @ClassName: SupplierController
* @Description: 供应商controller
* @author Ken Yin
* @date 2016年5月12日 下午1:50:46
*
*/
@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {
	
	@Autowired
	private ISupplierService supplierService;
    
   /**
    * @Title: findSupplierList
    * @Description: 查询所有供应商-带分页
    * @author Ken Yin  
    * @date 2016年5月12日 上午11:27:34
    * @return Response<EduTaskDto>    返回类型
    */
    @RequestMapping("/findSupplierList")
    @ResponseBody
    public Response<PageResult<ProSupplierDto>>  findSupplierList(ProSupplierDto proSupplierDto, PageQuery query) {
    	Response<PageResult<ProSupplierDto>> result = new Response<PageResult<ProSupplierDto>>();
    	PageResult<ProSupplierDto> supplierList = supplierService.findSupplierList(proSupplierDto, query);
    	if(supplierList.getResults() != null && supplierList.getResults().size() >0 ){
    		result.setStatus(DataStatus.HTTP_SUCCESS);
    		result.setMessage("查询成功！");
    		result.setData(supplierList);
    		return result;
    	}else{
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("未查到相关记录！");
    		return result;
    	}
    }
}


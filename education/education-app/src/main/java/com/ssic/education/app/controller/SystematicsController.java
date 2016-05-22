package com.ssic.education.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.constants.ProductClass;
import com.ssic.education.utils.model.Response;

/**		
 * <p>Title: SystematicsController </p>
 * <p>Description: 系统分类接口</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月16日 上午9:43:24	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月16日 上午9:43:24</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping(value = "/dishessort")
public class SystematicsController {
	/**
	 * getDishesType：食品分类列表 原料分类列表
	 * @return
	 * @exception	
	 * @author Administrator
	 * @date 2016年5月16日 上午9:44:23
	 */
	@RequestMapping(value = "/typelist", method = RequestMethod.GET)
	@ResponseBody
	public Response<Map<Integer, String>> getDishesType() {
		Response<Map<Integer, String>> result = new Response<Map<Integer, String>>();
		result.setData(ProductClass.getAll());
		return result;
	}
}

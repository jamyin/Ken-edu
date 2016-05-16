package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.common.dto.ProWaresDto;
import com.ssic.util.model.Response;

/**		
 * <p>Title: ProWaresController </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月12日 上午10:46:34	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月12日 上午10:46:34</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping(value = "/wares")
public class ProWaresController {
	//@Autowired
	//private IProWaresService proWaresService;

	/**
	 * getWaresInfo：菜品信息：根据菜品id查菜品信息（需要批次信息和供应商信息）
	 * @return
	 * @exception	
	 * @author Administrator
	 * @date 2016年5月13日 上午11:55:28
	 */
	@RequestMapping("/dishesInfo/{id}")
	@ResponseBody
	public Response<ProWaresDto> getDishesInfo() {
		return null;
	}

	/**
	 * 
	 * getMaterialInfo：根据原料id查原料信息（需带出批次列表）
	 * @return
	 * @exception	
	 * @author Administrator
	 * @date 2016年5月13日 下午12:00:30
	 */
	@RequestMapping("/materialInfo/{id}")
	@ResponseBody
	public Response<ProWaresDto> getMaterialInfo() {
		return null;
	}
}

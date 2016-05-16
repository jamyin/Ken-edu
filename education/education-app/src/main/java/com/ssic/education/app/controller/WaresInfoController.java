package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.common.dto.ProWaresDto;
import com.ssic.util.model.Response;

/**		
 * <p>Title: WaresInfoController </p>
 * <p>Description: 菜品信息控制器</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月13日 下午3:20:05	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月13日 下午3:20:05</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping(value = "/waresInfo")
public class WaresInfoController {
	//@Autowired
	//private IProWaresService proWaresService;

	/**
	 * getWaresList： 食品列表：根据供应商id查食品列表 原料列表：根据供应商id查原料列表
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月13日 下午3:32:09
	 */
	public Response<?> getWaresList() {
		//TODO 定义接口待实现
		return null;
	}

	/**
	 * getWaresInfo：菜品信息：根据菜品id查菜品信息（需要批次信息和供应商信息）
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月13日 上午11:55:28
	 */
	public Response<?> getDishesInfo() {
		//TODO 定义接口待实现
		return null;
	}

	/**
	 * getMaterialInfo：根据原料id查原料信息（需带出批次列表）
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月13日 下午12:00:30
	 */
	public Response<?> getMaterialInfo() {
		//TODO 定义接口待实现
		return null;
	}
}

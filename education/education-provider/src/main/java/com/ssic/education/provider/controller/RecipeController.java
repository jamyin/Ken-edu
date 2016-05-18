package com.ssic.education.provider.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssic.util.model.Response;

/**		
 * <p>Title: PackageController </p>
 * <p>Description: 菜谱管理控制器类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月17日 下午2:24:53	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月17日 下午2:24:53</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping("/recipe")
public class RecipeController {

	/**
	 * list列表页面
	 * manager：一句话描述方法功能
	 * @param request
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月17日 下午5:22:27
	 */
	@RequestMapping("/list")
	public String manager(HttpServletRequest request) {
		return "recipe/list";
	}

	public Response<?> getPackegesList() {
		return null;
	}

}

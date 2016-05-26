package com.ssic.education.provider.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssic.education.handle.pojo.ProPackages;
import com.ssic.education.provider.util.RequestUtil;

/**
 * <p>Title: RecipeController </p>
 * <p>Description: 菜谱管理控制器类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月18日 下午1:41:24	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月18日 下午1:41:24</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping("/recipe")
public class RecipeController extends BaseController {

	//protected static final Log logger = LogFactory.getLog(RecipeController.class);

	/* 取得 ProPackages 实体 */
	protected ProPackages getFormObject(HttpServletRequest request) throws Exception {
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher((new String[] { "yyyy-MM-dd" })));
		String json = RequestUtil.getString(request, "json");
		JSONObject obj = JSONObject.fromObject(json);
		ProPackages packages = (ProPackages) JSONObject.toBean(obj, ProPackages.class);
		return packages;
	}
	
//	@Autowired
//	private IRecipeService recipeService;
//
//	/**
//	 * list：请求菜谱list界面
//	 * @return
//	 * @exception	
//	 * @author Administrator
//	 * @date 2016年5月18日 下午1:55:49
//	 */
//	@RequestMapping(value = "?")
//	public ModelAndView list(ProPackagesDto dto, PageQuery page) {
//		return null;
//	}
//
//	/**
//	 * 查询当前学校套餐列表
//	 * getPackegesList：一句话描述方法功能
//	 * @return
//	 * @exception	
//	 * @author SeanYoung
//	 * @date 2016年5月18日 上午10:17:19
//	 */
//	@RequestMapping(value = "?")
//	public Response<List<ProPackagesDto>> getApiList(ProPackagesDto dto, PageQuery page) {
//		return null;
//	}
//
//	/**
//	 * 查询当前学校套餐列表
//	 * getPackegesList：一句话描述方法功能
//	 * @return
//	 * @exception	
//	 * @author SeanYoung
//	 * @date 2016年5月18日 上午10:17:19
//	 */
//	@RequestMapping(value = "?")
//	public DataGrid getgridList(ProPackagesDto dto, PageQuery page) {
//		return null;
//	}
}

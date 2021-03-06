package com.ssic.education.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.WaresInfoDto;
import com.ssic.education.app.dto.WaresListDto;
import com.ssic.education.app.dto.WaresRelatedDto;
import com.ssic.education.app.interceptor.AccessRequired;
import com.ssic.education.app.service.IAppWaresService;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.StringUtils;

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
@RequestMapping(value = "/wares")
public class AppWaresController {
	@Autowired
	private IAppWaresService waresInfoService;

	/**
	 * getWaresList： 食品列表：根据供应商id查食品列表 原料列表：根据供应商id查原料列表
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月13日 下午3:32:09
	 */
	@RequestMapping(value = "/list/{supplierId}", method = RequestMethod.GET)
	@AccessRequired
	@ResponseBody
	public Response<List<WaresInfoDto>> getWaresList(@PathVariable("supplierId") String supplierId) {
		Response<List<WaresInfoDto>> result = new Response<List<WaresInfoDto>>();
		List<WaresInfoDto> waresInfoList = waresInfoService.getWaresBySupplierId(supplierId);
		result.setData(waresInfoList);
		return result;
	}

	/**
	 * getWaresInfo：菜品信息：根据菜品id查菜品信息（需要批次信息和供应商信息）
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月13日 上午11:55:28	
	 */
	@RequestMapping(value = "/dishesInfo/{id}", method = RequestMethod.GET)
	@AccessRequired
	@ResponseBody
	public Response<WaresRelatedDto> getDishesInfoById(@PathVariable("id") String id) {
		Response<WaresRelatedDto> result = new Response<WaresRelatedDto>();
		WaresRelatedDto waresInfoList = waresInfoService.findWarseById(id);
		result.setData(waresInfoList);
		return result;
	}

	/**
	 * getMaterialInfo：根据原料id查原料信息 
	 * @return 
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月13日 下午12:00:30
	 */
	@RequestMapping(value = "/materialInfo/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Response<WaresRelatedDto> getMaterialInfoById(@PathVariable("id") String id) {
		Response<WaresRelatedDto> result = new Response<WaresRelatedDto>();
		WaresRelatedDto waresInfoList = waresInfoService.findWarseById(id);
		result.setData(waresInfoList);
		return result;
	}

	/**
	 * purchaseList：采购品列表根据学校ID查询 分页类型和商品名称检索
	 * @author SeanYoung
	 * @throws Exception 
	 * @date 2016年5月13日 下午12:00:30	
	 */
	@RequestMapping(value = "/purchaseList/{schoolId}", method = { RequestMethod.POST, RequestMethod.GET })
	@AccessRequired
	public @ResponseBody Response<PageResult<WaresListDto>> purchaseList(@PathVariable("schoolId") String schoolId, ProWares prowares, PageQuery query) throws Exception {
		Response<PageResult<WaresListDto>> result = new Response<PageResult<WaresListDto>>();
		if (StringUtils.isEmpty(schoolId)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("查询Id为空");
			return result;
		} else {
			PageResult<WaresListDto> waresInfoList = waresInfoService.getWaresBySchoolId(schoolId, prowares, query);
			if (null != waresInfoList && !waresInfoList.getResults().isEmpty()) {
				result.setStatus(DataStatus.HTTP_SUCCESS);
				result.setMessage("查询成功！");
				result.setData(waresInfoList);
				return result;
			} else {
				result.setStatus(DataStatus.HTTP_SUCCESS);
				result.setMessage("未查到相关记录！");
				return result;
			}
		}
	}

	/**
	 * purchaseList：采购品列表根据学校ID查询 分页类型和商品名称检索
	 * @author SeanYoung
	 * @throws Exception 
	 * @date 2016年5月13日 下午12:00:30
	 */
	@RequestMapping(value = "/purchaseListDemo/{schoolId}", method = { RequestMethod.POST, RequestMethod.GET })
	@AccessRequired
	@ResponseBody
	public Response<PageResult<WaresListDto>> purchaseListDemo(@PathVariable("schoolId") String schoolId, @RequestBody String json) throws Exception {
		Response<PageResult<WaresListDto>> result = new Response<PageResult<WaresListDto>>();

		if (StringUtils.isEmpty(schoolId)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("查询Id为空");
			return result;
		} else {
			PageResult<WaresListDto> waresInfoList = waresInfoService.getWaresBySchoolId(schoolId, json);
			if (null != waresInfoList && !waresInfoList.getResults().isEmpty()) {
				result.setStatus(DataStatus.HTTP_SUCCESS);
				result.setMessage("查询成功！");
				result.setData(waresInfoList);
				return result;
			} else {
				result.setStatus(DataStatus.HTTP_SUCCESS);
				result.setMessage("未查到相关记录！");
				return result;
			}
		}
		//Map<String, Object> map = StringUtil.isEmpty(json) ? new HashMap<String, Object>() : JsonUtil.json2Obj(json, Map.class);
	}
}

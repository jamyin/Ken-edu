package com.ssic.education.government.controller.supplier;

import com.ssic.education.common.dto.ProLicenseDto;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.government.service.ProDishesService;
import com.ssic.education.common.government.service.ProLedgerService;
import com.ssic.education.common.government.service.ProSupplierService;
import com.ssic.education.government.controller.BaseController;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
  @Author: pengpeng
  @Date: 2016年5月12日 下午2:55:56 
  @Description: 
 */
@Controller
@RequestMapping(value = "/pro/supplier")
public class ProSupplierController extends BaseController {
	
	protected static final Log logger = LogFactory.getLog(ProSupplierController.class);
	private static final int PAGESIZE_WARES = 4;
	private static final int PAGESIZE_SUPPLIER = 4;

	@Autowired
	private ProSupplierService proSupplierService;
	@Autowired
	private ProDishesService proDishesService;
	@Autowired
	private ProLedgerService proLedgerService;

	/**
	 * <p>Description: 供应商资质分页查询接口 </p>
	 * <p>Company: 上海天坊信息科技有限公司</p>
	 * @param params
	 * @return ModelAndView
	 * @author wangxiang
	 * @date 2016/5/13 13:54
	 * @version 1.0
	 */
	@RequestMapping(value = "search")
	public ModelAndView search(ProSupplierDto params, PageQuery query){
		ModelAndView mv = getModelAndView();
		PageResult<ProSupplierDto> datas = proSupplierService.querySupplierByParams(params, query);
		mv.addObject("pageList", datas);
		mv.addObject("params", params);
		mv.addObject("areas", queryAllareas());
		mv.addObject("schools", queryAllschools());
		mv.setViewName("supplier/search_supplier");
		return mv;
	}

	/**
	 * 供应商资质详情
	  @Name:  qualificationsDetails 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:19:37 
	  @Description: 供应商详情
	  @param id
	  @return
	 */
	@RequestMapping(value = "/detail")
	public ModelAndView qualificationsDetails(String id) {
		ModelAndView mv = getModelAndView();
		ProSupplierDto supplier = proSupplierService.findById(id);
		PageQuery query = new PageQuery();
		PageResult<ProWaresDto> mWares = queryWares(id, query, false);
		PageResult<ProWaresDto> pWares = queryWares(id, query, true);
		PageResult<ProSupplierDto> mSuppliers = queryMaterialSupplier(id, query);
		mv.addObject("supplier", supplier);
		mv.addObject("mWares", mWares);
		mv.addObject("pWares", pWares);
		mv.addObject("mSuppliers", mSuppliers);
		mv.setViewName("supplier/supplier_qualification");
		return mv;
	}

	/**
	 * <p>Description: 根据供应商查询分页查询商品信息 </p>
	 *
	 * @param supplierId 供应商id
	 * @param query 分页参数
	 * @param dishes false-原料,true-成品
	 * @return PageResult<ProWaresDto>
	 * @author wangxiang
	 * @date 16/5/16 下午2:10
	 * @version 1.0
	 */
	private PageResult<ProWaresDto> queryWares(String supplierId, PageQuery query, boolean dishes){
		query.setPageSize(PAGESIZE_WARES);
		ProWaresDto params = new ProWaresDto();
		params.setSupplierId(supplierId);
		params.setDishes(dishes);
		PageResult<ProWaresDto> results = proDishesService.findPage(params, query);
		return results;
	}

	/**		
	 * <p>Description: 根据供应商id分页查询原料供应商 </p>
	 * 
	 * @param supplierId 供应商id
	 * @param query 分页参数
	 * @return PageResult<ProSupplierDto>
	 * @author wangxiang	
	 * @date 16/5/16 下午2:22
	 * @version 1.0
	 */
	private PageResult<ProSupplierDto> queryMaterialSupplier(String supplierId, PageQuery query){
		query.setPageSize(PAGESIZE_SUPPLIER);
		PageResult<ProSupplierDto> results = proLedgerService.findPage(supplierId, query);
		return results;
	}
}

package com.ssic.education.government.controller.supplier;

import com.ssic.education.common.dto.ProDishesDto;
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
	
	@Autowired
	private ProSupplierService proSupplierService;
	@Autowired
	private ProDishesService proDishesService;
	@Autowired
	private ProLedgerService proLedgerService;

	/**
	 * <p>Description: 供应商资质分页查询接口 </p>
	 * <p>Company: 上海天坊信息科技有限公司</p>
	 * @param 
	 * @return 
	 * @author wangxiang
	 * @date 2016/5/13 13:54
	 * @version 1.0
	 */
	@RequestMapping(value = "query")
	public ModelAndView queryIndex(ProSupplierDto params, PageQuery query){
		ModelAndView mv = getModelAndView();
		PageResult<ProSupplierDto> datas = proSupplierService.querySupplierByParams(params, query);
		mv.setViewName("");
		mv.addObject("datas", datas);
		return mv;
	}
	
	/**
	 * 
	  @Name:  qualificationsDetails 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:19:37 
	  @Description: 供应商详情
	  @param id
	  @param page
	  @return
	 */
	@RequestMapping(value = "/qualificationsDetails")
	public ModelAndView qualificationsDetails(String id,PageQuery page) {
		ModelAndView mv = getModelAndView();
		ProSupplierDto proSupplierDto = proSupplierService.findById(id);
		ProWaresDto proWaresDto =new ProWaresDto();
		proWaresDto.setSupplierId(id);
		PageResult<ProWaresDto> proWaresDtos = proDishesService.findPage(proWaresDto, page);
		PageResult<ProSupplierDto> proSupplierDtos = proLedgerService.findPage(id, page);
		mv.setViewName("qualificationsDetails");
		mv.addObject("ProSupplierDto", proSupplierDto);
		mv.addObject("proWaresDtos", proWaresDtos);
		mv.addObject("proSupplierDtos", proSupplierDtos);
		return mv;
	}

}

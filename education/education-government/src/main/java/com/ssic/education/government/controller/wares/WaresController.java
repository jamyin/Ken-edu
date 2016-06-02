package com.ssic.education.government.controller.wares;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.ProLedgerDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.government.controller.BaseController;
import com.ssic.education.government.controller.supplier.ProSupplierController;
import com.ssic.education.handle.dto.ProSchoolWareDto;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.service.IProLicenseService;
import com.ssic.education.handle.service.ProLedgerService;
import com.ssic.education.handle.service.ProWaresService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

/**
 * 
	 * 此类描述的是：原料 或者 成品菜 处理 模块
	 * @author: cwftalus@163.com
	 * @version: 2016年5月12日 下午5:05:51
 */

@Controller
@RequestMapping(value="/pro/wares")
public class WaresController extends BaseController {

	protected static final Log logger = LogFactory.getLog(ProSupplierController.class);
	
	@Autowired
	private ProWaresService proWaresService;
	@Autowired
	private ProLedgerService proLedgerService;
	
	@Autowired
	private IProLicenseService iProLicenseService;

	/**
	 * <p>Description: 成品/原料分页查询接口 </p>
	 * <p>Company: 上海天坊信息科技有限公司</p>
	 * @param params 查询参数
	 * @param query  分页参数
	 * @return ModelAndView
	 * @author wangxiang
	 * @date 2016/5/13 14:32
	 * @version 1.0
	 */
	@RequestMapping(value = "waresPages")
	public ModelAndView waresPage(ProSchoolWareDto proSchoolWareDto, PageQuery query){
		ModelAndView mv = getModelAndView();
		PageResult<ProWaresDto> datas = proWaresService.findWarsePageByParam(proSchoolWareDto, query);
		mv.addObject("pageList", datas);
		mv.addObject("params", proSchoolWareDto);
		mv.setViewName("wares/list");
		return mv;
	}

	/**
	 * 
	  @Name:  waresDetails 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:17:16 
	  @Description: 商品详情
	  @param id
	  @param page
	  @return
	 */
	@RequestMapping(value = "/details")
	private ModelAndView waresDetails(ProLedgerDto dto,PageQuery page) {
		ModelAndView mv = getModelAndView();
		ProWaresDto proWaresDto = proWaresService.findById(dto.getId());
		ProLedgerDto proLedgerDto = new ProLedgerDto();
		proLedgerDto.setWaresId(dto.getId());
		PageResult<ProLedgerDto> proLedgerDtos = proLedgerService.findLedgerPage(proLedgerDto, page);
		mv.setViewName("/school/purchasing_goods_detail");
		ProLicense proLicense = new ProLicense();
		proLicense.setCerSource((short)DataStatus.EVA_TWO);
		proLicense.setRelationId(dto.getId());
		List<ProLicense> proLicenses = iProLicenseService.lookImage(proLicense);
		mv.addObject("proWaresDto", proWaresDto);
		mv.addObject("proLedgerDtos", proLedgerDtos);
		mv.addObject("proLicenses", proLicenses);
		mv.addObject("dto", dto);
		return mv;
	}
	
	/**
	 * 
	  @Name:  ledgerDetails 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:16:38 
	  @Description: 商品批次详情
	  @param waresId
	  @param ledgerId
	  @return
	 */
	@RequestMapping(value = "/ledgerDetails")
	private ModelAndView ledgerDetails(String waresId,String ledgerId) {
		ModelAndView mv = getModelAndView();
		ProWaresDto proWaresDto = proWaresService.findById(waresId);
		ProLedgerDto proLedgerDto = proLedgerService.findById(ledgerId);
		mv.setViewName("/school/school_material_batch");
		mv.addObject("proWaresDto", proWaresDto);
		mv.addObject("proLedgerDto", proLedgerDto);
		return mv;
	}

}

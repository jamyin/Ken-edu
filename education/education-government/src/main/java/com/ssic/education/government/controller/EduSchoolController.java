package com.ssic.education.government.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.EduAreaDto;
import com.ssic.educateion.common.dto.EduCanteenDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.EduSchoolSupplierDto;
import com.ssic.educateion.common.dto.EduUsersDto;
import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.educateion.common.dto.SupplierReviewedDto;
import com.ssic.education.handle.service.AreaService;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.EduUsersService;
import com.ssic.education.handle.service.IEduCanteenService;
import com.ssic.education.handle.service.IEduSchoolSupplierService;
import com.ssic.education.handle.service.ProLedgerService;
import com.ssic.education.handle.service.ProPackagesService;
import com.ssic.education.handle.service.ProSupplierService;
import com.ssic.education.handle.service.ProWaresService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.constants.SchoollevelEnum;
import com.ssic.education.utils.constants.SessionConstants;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.DateUtils;

/**
 * 
  @Author: pengpeng
  @Date: 2016年5月12日 下午2:55:24 
  @Description: 
 */
@Controller
@RequestMapping(value = "/edu/school")
public class EduSchoolController extends BaseController{
	
	protected static final Log logger = LogFactory.getLog(EduSchoolController.class);
	
	private final static int PAGESIZE = 10;
	
	@Autowired
	private EduSchoolService eduSchoolService;
	
	@Autowired
	private IEduSchoolSupplierService iEduSchoolSupplierService;
	
	@Autowired
	private IEduCanteenService iEduCanteenService;
	
	@Autowired
	private ProPackagesService proPackagesService;
	
	@Autowired
	private ProSupplierService proSupplierService;
	
	@Autowired
	private ProLedgerService proLedgerService;
	
	@Autowired
	private ProWaresService proWaresService;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private EduUsersService eduUsersService;
	
	/**
	 * 
	  @Name:  list 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:18:03 
	  @Description: 学校列表
	  @param dto
	  @param page
	  @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
    		HttpSession session, EduSchoolDto dto, PageQuery page) {
		ModelAndView mv = getModelAndView();
		String id = (String) getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
		EduUsersDto usersdto = getLoginUser(request, response, session, id);
		if (StringUtils.isNotBlank(usersdto.getSourceId()) && !usersdto.getSourceId().equals("1") 
				&& usersdto.getSourceType() == DataStatus.DISABLED) {
			dto.setCommitteeId(usersdto.getSourceId());
		}		
		PageResult<EduSchoolDto> result = eduSchoolService.list(dto, page);
		List<EduAreaDto> areaDtos = areaService.queryAll();
		mv.addObject("pageList", result);
		mv.addObject("areaDtos", areaDtos);
		mv.addObject("dto", dto);
		mv.addObject("level", SchoollevelEnum.values());
		mv.setViewName("/school/school_list");
		return mv;
	}
	
	public EduUsersDto getLoginUser(HttpServletRequest request, HttpServletResponse response,
    		HttpSession session, String id){
    	if(id==null){
    		try {
				response.sendRedirect(request.getContextPath() + "/login.htm");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	EduUsersDto usersDto = new EduUsersDto();
    	usersDto.setId(id);
    	return eduUsersService.getUserInfo(usersDto);
    }
	
	@RequestMapping(value = "/canteen")
	public ModelAndView canteen(EduCanteenDto dto) {
		ModelAndView mv = this.getModelAndView();
		EduCanteenDto eduCanteenDto =iEduCanteenService.searchEduCanteenDto(dto);
		mv.addObject("eduCanteenDto", eduCanteenDto);
		mv.setViewName("/school/school_list");
		return mv;
	}
	
	@RequestMapping("/addShoolSupplier")
	@ResponseBody
	public Response<String> schoolSupplier(EduSchoolSupplierDto eduSchoolSupplierDto) {
		Response<String> res = new Response<String>();
		int result = iEduSchoolSupplierService.save(eduSchoolSupplierDto);
		if (result == DataStatus.ENABLED) {
			res.setStatus(DataStatus.HTTP_SUCCESS);
			res.setMessage("添加成功！");
		}else {
			res.setStatus(DataStatus.HTTP_FAILE);
			res.setMessage("添加失败！");
		}
		return res;
	}
	
	
	/**
	 * 
	  @Name:  details 
	  @Author: pengpeng
	  @Date: 2016年5月12日 下午6:18:42 
	  @Description: 学校餐详情
	  @param dto
	  @return
	 */
	@RequestMapping(value = "/details")
	public ModelAndView details(HttpServletRequest request, HttpServletResponse response,
    		HttpSession session, ProPackagesDto dto,PageQuery query) throws ParseException{
		query.setPageSize(5);
		ModelAndView mv = getModelAndView();
		SimpleDateFormat sdf=new SimpleDateFormat(DateUtils.YMD_DASH);  
		String str=sdf.format(new Date()); 
		if (StringUtils.isNotBlank(dto.getSupplyDateStr())) {
			dto.setSupplyDate(sdf.parse(dto.getSupplyDateStr()));
		} else {
			dto.setSupplyDate(new Date());
		}
		if (StringUtils.isBlank(dto.getCustomerId()) && dto.getSource() == DataStatus.ENABLED) {
			String id = (String) getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
			EduUsersDto usersdto = getLoginUser(request, response, session, id);
			dto.setCustomerId(usersdto.getSourceId());
		}
		EduSchoolDto eduSchoolDto = eduSchoolService.findById(dto.getCustomerId());
		List<ProSupplierDto> proSupplierDtos = eduSchoolService.getSupplier(dto.getCustomerId());
		List<ProPackagesDto> proPackagesDtos = proPackagesService.getProPackages(dto);
		EduSchoolSupplierDto eduSchoolSupplierDto = new EduSchoolSupplierDto();
		eduSchoolSupplierDto.setSchoolId(dto.getCustomerId());
		EduSchoolSupplierDto eduSchoolSupplierDtos= iEduSchoolSupplierService.searchEduSchoolSupplierDto(eduSchoolSupplierDto);
		PageResult<ProWaresDto> mWares = new PageResult<ProWaresDto>();
		ProSupplierDto proSupplierDto = new ProSupplierDto();
		PageResult<ProSupplierDto> mSuppliers = new PageResult<ProSupplierDto>();
		if (null != eduSchoolSupplierDtos && StringUtils.isNotBlank(eduSchoolSupplierDtos.getSupplierId())) {
			 mWares = queryWares(eduSchoolSupplierDtos.getSupplierId(), query, false);
			 proSupplierDto.setId(eduSchoolSupplierDtos.getSupplierId());
			 mSuppliers = queryMaterialSupplier(proSupplierDto, query);
		}
		LedgerDto ledgerDto = new LedgerDto();
		ledgerDto.setReceiverId(dto.getCustomerId());
		PageResult<LedgerDto> ledgerDtos = proLedgerService.selectLedgerPage(ledgerDto,query);
		mv.setViewName("/school/menu_city");
		mv.addObject("dto", dto);
		mv.addObject("mWares", mWares);
		mv.addObject("eduSchoolSupplierDtos", eduSchoolSupplierDtos);
		mv.addObject("eduSchoolDto", eduSchoolDto);
		mv.addObject("ledgerDtos", ledgerDtos);
		mv.addObject("proSupplierDtos", proSupplierDtos);
		mv.addObject("level", SchoollevelEnum.values());
		mv.addObject("proPackagesDtos", proPackagesDtos);
		mv.addObject("mSuppliers", mSuppliers);
		return mv;
	}
	
	private PageResult<ProWaresDto> queryWares(String supplierId, PageQuery query, boolean dishes){
		query.setPageSize(10);
		ProWaresDto params = new ProWaresDto();
		params.setSupplierId(supplierId);
//		params.setDishes(dishes);
		PageResult<ProWaresDto> results = proWaresService.queryWaresByParams(params, query);
		return results;
	}
	
	private PageResult<ProSupplierDto> queryMaterialSupplier(ProSupplierDto dto, PageQuery query){
		query.setPageSize(10);
		PageResult<ProSupplierDto> results = proLedgerService.findPage(dto, query);
		return results;
	}
	
	@RequestMapping(value = "/checkList")
	public ModelAndView checkList(HttpServletRequest request, HttpServletResponse response,
    		HttpSession session,SupplierReviewedDto dto, PageQuery page) {
		ModelAndView mv = getModelAndView();
		String id = (String) getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
		EduUsersDto usersdto = getLoginUser(request, response, session, id);
		if (StringUtils.isNotBlank(usersdto.getSourceId()) && !usersdto.getSourceId().equals("1") 
				&& usersdto.getSourceType() == DataStatus.DISABLED) {
			dto.setCommitteeId(usersdto.getSourceId());
		}	
		PageResult<SupplierReviewedDto> result = eduSchoolService.list(dto, page);
		mv.addObject("pageList", result);
		mv.addObject("dto", dto);
		if (dto.getReviewed() == DataStatus.DISABLED) {//区教委未审批单位
			mv.setViewName("/district/dis_edu_check");
		}	
		if (dto.getReviewed() == DataStatus.ENABLED) {//区教委审批通过单位
			mv.setViewName("/district/dis_edu_checked_list");
		}
		if (dto.getReviewed() == DataStatus.EVA_TWO) {//区教委审批通过单位
			mv.setViewName("/district/dis_edu_not_checked_list");
		}
		return mv;
	}
	
	/**
	 * 
	  @Name:  detail 
	  @Author: pengpeng
	  @Date: 2016年5月20日 下午4:32:24 
	  @Description: 教委审批单位详情
	  @param dto
	  @return
	 */
	@RequestMapping(value = "/detail")
	public ModelAndView detail(SupplierReviewedDto dto) {
		ModelAndView mv = getModelAndView();
		if (StringUtils.isNotBlank(dto.getSchoolName())) {
			EduSchoolDto eduSchoolDto = eduSchoolService.findById(dto.getId());
			mv.addObject("eduSchoolDto", eduSchoolDto);
			mv.addObject("dto", dto);
			mv.setViewName("/district/dis_edu_uncheck");
		}
		if (StringUtils.isNotBlank(dto.getSupplierName())) {
			ProSupplierDto proSupplierDto = proSupplierService.findById(dto.getId());
			mv.addObject("proSupplierDto", proSupplierDto);
			mv.addObject("dto", dto);
			mv.setViewName("/district/dis_edu_unchecks");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/detailed")
	public ModelAndView detailed(SupplierReviewedDto dto) {
		ModelAndView mv = getModelAndView();
		if (StringUtils.isNotBlank(dto.getSchoolName())) {
			EduSchoolDto eduSchoolDto = eduSchoolService.findById(dto.getId());
			mv.addObject("eduSchoolDto", eduSchoolDto);
			mv.addObject("dto", dto);
			mv.setViewName("/district/dis_edu_checked_detail");
		}
		if (StringUtils.isNotBlank(dto.getSupplierName())) {
			ProSupplierDto proSupplierDto = proSupplierService.findById(dto.getId());
			mv.addObject("proSupplierDto", proSupplierDto);
			mv.addObject("dto", dto);
			mv.setViewName("/district/dis_edu_checked_details");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/addSupplier")
	public ModelAndView addSupplier(EduSchoolSupplierDto eduSchoolSupplierDto,PageQuery page) {
		ModelAndView mv = getModelAndView();
		ProSupplierDto proSupplierdto = new ProSupplierDto();
		if (StringUtils.isNotBlank(eduSchoolSupplierDto.getSupplierId())) {
			 proSupplierdto = proSupplierService.findById(eduSchoolSupplierDto.getSupplierId());
		}		
		ProSupplierDto dto = new ProSupplierDto();
		dto.setReviewed((byte)1);
		dto.setSupplierName(eduSchoolSupplierDto.getSupplierName());
		List<ProSupplierDto> results = proSupplierService.findAll(dto);
		mv.addObject("results", results);
		mv.addObject("eduSchoolSupplierDto", eduSchoolSupplierDto);
		mv.addObject("proSupplierdto", proSupplierdto);
		mv.setViewName("/school/add_offer_company");
		return mv;
	}
	
	
	/**
	 * 
	  @Name:  getProLicenseBySchId 
	  @Author: pengpeng
	  @Date: 2016年5月20日 下午4:33:07 
	  @Description: 教委审批单位详情
	  @param dto
	  @return
	 */
	@RequestMapping(value = "/license")
	public ModelAndView getProLicenseBySchId(ProLicenseDto dto) {
		ModelAndView mv = getModelAndView();		
		List<ProLicenseDto> proLicenseDtos = eduSchoolService.getProLicenseBySchId(dto);
		mv.addObject("proLicenseDtos", proLicenseDtos);
		mv.addObject("data", dto);
		mv.setViewName("/district/dis_edu_pic");
		return mv;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public Response<String> update(SupplierReviewedDto dto) {
		Response<String> res = new Response<String>();
		Integer result = null;
		if (StringUtils.isNotBlank(dto.getSchoolName())) {
			EduSchoolDto eduSchoolDto = BeanUtils.createBeanByTarget(dto, EduSchoolDto.class);
			result = eduSchoolService.updateSchool(eduSchoolDto);
		}
		if (StringUtils.isNotBlank(dto.getSupplierName())) {
			ProSupplierDto proSupplierDto = BeanUtils.createBeanByTarget(dto, ProSupplierDto.class);
			result = proSupplierService.updatePS(proSupplierDto);
		}
		if (result == DataStatus.ENABLED) {
			res.setStatus(DataStatus.HTTP_SUCCESS);
			res.setMessage("更新成功！");
		}if (result == DataStatus.DISABLED) {
			res.setStatus(DataStatus.HTTP_FAILE);
			res.setMessage("更新失败！");
		}
		return res;
	}
}

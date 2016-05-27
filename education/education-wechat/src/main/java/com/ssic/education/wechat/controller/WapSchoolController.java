package com.ssic.education.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.EduCanteenDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.EduSchoolSupplierDto;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.IEduCanteenService;
import com.ssic.education.handle.service.IEduSchoolSupplierService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.Response;

/**
 * 
	 * 此类描述的是：wap 和学校信息相关的接口信息
	 * @author: cwftalus@163.com
	 * @version: 2016年5月21日 下午2:18:27
 */
@Controller
@RequestMapping(value="wap/school")
public class WapSchoolController extends BaseController{
	
	@Autowired
	private EduSchoolService eduSchoolService;


	
	@Autowired
	private IEduCanteenService iEduCanteenService;
	
	@Autowired
	private IEduSchoolSupplierService iEduSchoolSupplierService;
	
	
	@RequestMapping(value="school/{schoolId}")
	public ModelAndView school(@PathVariable String schoolId){
		ModelAndView mv = getModelAndView();
		//学校详细信息
		EduSchoolDto eduSchoolDto = eduSchoolService.findById(schoolId);
		
		//学校对应的食堂信息
		EduCanteenDto eduCanteenDto = new EduCanteenDto();
		eduCanteenDto.setSchoolId(schoolId);
		eduCanteenDto = iEduCanteenService.searchEduCanteenDto(eduCanteenDto);
		
		//学校对应的供应商信息
		EduSchoolSupplierDto eduSchoolSupplierDto = new EduSchoolSupplierDto();
		eduSchoolSupplierDto.setSchoolId(schoolId);
		eduSchoolSupplierDto = iEduSchoolSupplierService.searchEduSchoolSupplierDto(eduSchoolSupplierDto);
		
		
		mv.addObject("eduCanteenDto", eduCanteenDto);
		mv.addObject("eduSchoolDto", eduSchoolDto);
		mv.addObject("eduSchoolSupplierDto", eduSchoolSupplierDto);
		
		mv.setViewName("school");
		return mv;
	}
	
	
	/**
	 * 
		 * 此方法描述的是：根据条件查询学校信息List
		 * @author: cwftalus@163.com
		 * @version: 2016年5月21日 下午2:19:48
	 */
	@RequestMapping(value="search")
	@ResponseBody
	public Response<List<EduSchoolDto>> search(EduSchoolDto eduSchoolDto){
		Response<List<EduSchoolDto>> result = new Response<List<EduSchoolDto>>();
		
		List<EduSchoolDto> dataList = eduSchoolService.searchEduScholDtoList(eduSchoolDto);
		if(dataList!=null && dataList.size()>0){
			result.setData(dataList);
		}else{
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("未找到相对应的学校信息");
		}
		return result;
	}
	/**
	 * 
		 * 此方法描述的是：根据学校Id 获取 学校对应的详细信息
		 * @author: cwftalus@163.com
		 * @version: 2016年5月21日 下午2:25:15
	 */
	@RequestMapping(value="/details/{schoolId}")
	public ModelAndView details(@PathVariable String schoolId){
		ModelAndView mv = getModelAndView();
		EduSchoolDto data = eduSchoolService.findById(schoolId);
		
		mv.addObject("data", data);
		mv.setViewName("schoolDetails");
		return mv;
	}	
	
}

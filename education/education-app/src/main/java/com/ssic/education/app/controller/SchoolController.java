package com.ssic.education.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.EduCanteenDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.EduSchoolSupplierDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.education.app.constants.SchoolLevel;
import com.ssic.education.app.dto.SchoolDto;
import com.ssic.education.app.service.ISchoolService;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.IEduCanteenService;
import com.ssic.education.handle.service.IEduSchoolSupplierService;
import com.ssic.education.handle.service.ProPackagesService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.StringUtils;

/**
 * @ClassName: AreaController
 * @Description: 查询上海市全部区县controller
 * @author Ken Yin
 * @date 2016年5月12日 上午10:30:02
 *
 */
@Controller
@RequestMapping(value = "/school")
public class SchoolController {

	@Autowired
	private ISchoolService schoolService;

	@Autowired
	private EduSchoolService eduSchoolService;

	@Autowired
	private IEduCanteenService iEduCanteenService;

	@Autowired
	private IEduSchoolSupplierService iEduSchoolSupplierService;
	
	@Autowired
	private ProPackagesService proPackagesService;

	/**
	 * @Title: findSchoolList
	 * @Description: 查询全部学校列表
	 * @author Ken Yin  
	 * @date 2016年5月13日 上午9:14:56
	 * @return Response<PageResult<EduSchoolDto>>    返回类型
	 */
	@RequestMapping("/findSchoolList")
	@ResponseBody
	public Response<PageResult<EduSchoolDto>>  findSchoolList(EduSchoolDto eduSchoolDto, PageQuery query) {
		Response<PageResult<EduSchoolDto>> result = new Response<PageResult<EduSchoolDto>>();
		PageResult<EduSchoolDto> schoolList = schoolService.findSchoolList(eduSchoolDto, query);
		if(schoolList.getResults() != null && schoolList.getResults().size() >0 ){
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(schoolList);
			return result;
		}else{
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("未查到相关记录！");
			return result;
		}
	}

	/**
	 * @Title: getDishesType
	 * @Description: 学校年级列表
	 * @author Ken Yin  
	 * @date 2016年5月17日 下午2:50:36
	 * @return Response<Map<Integer,String>>    返回类型
	 */
	@RequestMapping(value = "/classList", method = RequestMethod.GET)
	@ResponseBody
	public Response<Map<Integer, String>> getClassType() {
		Response<Map<Integer, String>> result = new Response<Map<Integer, String>>();
		result.setData(SchoolLevel.getAll());
		return result;
	}

	/**
	 * @Title: findSchoolDetialList
	 * @Description: 根据学校id查学校信息（需要带出当天全部年级菜单）
	 * @author Ken Yin  
	 * @date 2016年5月13日 上午10:53:53
	 * @return Response<PageResult<EduSchoolDto>>    返回类型
	 */
	@RequestMapping("/findSchoolDetialList/{id}")
	@ResponseBody
	public Response<PageResult<EduSchoolDto>> findSchoolDetialList(@PathVariable("id")String id,EduSchoolDto eduSchoolDto, PageQuery query) {
		Response<PageResult<EduSchoolDto>> result = new Response<PageResult<EduSchoolDto>>();
		if(StringUtils.isEmpty(id)){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("查询Id为空");
			return result;
		}
		PageResult<EduSchoolDto> schoolDetialList = schoolService.findSchoolDetialList(id,eduSchoolDto, query);
		if(schoolDetialList.getResults() != null && schoolDetialList.getResults().size() >0 ){
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(schoolDetialList);
			return result;
		}else{
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("未查到相关记录！");
			return result;
		}
	}

	/**
	 * @Title: school
	 * @Description: 查询学校详细信息
	 * @author Ken Yin  
	 * @date 2016年5月26日 下午3:01:31
	 * @return Response<SchoolDto>    返回类型
	 */
	@RequestMapping(value="school")
	@ResponseBody
	public Response<SchoolDto> school(String schoolId,ProPackagesDto dto, PageQuery page){
		Response<SchoolDto> result = new Response<SchoolDto>();
		SchoolDto school = new SchoolDto();
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
		
		PageResult<ProPackagesDto> proPackagesDtos = proPackagesService.searchPackages(dto, page);

		school.setEduSchoolDto(eduSchoolDto);
		school.setEduCanteenDto(eduCanteenDto);
		school.setEduSchoolSupplierDto(eduSchoolSupplierDto);
		school.setProPackagesDto(proPackagesDtos);
		
		result.setData(school);
		return result;
	}

	/**
	 * 此方法描述的是：查询该家长关联下的学校的所有菜谱信息
	 * @param 传入customerId 为当前学校Id
	 * @param supplyDateStr 套餐日期 默认为当前日期
	 */
	@RequestMapping(value="searchPackages")
	@ResponseBody
	public Response<PageResult<ProPackagesDto>> searchPackages(ProPackagesDto dto, PageQuery page){
		Response<PageResult<ProPackagesDto>> result = new Response<PageResult<ProPackagesDto>>();
		PageResult<ProPackagesDto> proPackagesDtos = proPackagesService.searchPackages(dto, page);
		if(proPackagesDtos != null && proPackagesDtos.getResults() != null && proPackagesDtos.getResults().size() > 0){
			result.setData(proPackagesDtos);
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功");
			return result;
		}
		result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("未查到相关记录");
		return result;
	}
}


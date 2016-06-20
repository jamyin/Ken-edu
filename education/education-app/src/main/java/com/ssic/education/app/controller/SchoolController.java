package com.ssic.education.app.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.ChooseSchoolDto;
import com.ssic.educateion.common.dto.EduCanteenDto;
import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.EduSchoolSupplierDto;
import com.ssic.educateion.common.dto.MapToListDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.educateion.common.dto.SchoolDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.education.app.constants.SchoolLevel;
import com.ssic.education.app.dto.SchoolUserDto;
import com.ssic.education.app.interceptor.AccessRequired;
import com.ssic.education.app.service.ICommitteeService;
import com.ssic.education.app.service.ISchoolService;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.IEduCanteenService;
import com.ssic.education.handle.service.IEduSchoolSupplierService;
import com.ssic.education.handle.service.ProPackagesService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.constants.PackagesTypeEnum;
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

	protected static final Log logger = LogFactory.getLog(SchoolController.class);

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

	//	@Autowired
	//	private IAreaService areaService;

	@Autowired
	private ICommitteeService committeeService;

	/**
	 * @Title: findSchoolList
	 * @Description: 查询全部学校列表
	 * @author Ken Yin  
	 * @date 2016年5月13日 上午9:14:56
	 * @return Response<PageResult<EduSchoolDto>>    返回类型
	 */
	@AccessRequired
	@RequestMapping("/findSchoolList")
	@ResponseBody
	public Response<PageResult<SchoolDto>> findSchoolList(SchoolDto schoolDto, PageQuery query, Integer isPage) {
		logger.info("SchoolDto : " + schoolDto + ";isPage : " + isPage);

		Response<PageResult<SchoolDto>> result = new Response<PageResult<SchoolDto>>();
		PageResult<SchoolDto> schoolList = schoolService.findSchoolList(schoolDto, query, isPage);
		if (schoolList.getResults() != null && schoolList.getResults().size() > 0) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(schoolList);
			return result;
		} else {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("未查到相关记录！");
			return result;
		}
	}

	/**
	 * @Title: List
	 * @Description: 学校类型列表
	 * @author Ken Yin  
	 * @date 2016年5月17日 下午2:50:36
	 * @return Response<Map<Integer,String>>    返回类型
	 */
	@RequestMapping(value = "/levelList", method = RequestMethod.GET)
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
	public Response<PageResult<EduSchoolDto>> findSchoolDetialList(@PathVariable("id") String id, EduSchoolDto eduSchoolDto, PageQuery query) {
		logger.info("EduSchoolDto : " + eduSchoolDto + ";id : " + id);
		Response<PageResult<EduSchoolDto>> result = new Response<PageResult<EduSchoolDto>>();
		if (StringUtils.isEmpty(id)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("查询Id为空");
			return result;
		}
		PageResult<EduSchoolDto> schoolDetialList = schoolService.findSchoolDetialList(id, eduSchoolDto, query);
		if (schoolDetialList.getResults() != null && schoolDetialList.getResults().size() > 0) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(schoolDetialList);
			return result;
		} else {
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
	@RequestMapping(value = "school")
	@AccessRequired
	@ResponseBody
	public Response<EduSchoolDto> school(ProPackagesDto dto, PageQuery page) {
		logger.info("ProPackagesDto : " + dto);
		Response<EduSchoolDto> result = new Response<EduSchoolDto>();
		if (StringUtils.isEmpty(dto.getCustomerId())) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("学校Id为空！");
			return result;
		}
		//学校详细信息
		String schoolId = dto.getCustomerId();
		EduSchoolDto eduSchoolDto = eduSchoolService.findById(schoolId);

		if (eduSchoolDto == null) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("未查到相关学校");
			return result;
		}

		//学校对应的食堂信息
		EduCanteenDto eduCanteenDto = new EduCanteenDto();
		eduCanteenDto.setSchoolId(schoolId);
		eduCanteenDto = iEduCanteenService.searchEduCanteenDto(eduCanteenDto);

		//学校对应的供应商信息
		EduSchoolSupplierDto eduSchoolSupplierDto = new EduSchoolSupplierDto();
		eduSchoolSupplierDto.setSchoolId(schoolId);
		//eduSchoolSupplierDto = iEduSchoolSupplierService.searchEduSchoolSupplierDto(eduSchoolSupplierDto);
		List<SupplierDto> supplierList = iEduSchoolSupplierService.searchEduSchoolSupplierListDto(schoolId);

		List<MapToListDto> typeList = new ArrayList<MapToListDto>();
		for (Entry<Integer, String> entry : PackagesTypeEnum.getAll().entrySet()) {
			MapToListDto mapToListDto = new MapToListDto();
			mapToListDto.setKey(entry.getKey());
			mapToListDto.setValue(entry.getValue());
			typeList.add(mapToListDto);
		}
		eduSchoolDto.setTypeList(typeList);
		//PageResult<ProPackagesDto> proPackagesDtos = proPackagesService.searchPackages(dto, page);
		List<ProPackagesDto> proPackagesDtos = null;
		try {
			proPackagesDtos = proPackagesService.getProPackages(dto);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		eduSchoolDto.setEduCanteenDto(eduCanteenDto);
		//eduSchoolDto.setEduSchoolSupplierDto(eduSchoolSupplierDto);
		if (supplierList != null && supplierList.size() > 0) {
			eduSchoolDto.setSupplierDto(supplierList.get(0));
		}
		eduSchoolDto.setPackagesDtoList(proPackagesDtos); //委托供应商

		result.setData(eduSchoolDto);
		return result;
	}

	/**
	 * 此方法描述的是：查询该家长关联下的学校的所有菜谱信息
	 * @param 传入customerId 为当前学校Id
	 * @param supplyDateStr 套餐日期 默认为当前日期
	 */
	@RequestMapping(value = "searchPackages")
	@AccessRequired
	@ResponseBody
	public Response<PageResult<ProPackagesDto>> searchPackages(ProPackagesDto dto, PageQuery page) {
		logger.info("ProPackagesDto : " + dto);
		Response<PageResult<ProPackagesDto>> result = new Response<PageResult<ProPackagesDto>>();
		PageResult<ProPackagesDto> proPackagesDtos = proPackagesService.searchPackages(dto, page);
		if (proPackagesDtos != null && proPackagesDtos.getResults() != null && proPackagesDtos.getResults().size() > 0) {
			result.setData(proPackagesDtos);
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功");
			return result;
		}
		result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("未查到相关记录");
		return result;
	}

	/**
	 * @Title: chooseSchool
	 * @Description: app选择学校页面  page =0或不传表示不分页  ; isPage =1表示分页  
	 * @author Ken Yin  
	 * @date 2016年5月29日 下午12:35:10
	 * @return Response<PageResult<EduSchoolDto>>    返回类型
	 */
	@RequestMapping("/chooseSchool")
	@AccessRequired
	@ResponseBody
	public Response<ChooseSchoolDto> chooseSchool(SchoolDto schoolDto, PageQuery query, Integer type, Integer sourceType) {
		logger.info("SchoolDto : " + schoolDto + ";type : " + type + ";sourceType : " + sourceType);
		Response<ChooseSchoolDto> result = new Response<ChooseSchoolDto>();
		//处理CommitteeId全选传-1
		if (StringUtils.isNotEmpty(schoolDto.getCommitteeId()) && schoolDto.getCommitteeId().equals("-1")) {
			schoolDto.setCommitteeId(null);
		}
		//处理level全选传-1
		if (StringUtils.isNotEmpty(schoolDto.getLevel()) && schoolDto.getLevel().equals("-1")) {
			schoolDto.setLevel(null);
		}
		ChooseSchoolDto chooseSchoolDto = new ChooseSchoolDto();
		if (sourceType == null) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("教委类型为空");
			return result;
		}
		//市教委选择学校
		if (sourceType == 0) {
			//Type:为1则学校信息,区域信息和学校级别都会查出来; 不传则只查学校信息
			if (type != null && type == 1) {
				//显示学校级别列表
				List<MapToListDto> levelList = showSchoolLevel();
				chooseSchoolDto.setLevelList(levelList);

				//显示区教委
				//EduCommitteeDto eduCommitteeDto = new EduCommitteeDto();
				//eduCommitteeDto.setType((short) 2);      //只查区教委列表
				List<EduCommitteeDto> committeeList = committeeService.findCommitteeListNoPage(new EduCommitteeDto());
				if(committeeList != null && committeeList.size() >0){
					committeeList.get(0).setId("-1");
					committeeList.get(0).setName("全部");
				}
				chooseSchoolDto.setCommitteeList(committeeList);

				//学校列表
				if(StringUtils.isNotEmpty(schoolDto.getCommitteeId()) && schoolDto.getCommitteeId().equals("9fa83d14-3691-11e6-b1e8-005056a5ed30")){
					schoolDto.setCommitteeId(null);
				}
				PageResult<SchoolDto> schoolList = schoolService.findSchoolList(schoolDto, query, null); 
				chooseSchoolDto.setSchoolDto(schoolList);
				result.setData(chooseSchoolDto);
			} else {
				//学校列表  -查所有
				schoolDto.setCommitteeId(null);
				schoolDto.setLevel(null);
				PageResult<SchoolDto> schoolList = schoolService.findSchoolList(schoolDto, query, null); 
				chooseSchoolDto.setSchoolDto(schoolList);
				result.setData(chooseSchoolDto);
			}

		}

		//区教委选择学校  注sourceType为用户的类型
		if (sourceType == 2) {
			//Type:为1则学校信息,区域信息和学校级别都会查出来; 不传则只查学校信息
			if (type != null && type == 1) {
				//显示学校级别列表
				List<MapToListDto> levelList = showSchoolLevel();
				chooseSchoolDto.setLevelList(levelList);
			}
			//学校列表
			PageResult<SchoolDto> schoolList = schoolService.findSchoolList(schoolDto, query, null); 
			chooseSchoolDto.setSchoolDto(schoolList);
			result.setData(chooseSchoolDto);
		}
		return result;
	}

	/**
	 * 学校用户信息
	 * @param schoolId
	 * @return
	 */
	@RequestMapping("/user/{schoolId}")
	@AccessRequired
	public @ResponseBody Response<SchoolUserDto> schoolUser(@PathVariable("schoolId") String schoolId) {
		return new Response<SchoolUserDto>(200, "查询成功", schoolService.findSchoolById(schoolId));
	}

	/**
	 * @Title: showSchoolLevel
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author Ken Yin  
	 * @date 2016年6月1日 下午4:15:08
	 * @return List<MapToListDto>    返回类型
	 */
	private List<MapToListDto> showSchoolLevel() {
		List<MapToListDto> levelList = new ArrayList<MapToListDto>();
		for (Entry<Integer, String> entry : SchoolLevel.getAll().entrySet()) {
			MapToListDto mapToListDto = new MapToListDto();
			mapToListDto.setKey(entry.getKey());
			mapToListDto.setValue(entry.getValue());
			levelList.add(mapToListDto);
		}
		return levelList;
	}
}

package com.ssic.education.wechat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.ProDishesDto;
import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.education.handle.dto.EduParentPackCommentDto;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.IEduParentPackCommentService;
import com.ssic.education.handle.service.ProDishesService;
import com.ssic.education.handle.service.ProPackagesService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.constants.SupplyPhaseEnum;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.DateUtils;

/**
 * 
 * 此类描述的是：wap 和学校信息相关的接口信息
 * 
 * @author: cwftalus@163.com
 * @version: 2016年5月21日 下午2:18:27
 */
@Controller
@RequestMapping(value = "/wap/comment")
public class WapCommentController extends BaseController {
	
	
	@Autowired
	private IEduParentPackCommentService iEduParentPackCommentService;
	
	@Autowired
	private ProPackagesService proPackagesService;
	
	
	@Autowired
	private EduSchoolService eduSchoolService;
	
	@Autowired
	private ProDishesService proDishesService;
	
	/**
	 * 
		 * 此方法描述的是：进入某一个菜的点评功能页面
		 * @author: cwftalus@163.com
		 * @version: 2016年5月23日 下午3:50:56
	 */
	@RequestMapping(value="/join/{packageId}")
	public ModelAndView join(@PathVariable String packageId){
		ModelAndView mv = getModelAndView();

		//先判断该用户是否已经点评过 如果已经点评则直接跳转至我的点评页面
		EduParentPackCommentDto eduParentPackCommentDto = new EduParentPackCommentDto();
		eduParentPackCommentDto.setPackageId(packageId);
		eduParentPackCommentDto.setParentId(parentId);
		List<EduParentPackCommentDto> dataList = iEduParentPackCommentService.searchComment(eduParentPackCommentDto);
		if(dataList!=null && dataList.size() > 0 ){
			return new ModelAndView("redirect:/wap/comment/index.htm");
		}
		
		ProPackagesDto proPackageSto = proPackagesService.findById(packageId);
		
		String schoolId = proPackageSto.getCustomerId();//学校Id
		EduSchoolDto schoolDto = eduSchoolService.findById(schoolId);
		
		List<String> packageIdList = new ArrayList<String>();
		packageIdList.add(packageId);
		
		//查询dishes 信息
		List<ProDishesDto> resultDishList = proDishesService.searchDishes(packageIdList);
		
		mv.addObject("schoolDto", schoolDto);
		mv.addObject("proPackageSto", proPackageSto);
		mv.addObject("packageName", SupplyPhaseEnum.getValueByIndex(proPackageSto.getSupplyPhase()));
		mv.addObject("resultDishList", resultDishList);
		mv.setViewName("join");
		return mv;
	}
	
	/**
	 * 
		 * 此方法描述的是：针对某一菜进行评价
		 * @author: cwftalus@163.com
		 * @version: 2016年5月23日 下午3:50:56
	 */
	@RequestMapping(value="comment")
	@ResponseBody
	public Response<String> comment(EduParentPackCommentDto eduParentPackCommentDto){
		Response<String> result = new Response<String>();
		eduParentPackCommentDto.setParentId(parentId);
		int data = iEduParentPackCommentService.saveComment(eduParentPackCommentDto);
		if (data > 0) {
			result.setMessage("点评成功");
			//成功之后进行计算总体的星级
			Integer count = iEduParentPackCommentService.countPackageStar(eduParentPackCommentDto.getPackageId());
			
			ProPackagesDto propackage = proPackagesService.findById(eduParentPackCommentDto.getPackageId());
			propackage.setPackageStar(count);
			proPackagesService.updatePackage(propackage);
		} else {
			result.setStatus(DataStatus.HTTP_FAILE);
		}		
		return result;
	}
	/**
	 * 
		 * 此方法描述的是：查询菜对应的点评信息 我的点评信息
		 * @author: cwftalus@163.com
		 * @version: 2016年5月24日 上午9:26:45
	 */
	@RequestMapping(value="index")
	public ModelAndView searchComment(EduParentPackCommentDto eduParentPackCommentDto,String code){
		
		setWeixinOpenId(code);
		
		ModelAndView mv = getModelAndView();

		eduParentPackCommentDto.setParentId(parentId);
		List<EduParentPackCommentDto> dataList = iEduParentPackCommentService.searchComment(eduParentPackCommentDto);
		List<String> packageIds = new ArrayList<String>();
		for(EduParentPackCommentDto dto : dataList){
			packageIds.add(dto.getPackageId());
			try {
				dto.setWeekName(DateUtils.dayForWeek(dto.getSupplyDate(),DateUtils.YMD_DASH));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<ProPackagesDto> resultList = proPackagesService.searchProPackages(packageIds);
		if(resultList!=null){
			HashMap<String,String> packageMap = copyListToMap(resultList);
			for(EduParentPackCommentDto dto : dataList){
				dto.setSupplyPhase(packageMap.get(dto.getPackageId()));
			}			
		}
		
		mv.addObject("dataList",dataList);
		mv.setViewName("comment");
		return mv;
	}

	private HashMap<String, String> copyListToMap(List<ProPackagesDto> resultList) {
		HashMap<String, String> objMap = new HashMap<String, String>();
		for(ProPackagesDto packDto : resultList){
			String keyCode = packDto.getId();
			objMap.put(keyCode,SupplyPhaseEnum.getValueByIndex(Integer.valueOf(packDto.getSupplyPhase())));
		}
		return objMap;
	}	
	
	
//	/**
//	 * 
//	 * 此方法描述的是：关注 相当于保存信息处理
//	 * 
//	 * @author: cwftalus@163.com
//	 * @version: 2016年5月21日 下午3:31:44
//	 */
//	@RequestMapping(value = "follow")
//	@ResponseBody
//	public Response<EduParentScChDto> follow(EduParentScChDto eduParentScChDto) {
//		Response<EduParentScChDto> result = new Response<EduParentScChDto>();
//
//		eduParentScChDto.setParentId(parentId);
//		int data = iEduParentScChService.saveFollow(eduParentScChDto);
//		if (data > 0) {
//			result.setMessage("关注成功");
//		} else {
//			result.setStatus(DataStatus.HTTP_FAILE);
//		}
//		return result;
//	}
//
//	/**
//	 * 
//	 * 此方法描述的是：取消关注
//	 * 
//	 * @author: cwftalus@163.com
//	 * @version: 2016年5月24日 下午2:15:12
//	 */
//	@RequestMapping(value = "unFollow")
//	@ResponseBody
//	public Response<EduParentScChDto> unFollow(EduParentScChDto eduParentScChDto) {
//		Response<EduParentScChDto> result = new Response<EduParentScChDto>();
//		eduParentScChDto.setStat(DataStatus.DISABLED);
//		int data = iEduParentScChService.updateFollow(eduParentScChDto);
//		if (data > 0) {
//			result.setMessage("操作成功");
//		} else {
//			result.setStatus(DataStatus.HTTP_FAILE);
//		}
//		return result;
//	}
}

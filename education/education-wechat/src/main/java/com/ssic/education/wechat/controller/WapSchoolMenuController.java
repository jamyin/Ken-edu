package com.ssic.education.wechat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.ProDishesDto;
import com.ssic.educateion.common.dto.ProNutritionalDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.education.handle.dto.EduParentPackCommentDto;
import com.ssic.education.handle.service.IEduParentPackCommentService;
import com.ssic.education.handle.service.INutritionalService;
import com.ssic.education.handle.service.ProDishesService;
import com.ssic.education.handle.service.ProPackagesService;
import com.ssic.education.utils.model.Response;

/**
 * 
	 * 此类描述的是：查询学校对应的菜谱信息
	 * @author: cwftalus@163.com
	 * @version: 2016年5月23日 上午10:29:31
 */
@Controller
@RequestMapping(value="/wap/scMenu")
public class WapSchoolMenuController extends BaseController{
	
	@Autowired
	private ProPackagesService proPackagesService;
	
	@Autowired
	private INutritionalService iNutritionalService;
	
	@Autowired
	private ProDishesService proDishesService;
	
	@Autowired
	private IEduParentPackCommentService iEduParentPackCommentService;
	
	/**
	 * 
		 * 此方法描述的是：查询该家长关联下的学校的所有菜谱信息
		 * @author: cwftalus@163.com
		 * @version: 2016年5月23日 上午10:41:48
		 * @param customerId 学校Id
		 * @param timeDate 套餐日期 默认为当前日期
	 */
	@RequestMapping(value="search")
	@ResponseBody
	public Response<List<ProPackagesDto>> search(String customerId,String timeDate,Integer type){
		
		Response<List<ProPackagesDto>> response = new Response<List<ProPackagesDto>>();
		List<ProPackagesDto> dataList =  proPackagesService.searchProSchoolPackage(customerId,timeDate,type);
		
		
//		packageId ->  t_pro_dishes -> t_pro_wares
//		t_pro_nutritional 营养信息
		List<String> packageIdList = new ArrayList<String>();
		for(ProPackagesDto proPackageDto : dataList){
			packageIdList.add(proPackageDto.getId());
		}
		//查询营养信息
		List<ProNutritionalDto> resultList =  iNutritionalService.searchNutritional(packageIdList);
		HashMap<String,List<ProNutritionalDto>> packAgeMap = listToMap(resultList);
		
		//查询dishes 信息
		List<ProDishesDto> resultDishList = proDishesService.searchDishes(packageIdList);
		HashMap<String,List<ProDishesDto>> packDishMap = listToDishMap(resultDishList);
		
		//查找该用户是否已经评价
		EduParentPackCommentDto eduParentPackCommentDto = new EduParentPackCommentDto();
		eduParentPackCommentDto.setPackageIds(packageIdList);
		eduParentPackCommentDto.setParentId(getParentId());
		List<EduParentPackCommentDto> comList = iEduParentPackCommentService.searchComment(eduParentPackCommentDto);
		HashMap<String,EduParentPackCommentDto> comListToMap = comListToMap(comList);
		
		
		for(ProPackagesDto packageDto : dataList){
			packageDto.setProNutritionalDtos(packAgeMap.get(packageDto.getId()));
			packageDto.setProDishesDtos(packDishMap.get(packageDto.getId()));
			if(comListToMap.containsKey(packageDto.getId())){
				packageDto.setEvaluated(true);
			}
		}

		response.setData(dataList);
		
		return response;
	}
	
	private HashMap<String, EduParentPackCommentDto> comListToMap(List<EduParentPackCommentDto> comList) {
		HashMap<String, EduParentPackCommentDto> objMap = new HashMap<String,EduParentPackCommentDto>();
		for(EduParentPackCommentDto dto : comList){
			String keyCode = dto.getPackageId();
			objMap.put(keyCode, dto);
		}
		return objMap;
	}

	private HashMap<String, List<ProDishesDto>> listToDishMap(List<ProDishesDto> resultList) {
		HashMap<String, List<ProDishesDto>> objMap = new HashMap<String, List<ProDishesDto>>();
		List<ProDishesDto> objList = null;
		for(ProDishesDto dishesDto : resultList){
			String keyCode = dishesDto.getPackageId();
			if(objMap.containsKey(keyCode)){
				objList = objMap.get(keyCode);
				objList.add(dishesDto);
			}else{
				objList = new ArrayList<ProDishesDto>();
				objList.add(dishesDto);
			}
			objMap.put(keyCode, objList);
		}
		return objMap;
	}

	private HashMap<String, List<ProNutritionalDto>> listToMap(List<ProNutritionalDto> resultList) {
		HashMap<String, List<ProNutritionalDto>> objMap = new HashMap<String, List<ProNutritionalDto>>();
		List<ProNutritionalDto> objList = null;
		for(ProNutritionalDto nutritionalDto : resultList){
			String keyCode = nutritionalDto.getPackageId();
			if(objMap.containsKey(keyCode)){
				objList = objMap.get(keyCode);
				objList.add(nutritionalDto);
			}else{
				objList = new ArrayList<ProNutritionalDto>();
				objList.add(nutritionalDto);
			}
			objMap.put(keyCode, objList);
		}
		return objMap;
	}

	/**
	 * 
		 * 此方法描述的是：查询某一个菜的详细信息
		 * @author: cwftalus@163.com
		 * @version: 2016年5月23日 下午3:50:56
	 */
	@RequestMapping(value="packageDetails")
	public ProPackagesDto searchDetails(String packageId){
		
		ProPackagesDto proPackageDto = proPackagesService.findById(packageId);
		
		return proPackageDto;
	}

	
}

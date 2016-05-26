package com.ssic.education.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.education.handle.dto.EduParentPackCommentDto;
import com.ssic.education.handle.service.IEduParentPackCommentService;
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
	public Response<List<ProPackagesDto>> search(String customerId,String timeDate){
		Response<List<ProPackagesDto>> response = new Response<List<ProPackagesDto>>();
		List<ProPackagesDto> dataList =  proPackagesService.searchProSchoolPackage(customerId,timeDate);
		
		response.setData(dataList);
		
		return response;
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
	
	
	/**
	 * 
		 * 此方法描述的是：针对某一菜进行评价
		 * @author: cwftalus@163.com
		 * @version: 2016年5月23日 下午3:50:56
	 */
	@RequestMapping(value="comment")
	public void comment(EduParentPackCommentDto eduParentPackCommentDto){
		
		iEduParentPackCommentService.saveComment(eduParentPackCommentDto);
		
	}
	/**
	 * 
		 * 此方法描述的是：查询菜对应的点评信息
		 * @author: cwftalus@163.com
		 * @version: 2016年5月24日 上午9:26:45
	 */
	@RequestMapping(value="comment/list")
	public void searchComment(EduParentPackCommentDto eduParentPackCommentDto){
		
		iEduParentPackCommentService.searchComment(eduParentPackCommentDto);
		
	}
	
}

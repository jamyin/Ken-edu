package com.ssic.education.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssic.education.common.government.service.ProPackagesService;

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
	
	/**
	 * 
		 * 此方法描述的是：查询该家长关联下的学校的所有菜谱信息
		 * @author: cwftalus@163.com
		 * @version: 2016年5月23日 上午10:41:48
	 */
	public String search(){
		
		
		
		
		return "";
	}
	
}

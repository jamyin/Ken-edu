package com.ssic.education.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.utils.util.PropertiesUtils;

/**
 * 
	 * 此类描述的是：资质图片统一路口
	 * @author: cwftalus@163.com
	 * @version: 2016年5月29日 下午4:41:44
 */
@Controller
@RequestMapping(value="wap")
public class LoadImageController extends BaseController{

	@RequestMapping(value="loadImage")
	public ModelAndView loadImage(String absFilePath) {
		ModelAndView mv = getModelAndView();
		String lookUrl = PropertiesUtils.getProperty("upload.look.url");
		
		mv.addObject("filePath", lookUrl+absFilePath);
		mv.setViewName("img_alert");
		return mv;
	}

}

package com.ssic.education.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.education.utils.util.PropertiesUtils;

@Controller
@RequestMapping(value="wx")
public class WeixinController extends BaseController{

	@RequestMapping(value="index")
	public ModelAndView index(String urlType){
		String REDIRECT_URI = PropertiesUtils.getProperty("wwwdomain")+"index.htm";//添加关注
		if(Objects.equal(urlType, "1")){//菜谱查询
			REDIRECT_URI = PropertiesUtils.getProperty("wwwdomain")+"wap/school/index.htm";//菜谱查询
		}else if(Objects.equal(urlType, "2")){//我的关注
			REDIRECT_URI = PropertiesUtils.getProperty("wwwdomain")+"wap/follow/index.htm";//我的关注
		}else if(Objects.equal(urlType, "3")){//我的点评
			REDIRECT_URI = PropertiesUtils.getProperty("wwwdomain")+"wap/comment/index.htm";//我的点评
		}
		
		String appid = PropertiesUtils.getProperty("weixin.appId");
		
		String reqURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri="+REDIRECT_URI+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
		return new ModelAndView("redirect:"+reqURL);
	}

}

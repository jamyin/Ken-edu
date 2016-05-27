package com.ssic.education.wechat.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ssic.education.handle.service.AreaService;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.utils.HttpRequest;
import com.ssic.education.utils.constants.SessionConstants;
import com.ssic.education.utils.util.PropertiesUtils;
import com.ssic.education.wechat.dto.AccessToken;
import com.ssic.education.wechat.dto.WeixinUserDto;


public class BaseController {
	
	protected Logger logger = Logger.getLogger(BaseController.class);
	public static final String EDU_ALLAREAS = "edu_allAreas";
	public static final String EDU_ALLSCHOOLS = "edu_allSchools";
	
	
	public static final String parentId = "1";//家长Id 为微信openId 目前默认1 测试使用

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private AreaService areaService;
	@Autowired
	private EduSchoolService schoolService;
	
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		ModelAndView mv = new ModelAndView();
		
//		getopenId(getaccess_token());
		
		return mv;
	}
	
	//{"access_token":"ACCESS_TOKEN","expires_in":7200}
	public static String getaccess_token(){
		String url = PropertiesUtils.getProperty("weixin.access_token.url");
		String s = HttpRequest.sendGet(url, "grant_type=client_credential&appid=wx0e8ce00a08e68b04&secret=42c8dc75f48b03adb9d1031d051ab21a");
		Gson gson = new Gson();
		AccessToken at = gson.fromJson(s, AccessToken.class);
		return at.getAccess_token();
	}

	
	public static String getopenId(String access_token){
		//发送 GET 请求
		String url = PropertiesUtils.getProperty("weixin.UnionID.url");
		//#?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
        String s = HttpRequest.sendGet(url, "access_token="+access_token+"&openid=OPENID&lang=zh_CN");
        
		Gson gson = new Gson();
		WeixinUserDto at = gson.fromJson(s, WeixinUserDto.class);        
        return at.getOpenid();
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	public void setSession(String userId){
		getRequest().getSession().setAttribute(SessionConstants.LOGIN_USER_INFO,userId);
	}
	
	public void removeSession(){
		getRequest().getSession().removeAttribute(SessionConstants.LOGIN_USER_INFO);
	}
	
	public static void logBefore(Logger logger, String interfaceName){
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}
	
	public static void logAfter(Logger logger){
		logger.info("end");
		logger.info("");
	}
}
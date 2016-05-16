package com.ssic.education.government.controller;

import javax.servlet.http.HttpServletRequest;

import com.ssic.education.common.dto.EduAreaDto;
import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.education.common.government.service.AreaService;
import com.ssic.education.common.government.service.EduSchoolService;
import com.ssic.education.utils.model.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.utils.constants.SessionConstants;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseController {
	
	protected Logger logger = Logger.getLogger(BaseController.class);
	public static final String EDU_ALLAREAS = "edu_allAreas";
	public static final String EDU_ALLSCHOOLS = "edu_allSchools";

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
		return mv;
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

	public List<EduAreaDto> queryAllareas(){
		List<EduAreaDto> areas= null;
		if (null != redisTemplate.opsForValue().get(EDU_ALLAREAS)){
			areas = (List<EduAreaDto>)redisTemplate.opsForValue().get(EDU_ALLAREAS);
		}else{
			areas = areaService.queryAll();
			redisTemplate.opsForValue().set(EDU_ALLAREAS, areas, 1, TimeUnit.HOURS);
		}
		return areas;
	}

	public List<EduSchoolDto> queryAllschools(){
		List<EduSchoolDto> schools= null;
		if (null != redisTemplate.opsForValue().get(EDU_ALLSCHOOLS)){
			schools = (List<EduSchoolDto>)redisTemplate.opsForValue().get(EDU_ALLSCHOOLS);
		}else{
			schools = schoolService.queryAll();
			redisTemplate.opsForValue().set(EDU_ALLSCHOOLS, schools, 1, TimeUnit.HOURS);
		}
		return schools;
	}
}
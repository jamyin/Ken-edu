package com.ssic.education.government.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.EduAreaDto;
import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.EduUsersDto;
import com.ssic.education.government.controller.dto.MenuListDto;
import com.ssic.education.government.controller.dto.ParentMenuDto;
import com.ssic.education.handle.service.AreaService;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.EduUsersService;
import com.ssic.education.handle.service.IEduCommitteeService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.constants.SessionConstants;
import com.ssic.education.utils.util.FileUtils;
import com.ssic.education.utils.util.JsonUtil;


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
	
	@Autowired
	private EduUsersService eduUsersService;
	
	@Autowired
	private IEduCommitteeService iEduCommitteeService;
	
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("navList", getNavList());
		return mv;
	}

	public EduUsersDto getEduUsersDto(){
		EduUsersDto eduUsersDto = null;
		if(!Objects.equal(getSessionUserId(), null)){
			eduUsersDto = new EduUsersDto();
			eduUsersDto.setId(getSessionUserId());
			eduUsersDto =  eduUsersService.getUserInfo(eduUsersDto);
		}
		return eduUsersDto;
	}
	
	public List<MenuListDto> getNavList(){
		List<MenuListDto> navList = null;
		if(!Objects.equal(getSessionUserId(), null)){
			EduUsersDto eduUsersDto = new EduUsersDto();
			eduUsersDto.setId(getSessionUserId());
			eduUsersDto =  eduUsersService.getUserInfo(eduUsersDto);
//			String fileName = null;
			try {
//				if (StringUtils.isNotBlank(eduUsersDto.getSourceId()) && eduUsersDto.getSourceType() == DataStatus.DISABLED) {
//					EduCommitteeDto eduCommitteeDto = iEduCommitteeService.findById(eduUsersDto.getSourceId());
//					if (eduCommitteeDto.getType() == DataStatus.ENABLED) {
//						fileName ="0Menu.txt";
//					}
//					if (eduCommitteeDto.getType() == DataStatus.EVA_TWO) {
//						fileName =DataStatus.EVA_TWO+"menu.txt";
//					}
//				} else {
//					fileName = eduUsersDto.getSourceType()+"menu.txt";
//				}
				String fileName = eduUsersDto.getSourceType()+"menu.txt"; 
				String path = this.getClass().getClassLoader().getResource(fileName).getPath();;
				String menuList = FileUtils.readFileToString(new File(path));
				ParentMenuDto parentMenuDto = JsonUtil.getObjFromJson(menuList, ParentMenuDto.class);
				navList = parentMenuDto.getParentMenu();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return navList;
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
	
	public String getSessionUserId(){
		String userId = null;
		Object obj = getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
		if(!Objects.equal(obj, null)){
			userId = String.valueOf(obj);
		}
		return userId;
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
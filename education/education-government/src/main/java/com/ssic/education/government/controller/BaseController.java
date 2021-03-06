package com.ssic.education.government.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.educateion.common.dto.EduUsersDto;
import com.ssic.education.government.controller.dto.MenuListDto;
import com.ssic.education.government.controller.dto.ParentMenuDto;
import com.ssic.education.handle.service.EduUsersService;
import com.ssic.education.handle.service.IEduCommitteeService;
import com.ssic.education.handle.service.ITaskReceiveService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.constants.SessionConstants;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.FileUtils;
import com.ssic.education.utils.util.JsonUtil;
import com.ssic.education.utils.util.PropertiesUtils;


public class BaseController {
	
	protected Logger logger = Logger.getLogger(BaseController.class);
	public static final String EDU_ALLAREAS = "edu_allAreas";
	public static final String EDU_ALLSCHOOLS = "edu_allSchools";
	
	@Autowired
	private EduUsersService eduUsersService;
	
	@Autowired
	private IEduCommitteeService iEduCommitteeService;
	
	@Autowired
	private ITaskReceiveService iTaskReceiveService;
	
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("eduUsersDto", getEduUsersDto());
		mv.addObject("unreaded", getEduTaskReceiveSize());
		mv.addObject("navList", getNavList());
		mv.addObject("wwwdomain",PropertiesUtils.getProperty("upload.look.url"));
		return mv;
	}
	
	public long getEduTaskReceiveSize() {
		EduTaskReceiveDto eduTaskReceiveDto = new EduTaskReceiveDto();
		if (null != getEduUsersDto()) {
			String sourceId = getEduUsersDto().getSourceId();//用户所属教委 或学校
			eduTaskReceiveDto.setReceiveId(sourceId);
			eduTaskReceiveDto.setReadstat(DataStatus.DISABLED);
			List<EduTaskReceiveDto> results = iTaskReceiveService.searchEduTaskReceive(eduTaskReceiveDto);
			if (null != results) {
				return results.size();
			}
		}
		
		return 0;
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
			try {
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
}
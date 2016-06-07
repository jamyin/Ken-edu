package com.ssic.education.government.controller.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.mysql.fabric.xmlrpc.base.Array;
import com.ssic.educateion.common.dto.EduCanteenDto;
import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.EduUsersDto;
import com.ssic.educateion.common.dto.EduUsersRegDto;
import com.ssic.education.government.controller.BaseController;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.EduUsersService;
import com.ssic.education.handle.service.IEduCanteenService;
import com.ssic.education.handle.service.IEduCommitteeService;
import com.ssic.education.handle.service.IProLicenseService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.constants.SessionConstants;
import com.ssic.education.utils.digest.MD5Coder;
import com.ssic.education.utils.model.Response;

/**
 * 
	 * 此类描述的是：教委或学校用户操作
	 * @author: cwftalus@163.com
	 * @version: 2016年5月16日 上午11:15:42
 */
@Controller
@RequestMapping(value="user")
public class UserController extends BaseController{

	@Autowired
	private EduUsersService eduUsersService;
	
	
	@Autowired
	private IEduCommitteeService iEduCommitteeService;
	
	@Autowired
	private EduSchoolService eduSchoolService;
	
	@Autowired
	private IEduCanteenService iEduCanteenService;
	
	@Autowired
	private IProLicenseService iProLicenseService;
	
	@RequestMapping(value="oreg")
	public ModelAndView oreg(){
		ModelAndView mv = new ModelAndView();
		List<EduCommitteeDto> eduCommitteeDtos = iEduCommitteeService.findAll();
		mv.addObject("eduCommitteeDtos", eduCommitteeDtos);
		mv.setViewName("reg");	
		return mv;
	}
	
	@RequestMapping(value="regUser")	
	@ResponseBody
	public Response<String> regUser(EduUsersRegDto usersDto) throws Exception{
		Response<String> res = new Response<String>();
		boolean isTrue = eduUsersService.validateAccount(usersDto);
		if(isTrue){//新增
			usersDto.setPassword(MD5Coder.encodeMD5Hex(usersDto.getPassword()));
			EduUsersDto eduUsersDto = eduUsersService.save(usersDto);
			//setSession(eduUsersDto.getId());
			res.setStatus(DataStatus.HTTP_SUCCESS);
			res.setMessage("注册成功！");
		} else {
			res.setStatus(DataStatus.HTTP_FAILE);
			res.setMessage("用户名已被使用，注册失败！");
		}
		return res;
	}
	
	@RequestMapping(value="edit")	
	@ResponseBody
	public Response<String> edit(EduUsersRegDto usersDto) throws Exception{
		Response<String> res = new Response<String>();
		eduUsersService.edit(usersDto);
		res.setStatus(DataStatus.HTTP_SUCCESS);
		res.setMessage("用户名已被使用，注册失败！");
		return res;
	}
	
	@RequestMapping(value="reg")
	public ModelAndView reg(EduUsersRegDto usersDto){
		ModelAndView mv = getModelAndView();
		
		if(Objects.equal(getRequest().getMethod().toString(), RequestMethod.GET.toString())){
			mv.setViewName("reg");	
		}else{
			boolean isTrue = eduUsersService.validateAccount(usersDto);
			if(isTrue){//新增
				eduUsersService.save(usersDto);
			}else{//重复数据 错误提示 需要增加 异步处理
				
			}
//			EduUsersDto eduUser = eduUsersService.checkUser(usersDto);			
//			if(Objects.equal(eduUser, null)){
//				return new ModelAndView("redirect:/login.htm");
//			}
//			setSession(eduUser.getId());
//			return new ModelAndView("redirect:/main.htm");  
		}
		
		mv.setViewName("reg");
		return mv;
	}

	@RequestMapping(value = "/userInfo")
	public ModelAndView getUserInfo(HttpServletRequest request,HttpServletResponse response,HttpSession session,EduUsersDto usersDto) {
		ModelAndView mv = getModelAndView();
		String id = (String) getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
//		EduUsersDto usersdto = (EduUsersDto) session.getAttribute(SessionConstants.LOGIN_USER_INFO);
		EduUsersDto usersdto = getLoginUser(request, response, session, id);
		mv.addObject("userInfo", usersdto);
		mv.setViewName("/personalcenter");
		return mv;
	}
	
	@RequestMapping(value = "/oEditUserInfo")
	public ModelAndView oEditUserInfo(HttpServletRequest request,HttpServletResponse response,HttpSession session,EduUsersDto usersDto) throws Exception {
		ModelAndView mv = getModelAndView();
		String id = (String) getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
//		EduUsersDto usersdto = (EduUsersDto) session.getAttribute(SessionConstants.LOGIN_USER_INFO);
		EduUsersDto usersdto = getLoginUser(request, response, session, id);
		EduSchoolDto eduSchoolDto = new EduSchoolDto();
		EduCommitteeDto eduCommitteeDto = new EduCommitteeDto();
		EduCanteenDto eduCanteenDto = new EduCanteenDto();
		List<ProLicense> proLicenses = new ArrayList<>();
		if (null != usersdto && StringUtils.isNotBlank(usersdto.getId())) {
			if (usersdto.getSourceType() != DataStatus.ENABLED) {
				response.sendRedirect(request.getContextPath() + "userInfo.htm");
			}
			eduSchoolDto = eduSchoolService.findById(usersdto.getSourceId());
			if (null != eduSchoolDto && StringUtils.isNotBlank(eduSchoolDto.getCommitteeId())) {
				eduCommitteeDto = iEduCommitteeService.findById(eduSchoolDto.getCommitteeId());
			}
			EduCanteenDto eduCanteendto = new EduCanteenDto();
			eduCanteendto.setSchoolId(usersdto.getSourceId());
			eduCanteenDto = iEduCanteenService.searchEduCanteenDto(eduCanteendto);
			ProLicense proLicense = new ProLicense();
			proLicense.setCerSource((short)DataStatus.MANAGERTYPE);
			proLicense.setRelationId(eduCanteenDto.getId());
			proLicenses = iProLicenseService.lookImage(proLicense);
		} else {
			response.sendRedirect(request.getContextPath() + "/login.htm");
		}
		List<EduCommitteeDto> eduCommitteeDtos = iEduCommitteeService.findAll();
		mv.addObject("userInfo", usersdto);
		mv.addObject("eduSchoolDto", eduSchoolDto);
		mv.addObject("eduCommitteeDto", eduCommitteeDto);
		mv.addObject("eduCanteenDto", eduCanteenDto);
		mv.addObject("proLicenses", proLicenses);
		mv.addObject("eduCommitteeDtos", eduCommitteeDtos);
		mv.setViewName("/personalcenter_pinfo");
		return mv;
	}
	
	public EduUsersDto getLoginUser(HttpServletRequest request, HttpServletResponse response,
    		HttpSession session, String id){
    	if(id==null){
    		try {
				response.sendRedirect(request.getContextPath() + "/login.htm");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	EduUsersDto usersDto = new EduUsersDto();
    	usersDto.setId(id);
    	return eduUsersService.getUserInfo(usersDto);
    }
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public Response<String> update(HttpServletRequest request, HttpServletResponse response,
    		HttpSession session,EduUsersDto usersDto) throws Exception {
		Response<String> res = new Response<String>();
		String md5oldPwd = MD5Coder.encodeMD5Hex(usersDto.getPassword());
		String md5oldOldPwd = MD5Coder.encodeMD5Hex(usersDto.getOldpassword());
		String id = (String) getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
		EduUsersDto usersdto = getLoginUser(request, response, session, id);
		if (StringUtils.isNotBlank(usersdto.getId()) && StringUtils.isNotBlank(usersdto.getPassword())) {
			if (!md5oldOldPwd.equals(usersdto.getPassword())) {
				res.setStatus(DataStatus.HTTP_FAILE);
				res.setMessage("原密码不正确请重新输入！");
				return res;
			}
		}
		usersDto.setPassword(md5oldPwd);
		usersDto.setId(usersdto.getId());
		Integer result = eduUsersService.update(usersDto);
		if (result == DataStatus.ENABLED) {
			res.setStatus(DataStatus.HTTP_SUCCESS);
			res.setMessage("更新成功！");
		}if (result == DataStatus.DISABLED) {
			res.setStatus(DataStatus.HTTP_FAILE);
			res.setMessage("更新失败！");
		}
		return res;
	}
}

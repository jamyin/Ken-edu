package com.ssic.education.government.controller.users;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.education.government.controller.BaseController;
import com.ssic.education.government.dto.EduUsersDto;
import com.ssic.education.government.service.EduUsersService;
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
	
	@RequestMapping(value="reg")
	public ModelAndView reg(EduUsersDto usersDto){
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
		String id = (String) getRequest().getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
		EduUsersDto usersdto = getLoginUser(request, response, session, id);
		usersDto.setPassword(md5oldPwd);
		usersDto.setId(usersdto.getId());
		Integer result = eduUsersService.update(usersDto);
		if (result == DataStatus.ENABLED) {
			res.setStatus(DataStatus.HTTP_SUCCESS);
			res.setMessage("更新成功！");
		}if (result == DataStatus.DISABLED) {
			res.setStatus(DataStatus.HTTP_FAILE);
			res.setMessage("更新成功！");
		}
		return res;
	}
}

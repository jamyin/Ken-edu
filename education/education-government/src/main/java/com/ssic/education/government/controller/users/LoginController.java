package com.ssic.education.government.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.EduUsersDto;
import com.ssic.education.government.controller.BaseController;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.EduUsersService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.Response;
/**
 * 
	 * 此类描述的是：用户登录
	 * @author: cwftalus@163.com
	 * @version: 2016年5月12日 下午2:50:53
 */
@Controller
public class LoginController extends BaseController{

	@Autowired
	private EduUsersService eduUsersService;
	
	@Autowired
	private EduSchoolService eduSchoolService;
	
	@RequestMapping(value="login")
	public ModelAndView login(EduUsersDto usersDto) {
		ModelAndView mv = getModelAndView();
		if(Objects.equal(getRequest().getMethod().toString(), RequestMethod.GET.toString())){
			mv.setViewName("/login");	
		}else{
			EduUsersDto eduUser = eduUsersService.checkUser(usersDto);			
			if(Objects.equal(eduUser, null)){
				return new ModelAndView("redirect:/login.htm");
			}
			setSession(eduUser.getId());		
			return new ModelAndView("redirect:/main.htm");  
		}
		return mv;
	}
	
	@RequestMapping(value="login_ajax")
	@ResponseBody
	public Response<String> login_ajax(EduUsersDto usersDto) {
		Response<String> res = new Response<String>();
			EduUsersDto eduUser = eduUsersService.checkUser(usersDto);			
			if(Objects.equal(eduUser, null)){
				res.setStatus(DataStatus.HTTP_FAILE);
				res.setMessage("用户名或密码错误");
			}
			else{
				if (null != eduUser.getSourceType() && eduUser.getSourceType() == DataStatus.ENABLED) {
					EduSchoolDto eduSchoolDto = eduSchoolService.findById(eduUser.getSourceId());
					if (eduSchoolDto.getReviewed() == DataStatus.ENABLED) {
						setSession(eduUser.getId());
					}else {
						res.setStatus(DataStatus.HTTP_FAILE);
						res.setMessage("用户还未审批无法登陆！");
					}
				}	
				if (null != eduUser.getSourceType() && eduUser.getSourceType() == DataStatus.DISABLED) {
					setSession(eduUser.getId());
				}
			}			  
		return res;
	}
	
	@RequestMapping(value="login_out")
	public ModelAndView loginOut(EduUsersDto usersDto) {
		removeSession();
		return new ModelAndView("redirect:/login.htm");
	}
	
}

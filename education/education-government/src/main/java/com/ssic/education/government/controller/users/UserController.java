package com.ssic.education.government.controller.users;

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
	public ModelAndView getUserInfo(EduUsersDto usersDto) {
		ModelAndView mv = getModelAndView();
		EduUsersDto usersdto = eduUsersService.getUserInfo(usersDto);
		mv.setViewName("/userInfo");
		mv.addObject("userInfo", usersdto);
		mv.setViewName("/userInfo");
		return mv;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public Response<String> update(EduUsersDto usersDto) {
		Response<String> res = new Response<String>();
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

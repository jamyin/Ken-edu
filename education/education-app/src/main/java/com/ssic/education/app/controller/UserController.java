package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.service.IEduAppUsersService;
import com.ssic.util.constants.DataStatus;
import com.ssic.util.model.Response;

/**		
 * <p>Title: UserController </p>
 * <p>Description: 用户接口控制器</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月20日 上午10:05:54	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月20日 上午10:05:54</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	@Autowired
	private IEduAppUsersService userService;

	@RequestMapping(value = "/applogin/{account}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public Response<EduAppUserDto> applogin(@PathVariable("account") String account, @PathVariable("pwd") String password) {
		EduUsersInfoDto user = new EduUsersInfoDto();
		user.setUserAccount(account);
		user.setPassword(password);
		Response<EduAppUserDto> result = new Response<EduAppUserDto>();
		EduAppUserDto userdto = userService.appLogin(user);
		if (userdto != null) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("登录成功！");
			result.setData(userdto);
			return result;
		} else
			result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("登录失败，请检查用户名密码！");
		return result;
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Response<EduAppUserDto> login(@RequestParam(required = true) String account, @RequestParam(required = true) String password) {
		EduUsersInfoDto user = new EduUsersInfoDto();
		Response<EduAppUserDto> result = new Response<EduAppUserDto>();
		user.setUserAccount(account);
		user.setPassword(password);
		System.out.println(user);
		EduAppUserDto userdto = userService.appLogin(user);

		result.setData(userdto);
		if (userdto != null) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("登录成功！");
			result.setData(userdto);
			return result;
		} else
			result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("登录失败，请检查用户名密码！");
		return result;
	}
}

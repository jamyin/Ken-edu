package com.ssic.education.app.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.AppEduUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.dto.AppProUserDto;
import com.ssic.education.app.interceptor.AccessRequired;
import com.ssic.education.app.service.IAppUsersService;
import com.ssic.education.handle.pojo.ProUsers;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.redis.WdRedisDao;

/**		
 * <p>Title: UserController </p>
 * <p>Description: APP用户接口控制器</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月20日 上午10:05:54	
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/user")
public class AppUserController extends BaseController {
	@Autowired
	private IAppUsersService appUserService;
	@Autowired
	private WdRedisDao<AppEduUserDto> eduRedisdao;
	@Autowired
	private WdRedisDao<AppProUserDto> proRedisdao;

	/**
	 * 教委APP用户登录接口
	 * @param account 账户
	 * @param password 密码
	 * @return 用户信息
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Response<AppEduUserDto> login(@RequestParam(required = true) String account, @RequestParam(required = true) String password) {
		EduUsersInfoDto user = new EduUsersInfoDto();
		Response<AppEduUserDto> result = new Response<AppEduUserDto>();
		user.setUserAccount(account);
		try {
			int num=account.getBytes("utf-8").length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		user.setPassword(password);
		AppEduUserDto userdto = appUserService.eduLogin(user);
		result.setData(userdto);
		if (userdto != null) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("登录成功！");
			result.setData(userdto);
			return result;
		} else {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("登录失败，请检查用户名密码！");
		}
		return result;
	}

	/**
	 * 教委APP用户修改密码接口
	 * @param oldPwd 旧密码
	 * @param account 账户
	 * @param newPwd 新密码
	 * @return 成功状态
	 */
	@RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
	@AccessRequired
	public @ResponseBody Response<String> modifyPwd(String account, String oldPwd, String newPwd) {
		Response<String> result = new Response<String>();
		if (oldPwd.equals(newPwd)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("两次密码一样");
		} else {
			if (appUserService.eduUpdatePwd(account, oldPwd, newPwd) == 1) {
				result.setStatus(DataStatus.HTTP_SUCCESS);
				result.setMessage("修改成功！");
			} else {
				result.setStatus(DataStatus.HTTP_FAILE);
				result.setMessage("修改失败，原密码有误");
			}
		}
		return result;
	}

	/**
	 * 教委APP用户注销接口
	 * @return
	 */
	@RequestMapping(value = "/eduLogout/{token}", method = RequestMethod.GET)
	public @ResponseBody void eduLogout(@PathVariable("token") String token) {
		this.appUserService.eduLogout(token);
	}

	/**
	 * 团餐公司APP登录接口
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/proLogin", method = RequestMethod.POST)
	public @ResponseBody Response<AppProUserDto> proLogin(@RequestParam(required = true) String account, @RequestParam(required = true) String password) {
		Response<AppProUserDto> result = new Response<AppProUserDto>();
		AppProUserDto userdto = appUserService.proLogin(account,password);
		result.setData(userdto);
		if (userdto != null) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("登录成功！");
			result.setData(userdto);
			return result;
		} else {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("登录失败，请检查用户名密码！");
		}
		return result;
	}

	/**
	 * 团餐公司APP修改密码接口
	 * @param account
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	@RequestMapping(value = "/proModifyPwd", method = RequestMethod.POST)
	@AccessRequired
	public @ResponseBody Response<String> proModifyPwd(String account, String oldPwd, String newPwd) {
		Response<String> result = new Response<String>();
		if (oldPwd.equals(newPwd)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("两次密码一样");
		} else {
			if (appUserService.proUpdatePwd(account, oldPwd, newPwd) == 1) {
				result.setStatus(DataStatus.HTTP_SUCCESS);
				result.setMessage("修改成功！");
			} else {
				result.setStatus(DataStatus.HTTP_FAILE);
				result.setMessage("修改失败，原密码有误");
			}
		}
		return result;
	}

	/**
	 * 团餐公司APP注销接口
	 * @return
	 */
	@RequestMapping(value = "/proLogout/{token}", method = RequestMethod.GET)
	public @ResponseBody void proLogout(@PathVariable("token") String token) {
		this.appUserService.proLogout(token);
	}
}

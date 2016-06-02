package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.service.IAppUsersService;
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
	private WdRedisDao<EduAppUserDto> redisdao;

	/**
	 * 教委APP用户登录接口
	 * @param account 账户
	 * @param password 密码
	 * @return 用户信息
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Response<EduAppUserDto> login(@RequestParam(required = true) String account, @RequestParam(required = true) String password) {
		EduUsersInfoDto user = new EduUsersInfoDto();
		Response<EduAppUserDto> result = new Response<EduAppUserDto>();
		user.setUserAccount(account);
		user.setPassword(password);
		EduAppUserDto userdto = appUserService.appLogin(user);
		result.setData(userdto);
		if (userdto != null) {
			redisdao.set(userdto, 60);
			EduAppUserDto g = redisdao.get(userdto.getToken(), EduAppUserDto.class);
			System.out.println(g.getName() + g.getToken());
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
	@ResponseBody
	public Response<String> modifyPwd(String account, String oldPwd, String newPwd) {
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
	@RequestMapping(value = "/eduLogout", method = RequestMethod.GET)
	@ResponseBody
	public Response<String> eduLogout() {
		return null;
	}

	/**
	 * 团餐公司APP登录接口
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/proLogin", method = RequestMethod.POST)
	@ResponseBody
	public Response<EduAppUserDto> proLogin(@RequestParam(required = true) String account, @RequestParam(required = true) String password) {
		return null;
	}

	/**
	 * 团餐公司APP修改密码接口
	 * @param account
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	@RequestMapping(value = "/proModifyPwd", method = RequestMethod.POST)
	@ResponseBody
	public Response<String> proModifyPwd(String account, String oldPwd, String newPwd) {
		return null;
	}

	/**
	 * 团餐公司APP注销接口
	 * @return
	 */
	@RequestMapping(value = "/proLogout", method = RequestMethod.GET)
	@ResponseBody
	public Response<String> proLogout() {
		return null;
	}
}

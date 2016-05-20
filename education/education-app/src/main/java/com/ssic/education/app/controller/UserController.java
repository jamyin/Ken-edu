package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.EduAppUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.app.service.IEduAppUsersService;
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
public class UserController {
	@Autowired
	private IEduAppUsersService userService;

	@RequestMapping(value = "/applogin", method = RequestMethod.POST)
	@ResponseBody
	public Response<EduAppUserDto> getMaterialInfo(EduUsersInfoDto user) {
		Response<EduAppUserDto> result = new Response<EduAppUserDto>();
		EduAppUserDto userdto = userService.appLogin(user);
		userdto.setTonke("asdagasdgdfgdfhgdf454");
		result.setData(userdto);
		return result;
	}
}

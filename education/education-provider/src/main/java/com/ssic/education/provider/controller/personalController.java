package com.ssic.education.provider.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.pageModel.SessionInfo;
import com.ssic.education.provider.service.UserServiceI;
import com.ssic.education.provider.util.ConfigUtil;

@RequestMapping("personalController")
@Controller
public class personalController {
	@Autowired
	private UserServiceI userService;
	/**
	 * 跳转到个人中心页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "personal/personal";
	}

	/**
	 * 获取用户数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(TImsUsersDto user, PageHelper ph ,HttpServletRequest request) {
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(ConfigUtil.SESSIONINFONAME);
		user.setSourceId(info.getSupplierId());
		user.setId(info.getId());
		return userService.dataGrid(user, ph);   
	}
	
	
	
	/**
	 * 跳转到用户修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/personalEdit")
	public String editPage(HttpServletRequest request, String id) {
		TImsUsersDto u = userService.getUser(id);
		/*if(u.getIsAdmin()==1  && u.getIsAdmin()!=null){
			u.setUserType(null);
		}*/
	    request.setAttribute("user", u);
	    
        return "personal/personalEdit";
	}

	
	
	/**
	 * 跳转到编辑自己的密码页面
	 * 
	 * @return
	 */
	@RequestMapping("/editCurrentUserPwdPage")
	public String editCurrentUserPwdPage() {
		return "personal/userEditPwd";
	}

	/**
	 * 修改自己的密码
	 * 
	 * @param session
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/editCurrentUserPwd")
	@ResponseBody
	public Json editCurrentUserPwd(HttpSession session, String oldPwd, String pwd) {
		Json j = new Json();
		if(pwd.length()<6){
			j.setSuccess(false);
			j.setMsg("密码长度不能小于6位");
			return j;
		}
		if (session != null) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.SESSIONINFONAME);
			if (sessionInfo != null) {
				if (userService.editCurrentUserPwd(sessionInfo, oldPwd, pwd)) {
					j.setSuccess(true);
					j.setMsg("编辑密码成功，下次登录生效！");
				} else {
					j.setMsg("原密码错误！");
				}
			} else {
				j.setMsg("登录超时，请重新登录！");
			}
		} else {
			j.setMsg("登录超时，请重新登录！");
		}
		return j;
	}
	
	
	
}

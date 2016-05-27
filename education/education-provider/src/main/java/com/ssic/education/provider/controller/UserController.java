package com.ssic.education.provider.controller;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.handle.service.ISupplierService;
//192.168.1.231/group-one/education.git
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.pageModel.SessionInfo;
import com.ssic.education.provider.pageModel.Tree;
import com.ssic.education.provider.pageModel.User;
import com.ssic.education.provider.service.ResourceServiceI;
import com.ssic.education.provider.service.RoleServiceI;
import com.ssic.education.provider.service.UserServiceI;
import com.ssic.education.provider.util.ConfigUtil;
import com.ssic.education.utils.constants.DataStatus;

/**
 * 用户控制器
 * 
 * @author 刘博
 * 
 */
@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {

	@Autowired
	private UserServiceI userService;

	@Autowired
	private RoleServiceI roleService;

	@Autowired
	private ResourceServiceI resourceService;
	
	@Autowired
	private ISupplierService iSupplierService;
	
	

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            用户对象
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Json login(TImsUsersDto usersDto, HttpSession session, HttpServletRequest request) {
		Json j = new Json();
		TImsUsersDto u = userService.login(usersDto);
		if (u != null) {
			//系统管理员不需要判断
			if(!Objects.equal(u.getIsAdmin(),DataStatus.ENABLED)){
//				u.getSourceId();//用户对应的供应商Id 查看该供应商是否审核通过
				ProSupplierDto proSupplierDto = iSupplierService.searchProSupplierById(u.getSourceId());				
				if(!Objects.equal(proSupplierDto.getReviewed(), Byte.valueOf("1"))){
					j.setMsg("供应商信息审核未通过,请通过之后再进行登陆");
					return j;
				}			
			}			
			
			j.setSuccess(true);
			j.setMsg("登陆成功！");

			
			//登录用户信息存入Session
			SessionInfo sessionInfo = new SessionInfo();
			BeanUtils.copyProperties(u, sessionInfo);
//			sessionInfo.setIp(IpUtil.getIpAddr(request));
			sessionInfo.setSupplierId(u.getSourceId());//sourceId 即供应商Id
			sessionInfo.setResourceList(userService.resourceList(u.getId()));
			session.setAttribute(ConfigUtil.SESSIONINFONAME, sessionInfo);
			request.getSession(true).setAttribute("user", u); 
			//用户信息也返回到客户端
			j.setObj(sessionInfo);
		} else {
			j.setMsg("用户名或密码错误！");
		}
		return j;
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/reg")
	public Json reg(TImsUsersDto user) {
		Json j = new Json();
		try {
			userService.reg(user);
			j.setSuccess(true);
			j.setMsg("注册成功！新注册的用户没有任何权限，请让管理员赋予权限后再使用本系统！");
			j.setObj(user);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public Json logout(HttpSession session) {
		Json j = new Json();
		if (session != null) {
			session.invalidate();
		}
		j.setSuccess(true);
		j.setMsg("注销成功！");
		return j;
	}

	/**
	 * 跳转到用户管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "user/user";
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
		return userService.dataGrid(user, ph);   
	}

	/**
	 * 跳转到添加用户页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		User u = new User();
		u.setId(UUID.randomUUID().toString());
		request.setAttribute("user", u);
		return "user/userAdd";
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(TImsUsersDto user,HttpServletRequest request) {
		Json j = new Json();
		if (user.getPassword().length()<6){
			j.setSuccess(false);
			j.setMsg("密码长度不能小于六位");
			return j;
		}
		if(user.getName().length()>10){
			j.setSuccess(false);
			j.setMsg("用户名称不能大于10位");
			return j;
		}
		if(!user.getPassword().equals(user.getPassword2())){
			j.setSuccess(false);
			j.setMsg("两次密码输入不同");
			return j;
		}
		   Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");		  
		   Matcher isMail = p.matcher(user.getEmail());
		   if(!StringUtils.isEmpty(user.getEmail())&&!isMail.matches()){
			   j.setSuccess(false);
			   j.setMsg("邮箱不合法");
			   return j;
		   }
		   Pattern p2 = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		   Matcher isMail2 = p2.matcher(user.getUserNo());
		   if(!StringUtils.isEmpty(user.getUserNo())&&!isMail2.matches()){
			   j.setSuccess(false);
			   j.setMsg("手机不合法");
			   return j;
		   }

	
		try {
			SessionInfo info = (SessionInfo) request.getSession().getAttribute(ConfigUtil.SESSIONINFONAME);
			user.setSourceId(info.getSupplierId());
				//添加t_admin_uses
				userService.add(user);
			
			j.setSuccess(true);
			j.setMsg("添加成功！");
			j.setObj(user);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 跳转到用户修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		TImsUsersDto u = userService.getUser(id);
		if(u.getIsAdmin()==1){
			u.setUserType(null);
		}
	    request.setAttribute("user", u);
	    
        return "user/userEdit";
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(TImsUsersDto user) {
		Json j = new Json();
		
		if (user.getPassword().length()<6){
			j.setSuccess(false);
			j.setMsg("密码长度不能小于六位");
			return j;
		}
		if(user.getName().length()>10){
			j.setSuccess(false);
			j.setMsg("用户名称不能大于10位");
			return j;
		}
		if(!user.getPassword().equals(user.getPassword2())){
			j.setSuccess(false);
			j.setMsg("两次密码输入不同");
			return j;
		}

		   Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");		  
		   Matcher isMail = p.matcher(user.getEmail());
		   if(!StringUtils.isEmpty(user.getEmail())&&!isMail.matches()){
			   j.setSuccess(false);
			   j.setMsg("邮箱不合法");
			   return j;
		   }
		   Pattern p2 = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		   Matcher isMail2 = p2.matcher(user.getUserNo());
		   if(!StringUtils.isEmpty(user.getUserNo())&&!isMail2.matches()){
			   j.setSuccess(false);
			   j.setMsg("手机不合法");
			   return j;
		   }
		try {
			
			userService.edit(user);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
			j.setObj(user);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.SESSIONINFONAME);
		Json j = new Json();
		if (id != null && !id.equalsIgnoreCase(sessionInfo.getId())) {// 不能删除自己
			userService.delete(id);
			j.setMsg("不能删除自己！");
			j.setSuccess(false);
			return j;
		}
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 批量删除用户
	 * 
	 * @param ids
	 *            ('0','1','2')
	 * @return
	 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public Json batchDelete(String ids, HttpSession session) {
		Json j = new Json();
		if (ids != null && ids.length() > 0) {
			for (String id : ids.split(",")) {
				if (id != null) {
					this.delete(id, session);
				}
			}
		}
		j.setMsg("批量删除成功！");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 跳转到用户授权页面
	 * 
	 * @return
	 */
	@RequestMapping("/grantPage")
	public String grantPage(String ids, HttpServletRequest request) {
		request.setAttribute("ids", ids);
		if (ids != null && !ids.equalsIgnoreCase("") && ids.indexOf(",") == -1) {
			TImsUsersDto u = userService.getUser(ids);
			String result = userService.findUserRole(ids);
			
			request.setAttribute("user", u);
		}
		return "admin/userGrant";
	}


	/**
	 * 跳转到编辑用户密码页面
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/editPwdPage")
	public String editPwdPage(String id, HttpServletRequest request) {
		TImsUsersDto u = userService.getUser(id);
		request.setAttribute("user", u);
		return "admin/userEditPwd";
	}

	/**
	 * 编辑用户密码
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/editPwd")
	@ResponseBody
	public Json editPwd(TImsUsersDto user) {
		Json j = new Json();
		if(user.getPassword().length()<6){
			j.setSuccess(false);
			j.setMsg("密码不能小于6位");
			return j;
		}
		userService.editPwd(user);
		j.setSuccess(true);
		j.setMsg("编辑成功！");
		return j;
	}

	/**
	 * 跳转到编辑自己的密码页面
	 * 
	 * @return
	 */
	@RequestMapping("/editCurrentUserPwdPage")
	public String editCurrentUserPwdPage() {
		return "user/userEditPwd";
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

	/**
	 * 跳转到显示用户角色页面
	 * 
	 * @return
	 */
	@RequestMapping("/currentUserRolePage")
	public String currentUserRolePage(HttpServletRequest request, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.SESSIONINFONAME);
		request.setAttribute("userRoles", JSON.toJSONString(roleService.tree(sessionInfo)));
		return "user/userRole";
	}

	/**
	 * 跳转到显示用户权限页面
	 * 
	 * @return
	 */
	@RequestMapping("/currentUserResourcePage")
	public String currentUserResourcePage(HttpServletRequest request, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.SESSIONINFONAME);
		request.setAttribute("userResources", JSON.toJSONString(resourceService.allTree(sessionInfo)));
		return "user/userResource";
	}

	/**
	 * 用户登录时的autocomplete
	 * 
	 * @param q
	 *            参数
	 * @return
	 */
	@RequestMapping("/loginCombobox")
	@ResponseBody
	public List<User> loginCombobox(String q) {
		return userService.loginCombobox(q);
	}

	/**
	 * 用户登录时的combogrid
	 * 
	 * @param q
	 * @param ph
	 * @return
	 */
	@RequestMapping("/loginCombogrid")
	@ResponseBody
	public DataGrid loginCombogrid(String q, PageHelper ph) {
		return userService.loginCombogrid(q, ph);
	}
	
	/**
	 * 用户tree
	 * 
	 * @return
	 */
	@RequestMapping("/userTree")
	@ResponseBody
	public List<Tree> userTree(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.SESSIONINFONAME);
		return userService.findUserTree(sessionInfo.getId());
	}

}

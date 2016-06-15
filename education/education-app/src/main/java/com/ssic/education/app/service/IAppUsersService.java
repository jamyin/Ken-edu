package com.ssic.education.app.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.ssic.education.app.dto.AppEduUserDto;
import com.ssic.education.app.dto.AppProUserDto;
import com.ssic.education.app.dto.EduUsersInfoDto;
import com.ssic.education.handle.pojo.ProUsers;

/**
 * 
 * @author SeanYoung
 *
 */
public interface IAppUsersService {

	/**
	 * 教委用户登录
	 * @param user 账户密码
	 * @return
	 */
	public AppEduUserDto eduLogin(EduUsersInfoDto user);

	/**
	 * 团餐用户登录
	 * @param user 账户密码
	 * @return
	 */
	public AppProUserDto proLogin(ProUsers user);

	/**
	 * 团餐用户登录
	 * @param account
	 * @param password
	 * @return
	 */
	public AppProUserDto proLogin(String account, String password);

	/**
	 * 教委用户修改密码
	 * @param account
	 * @param oldPwd
	 * @param newPwd
	 * @return 
	 */
	public int eduUpdatePwd(String account, String oldPwd, String newPwd);

	/**
	 * 团餐用户修改密码
	 * @param account
	 * @param oldPwd
	 * @param newPwd
	 * @return 
	 */
	public int proUpdatePwd(String account, String oldPwd, String newPwd);

	/**
	 * 团餐用户注销
	 * @param token
	 */
	public void eduLogout(String token);

	/**
	 * 教委用户注销
	 * @param token
	 */
	public void proLogout(String token);
}

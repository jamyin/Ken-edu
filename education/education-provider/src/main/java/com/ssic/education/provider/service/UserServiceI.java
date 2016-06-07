package com.ssic.education.provider.service;

import java.util.List;

import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.pageModel.SessionInfo;

/**
 * 用户Service
 * 
 * @author 刘博
 * 
 */
public interface UserServiceI {


	public List<TImsUsersDto> findAllDriver(String sourceId);

	public TImsUsersDto login(TImsUsersDto user);

	public void reg(TImsUsersDto user) throws Exception;

	public DataGrid dataGrid(TImsUsersDto user, PageHelper ph);

	public void add(TImsUsersDto user) throws Exception;

	public void edit(TImsUsersDto user) throws Exception;

	public void delete(String id);

	public void editPwd(TImsUsersDto user);

	public boolean editCurrentUserPwd(SessionInfo sessionInfo, String oldPwd,
			String pwd);

	public int vailUserAccount(TImsUsersDto userDto);

	public TImsUsersDto getUser(String id);

	public void addImsUsers(TImsUsersDto user);
	
	public int findByNameCount(TImsUsersDto user);
}

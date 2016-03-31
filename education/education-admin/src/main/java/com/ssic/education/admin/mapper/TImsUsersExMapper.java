package com.ssic.education.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.admin.dto.TImsUsersDto;
import com.ssic.education.admin.pageModel.PageHelper;
import com.ssic.education.admin.pojo.Users;
import com.ssic.education.common.dto.ProjectDto;

public interface TImsUsersExMapper {

	 List<TImsUsersDto> findBy(@Param("user")TImsUsersDto user);
	 
	 void insertBy(@Param("users")Users users);
	 
	 int findCountBy(@Param("user")TImsUsersDto user);
	 
	 List<TImsUsersDto> findPageBy(@Param("user")TImsUsersDto user,@Param("ph") PageHelper ph);

	void updateBy(@Param("user")TImsUsersDto user);
	void updateDelBy(@Param("userId")String id);
	void updatePwd(@Param("user")TImsUsersDto user);
	
	void updateDelByDept(@Param("deptId")String id);
	
	void addImsUsers(@Param("users")Users users);

	List<ProjectDto> findByUserId(String userId);
}

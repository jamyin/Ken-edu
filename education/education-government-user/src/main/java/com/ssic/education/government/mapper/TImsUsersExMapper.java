package com.ssic.education.government.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.government.dto.TImsUsersDto;
import com.ssic.education.government.pageModel.PageHelper;
import com.ssic.education.government.pojo.EduUsers;

public interface TImsUsersExMapper {

	 List<TImsUsersDto> findBy(@Param("user")TImsUsersDto user);
	 
	 void insertBy(@Param("users")EduUsers users);
	 
	 int findCountBy(@Param("user")TImsUsersDto user);
	 
	 List<TImsUsersDto> findPageBy(@Param("user")TImsUsersDto user,@Param("ph") PageHelper ph);

	void updateBy(@Param("user")TImsUsersDto user);
	void updateDelBy(@Param("userId")String id);
	void updatePwd(@Param("user")TImsUsersDto user);
	
	void updateDelByDept(@Param("deptId")String id);
	
	void addImsUsers(@Param("users")EduUsers users);

//	List<ProjectDto> findByUserId(String userId);
}

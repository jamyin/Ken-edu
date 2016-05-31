package com.ssic.education.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.pojo.ProUsers;

public interface TImsUsersExMapper {

	 List<TImsUsersDto> findBy(@Param("user")TImsUsersDto user);
	 
	 void insertBy(@Param("users")ProUsers users);
	 
	 int findCountBy(@Param("user")TImsUsersDto user);
	 
	 List<TImsUsersDto> findPageBy(@Param("user")TImsUsersDto user,@Param("ph") PageHelper ph);

	void updateBy(@Param("user")TImsUsersDto user);
	void updateDelBy(@Param("userId")String id);
	void updatePwd(@Param("user")TImsUsersDto user);
	
	void updateDelByDept(@Param("deptId")String id);
	
	void addImsUsers(@Param("users")ProUsers users);

	List<TImsUsersDto> findAllDriver(String sourceId);

	int findByNameCount(@Param("users")TImsUsersDto user);

//	List<ProjectDto> findByUserId(String userId);
}

package com.ssic.test.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.test.common.dto.PageHelperDto;
import com.ssic.test.common.dto.ProjectDto;
import com.ssic.test.common.dto.ProjectUsersDto;


public interface ProjectExMapper {
	
	List<ProjectDto> findAll();

	ProjectDto findById(@Param("id")String id);
	
	List<ProjectDto> findByIdName(@Param("project") ProjectDto projectDto);
	
	void insert(@Param("project")ProjectDto projectDto);
	
	void update(@Param("project")ProjectDto projectDto);
	
	void deleteById(@Param("project")ProjectDto projectDto);
	
	List<ProjectDto> findByIdNameAll(@Param("project") ProjectDto projectDto,@Param("page")PageHelperDto ph);
	
	int findCount(@Param("project") ProjectDto projectDto);
	
	ProjectUsersDto findByUserID(@Param("userId") String userId);

}

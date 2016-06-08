package com.ssic.education.handle.mapper;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.handle.dto.EduParentPackCommentDto;


public interface EduParentPackCommentExMapper {
	
	Object packagesComment(@Param("eduParentPackCommentDto")EduParentPackCommentDto eduParentPackCommentDto);

	Integer countPackageStar(@Param("packageId") String packageId);



}

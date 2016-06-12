package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.education.handle.dto.EduParentPackCommentDto;

public interface IEduParentPackCommentService {

	int saveComment(EduParentPackCommentDto eduParentPackCommentDto);

	List<EduParentPackCommentDto> searchComment(EduParentPackCommentDto eduParentPackCommentDto);

	Integer countPackageStar(String packageId);

	int updateComment(EduParentPackCommentDto eduParentPackCommentDto);

}

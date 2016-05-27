package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.education.handle.dto.EduParentPackCommentDto;

public interface IEduParentPackCommentService {

	void saveComment(EduParentPackCommentDto eduParentPackCommentDto);

	List<EduParentPackCommentDto> searchComment(EduParentPackCommentDto eduParentPackCommentDto);

}

package com.ssic.education.handle.service;

import com.ssic.education.handle.dto.EduParentPackCommentDto;

public interface IEduParentPackCommentService {

	void saveComment(EduParentPackCommentDto eduParentPackCommentDto);

	void searchComment(EduParentPackCommentDto eduParentPackCommentDto);

}

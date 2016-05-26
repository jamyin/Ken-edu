package com.ssic.education.edu.service;

import com.ssic.education.edu.dto.EduParentPackCommentDto;

public interface IEduParentPackCommentService {

	void saveComment(EduParentPackCommentDto eduParentPackCommentDto);

	void searchComment(EduParentPackCommentDto eduParentPackCommentDto);

}

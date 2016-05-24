package com.ssic.education.wecaht.handle.service;

import com.ssic.education.wecaht.handle.dto.EduParentPackCommentDto;

public interface IEduParentPackCommentService {

	void saveComment(EduParentPackCommentDto eduParentPackCommentDto);

	void searchComment(EduParentPackCommentDto eduParentPackCommentDto);

}

package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.EduSupplierReviewDto;

public interface IEduSupplierReviewService {
	public void saveSupplierReview(EduSupplierReviewDto eduSupplierReviewDto);
	
	public void saveSupplierReview(List<EduSupplierReviewDto> eduSupplierReviewList);
}

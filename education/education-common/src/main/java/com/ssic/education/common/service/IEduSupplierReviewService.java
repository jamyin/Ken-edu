package com.ssic.education.common.service;

import java.util.List;

import com.ssic.education.common.dto.EduSupplierReviewDto;

public interface IEduSupplierReviewService {
	public void saveSupplierReview(EduSupplierReviewDto eduSupplierReviewDto);
	
	public void saveSupplierReview(List<EduSupplierReviewDto> eduSupplierReviewList);
}

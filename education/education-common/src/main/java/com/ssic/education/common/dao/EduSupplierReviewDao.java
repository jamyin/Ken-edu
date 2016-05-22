package com.ssic.education.common.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.EduSupplierReviewDto;
import com.ssic.education.common.mapper.EduSupplierReviewMapper;
import com.ssic.education.common.pojo.EduSupplierReview;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;

@Repository
public class EduSupplierReviewDao extends MyBatisBaseDao<EduSupplierReview> {

	@Getter
	@Autowired
	private EduSupplierReviewMapper mapper;


	public void saveSupplierReview(EduSupplierReviewDto eduSupplierReviewDto) {
		// TODO Auto-generated method stub
		EduSupplierReview eduSupplierReview = BeanUtils.createBeanByTarget(eduSupplierReviewDto, EduSupplierReview.class);
		mapper.insertSelective(eduSupplierReview);
	}
	
	
	
	
}
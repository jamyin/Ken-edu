package com.ssic.education.handle.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.EduSupplierReviewDto;
import com.ssic.education.handle.mapper.EduSupplierReviewMapper;
import com.ssic.education.handle.pojo.EduSupplierReview;
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
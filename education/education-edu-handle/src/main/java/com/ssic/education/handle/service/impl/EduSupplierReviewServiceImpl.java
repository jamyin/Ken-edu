package com.ssic.education.handle.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduSupplierReviewDto;
import com.ssic.education.handle.dao.EduSupplierReviewDao;
import com.ssic.education.handle.pojo.EduSupplierReview;
import com.ssic.education.handle.service.IEduSupplierReviewService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduSupplierReviewServiceImpl implements IEduSupplierReviewService{

	protected static final Log logger = LogFactory.getLog(EduSupplierReviewServiceImpl.class);
	
    @Autowired
    private EduSupplierReviewDao eduSupplierReviewDao;
	

	@Override
	public void saveSupplierReview(EduSupplierReviewDto eduSupplierReviewDto) {
		eduSupplierReviewDao.saveSupplierReview(eduSupplierReviewDto);
	}

	/**
	 * 需要修改成 单条导入 sql  ---cwf
	 */
	@Override
	public void saveSupplierReview(List<EduSupplierReviewDto> eduSupplierReviewList) {
		List<EduSupplierReview> dataList = BeanUtils.createBeanListByTarget(eduSupplierReviewList, EduSupplierReview.class);
		for(EduSupplierReview pojoObj :  dataList){
			eduSupplierReviewDao.insertSelective(pojoObj);
		}
		
	}

}

package com.ssic.education.app.dto;

import lombok.Data;
import lombok.ToString;

import com.ssic.education.common.dto.EduCanteenDto;
import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.education.common.dto.EduSchoolSupplierDto;

/**
* @ClassName: EduAreaDto
* @Description: APP学校信息
* @author Ken Yin
* @date 2016年5月26日 上午11:50:21
*
 */
@Data
@ToString
public class SchoolDto {
	
	private EduSchoolDto eduSchoolDto;
	private EduCanteenDto eduCanteenDto;
	private EduSchoolSupplierDto eduSchoolSupplierDto;
    
}


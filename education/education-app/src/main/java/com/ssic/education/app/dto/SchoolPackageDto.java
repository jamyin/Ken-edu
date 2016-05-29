package com.ssic.education.app.dto;

import lombok.Data;
import lombok.ToString;

import com.ssic.educateion.common.dto.EduCanteenDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.EduSchoolSupplierDto;
import com.ssic.educateion.common.dto.ProPackagesDto;
import com.ssic.education.utils.model.PageResult;

/**
* @ClassName: EduAreaDto
* @Description: APP学校信息
* @author Ken Yin
* @date 2016年5月26日 上午11:50:21
*
 */
@Data
@ToString
public class SchoolPackageDto {
	
	private EduSchoolDto eduSchoolDto;
	private EduCanteenDto eduCanteenDto;
	private EduSchoolSupplierDto eduSchoolSupplierDto;
	private PageResult<ProPackagesDto> proPackagesDto;
    
}


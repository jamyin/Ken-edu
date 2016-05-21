package com.ssic.education.common.service;

import java.util.List;

import com.ssic.education.common.dto.EduCommitteeDto;

/**
 * 
	 * 此类描述的是：教委基础信息表
	 * @author: cwftalus@163.com
	 * @version: 2016年5月20日 下午1:45:16
 */
public interface IEduCommitteeService {
	public List<EduCommitteeDto> queryCommittee(EduCommitteeDto eduCommitteeDto);
}

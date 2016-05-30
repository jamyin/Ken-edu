package com.ssic.education.app.service;

import java.util.List;

import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

/**
* @ClassName: ICommitteeService
* @Description: 教委相关接口
* @author Ken Yin
* @date 2016年5月23日 下午5:23:43
*
 */
public interface ICommitteeService {

	//查询所有区教委列表-带分页
	PageResult<EduCommitteeDto> findCommitteeList(
			EduCommitteeDto eduCommitteeDto, PageQuery query);
	
	List<EduCommitteeDto> findCommitteeListNoPage(
			EduCommitteeDto eduCommitteeDto);
}


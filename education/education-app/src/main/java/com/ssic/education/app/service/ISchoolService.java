package com.ssic.education.app.service;

import org.springframework.stereotype.Service;

import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.util.model.PageQuery;
import com.ssic.util.model.PageResult;

/**
* @ClassName: ISchoolService
* @Description: 学校相关接口
* @author Ken Yin
* @date 2016年5月13日 上午9:15:34
*
 */
@Service
public interface ISchoolService {

	//查询所有学校列表-带分页
	PageResult<EduSchoolDto> findSchoolList(EduSchoolDto eduSchoolDto,
			PageQuery query);


}

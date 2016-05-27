package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.education.app.service.ICommitteeService;
import com.ssic.education.handle.dao.CommitteeDao;
import com.ssic.education.handle.pojo.EduCommittee;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

/**	
* @ClassName: CommitteeServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月23日 下午5:24:48
*
 */
@Service
public class CommitteeServiceImpl implements ICommitteeService{

    @Autowired
    private CommitteeDao committeeDao;

	@Override
	public PageResult<EduCommitteeDto> findCommitteeList(
			EduCommitteeDto eduCommitteeDto, PageQuery query) {
		List<EduCommittee> list = committeeDao.findCommitteeList(eduCommitteeDto, query);
		List<EduCommitteeDto> schoolDtoList = BeanUtils.createBeanListByTarget(list, EduCommitteeDto.class);
		int total = committeeDao.selectCommitteeAccount(eduCommitteeDto);
		query.setTotal(total);
		return new PageResult<EduCommitteeDto>(query, schoolDtoList);
	}

}


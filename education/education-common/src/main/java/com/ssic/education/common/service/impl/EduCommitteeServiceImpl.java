package com.ssic.education.common.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.common.dao.EduCommitteeDao;
import com.ssic.education.common.dto.EduCommitteeDto;
import com.ssic.education.common.pojo.EduCommittee;
import com.ssic.education.common.service.IEduCommitteeService;
import com.ssic.util.BeanUtils;

@Service
public class EduCommitteeServiceImpl implements IEduCommitteeService {
	
	protected static final Log logger = LogFactory.getLog(EduCommitteeServiceImpl.class);
	
    @Autowired
    private EduCommitteeDao eduCommitteeDao;
	
	public EduCommitteeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<EduCommitteeDto> queryCommittee(EduCommitteeDto eduCommitteeDto) {
		// TODO Auto-generated method stub
		List<EduCommittee> dataList = eduCommitteeDao.queryCommittee(eduCommitteeDto);
		return BeanUtils.createBeanListByTarget(dataList,EduCommitteeDto.class);
	}

}

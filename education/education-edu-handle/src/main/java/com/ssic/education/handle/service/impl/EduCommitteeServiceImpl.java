package com.ssic.education.handle.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.education.handle.dao.EduCommitteeDao;
import com.ssic.education.handle.pojo.EduCommittee;
import com.ssic.education.handle.service.IEduCommitteeService;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduCommitteeServiceImpl implements IEduCommitteeService {
	
	protected static final Log logger = LogFactory.getLog(EduCommitteeServiceImpl.class);
	
    @Autowired
    private EduCommitteeDao eduCommitteeDao;
	
	public EduCommitteeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<EduCommitteeDto> queryCommittee(EduCommitteeDto eduCommitteeDto) {
		// TODO Auto-generated method stub
		List<EduCommittee> dataList = eduCommitteeDao.queryCommittee(eduCommitteeDto);
		return BeanUtils.createBeanListByTarget(dataList,EduCommitteeDto.class);
	}
	
	public EduCommitteeDto findById (String id) {
		EduCommittee eduCommittee = eduCommitteeDao.selectByPrimaryKey(id);
		if (null != eduCommittee) {
			return BeanUtils.createBeanByTarget(eduCommittee, EduCommitteeDto.class);
		}
		return null;
	}
	
	public List<EduCommitteeDto> findAll(){
		List<EduCommittee> dataList = eduCommitteeDao.findAll();
		return BeanUtils.createBeanListByTarget(dataList,EduCommitteeDto.class);
	}

}

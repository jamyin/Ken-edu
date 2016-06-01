package com.ssic.education.handle.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssic.educateion.common.dto.EduUsersDto;
import com.ssic.educateion.common.dto.EduUsersRegDto;
import com.ssic.educateion.common.dto.ProLicenseDto;
import com.ssic.education.handle.dao.EduCanteenDao;
import com.ssic.education.handle.dao.EduSchoolDao;
import com.ssic.education.handle.dao.EduUsersDao;
import com.ssic.education.handle.dao.ProLicenseDao;
import com.ssic.education.handle.pojo.EduCanteen;
import com.ssic.education.handle.pojo.EduSchool;
import com.ssic.education.handle.pojo.EduUsers;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.service.EduUsersService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class EduUsersServiceImpl implements EduUsersService {

	@Autowired
	private EduUsersDao eduUsersDao;
	
	@Autowired
	private EduSchoolDao eduSchoolDao;
	
	@Autowired
	private ProLicenseDao proLicenseDao;
	
	@Autowired
	private EduCanteenDao eduCanteenDao;

	
	public EduUsersDto checkUser(EduUsersDto usersDto) {
		// TODO Auto-generated method stub
		return eduUsersDao.checkUser(usersDto);
	}

	public boolean validateAccount(EduUsersRegDto usersDto) {
		// TODO Auto-generated method stub
		return eduUsersDao.validateAccount(usersDto);
	}

	@Transactional
	public EduUsersDto save(EduUsersRegDto usersDto) {
		// TODO Auto-generated method stub
		EduSchool eduSchool = BeanUtils.createBeanByTarget(usersDto, EduSchool.class);
		Integer reviewed = DataStatus.DISABLED;
		eduSchool.setReviewed(reviewed.byteValue());
		eduSchoolDao.insertSelective(eduSchool);
		EduUsers eduUsers = BeanUtils.createBeanByTarget(usersDto, EduUsers.class);
		eduUsers.setSourceId(eduSchool.getId());
		eduUsers.setName(eduSchool.getSchoolName());
		eduUsers.setIsadmin(1);
		eduUsersDao.insertSelective(eduUsers);
		EduCanteen eduCanteen = BeanUtils.createBeanByTarget(usersDto, EduCanteen.class);
		eduCanteen.setSchoolId(eduSchool.getId());
		eduCanteenDao.insertSelective(eduCanteen);
		List<ProLicenseDto> proLicenseDtos = new Gson().fromJson(usersDto.getJsonLic(), new TypeToken<List<ProLicenseDto>>(){}.getType());
		for (ProLicenseDto proLicenseDto:proLicenseDtos) {
			if (null != proLicenseDto && StringUtils.isNotBlank(proLicenseDto.getLicPic())) {
				ProLicense proLicense = BeanUtils.createBeanByTarget(proLicenseDto, ProLicense.class);
				proLicense.setRelationId(eduCanteen.getId());
				proLicense.setCerSource(usersDto.getCerSource().shortValue());
				proLicenseDao.insertSelective(proLicense);
			}
		}
		return BeanUtils.createBeanByTarget(eduUsers, EduUsersDto.class);
	}
	
	public EduUsersDto getUserInfo(EduUsersDto usersDto) {
		return BeanUtils.createBeanByTarget(eduUsersDao.selectByPrimaryKey(usersDto.getId()), EduUsersDto.class);
	}

	public Integer update(EduUsersDto usersDto) {
		EduUsers eduUsers = BeanUtils.createBeanByTarget(usersDto, EduUsers.class);
		return eduUsersDao.updateByPrimaryKeySelective(eduUsers);
	}
}

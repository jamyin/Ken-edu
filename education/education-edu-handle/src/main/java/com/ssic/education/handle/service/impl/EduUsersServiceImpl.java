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
		if (null != eduCanteen && StringUtils.isNotBlank(eduCanteen.getCanteenName())) {
			eduCanteen.setSchoolId(eduSchool.getId());
			eduCanteen.setCreator(eduUsers.getId());
			eduCanteenDao.insertSelective(eduCanteen);
		}		
		List<ProLicenseDto> proLicenseDtos = new Gson().fromJson(usersDto.getJsonLic(), new TypeToken<List<ProLicenseDto>>(){}.getType());
		if (proLicenseDtos != null && proLicenseDtos.size()>0) {
			for (ProLicenseDto proLicenseDto:proLicenseDtos) {
				if (null != proLicenseDto && StringUtils.isNotBlank(proLicenseDto.getLicPic())) {
					ProLicense proLicense = BeanUtils.createBeanByTarget(proLicenseDto, ProLicense.class);
					proLicense.setRelationId(eduCanteen.getId());
					proLicense.setCerSource(usersDto.getCerSource().shortValue());
					proLicense.setCreator(eduUsers.getId());
					proLicenseDao.insertSelective(proLicense);
				}
			}
		}		
		return BeanUtils.createBeanByTarget(eduUsers, EduUsersDto.class);
	}
	
	@Transactional
	public EduUsersRegDto edit(EduUsersRegDto usersDto) {
		EduSchool eduSchool = BeanUtils.createBeanByTarget(usersDto, EduSchool.class);
		eduSchool.setId(usersDto.getSchoolId());
		eduSchool.setUpdater(usersDto.getCreator());
		eduSchoolDao.updateByPrimaryKeySelective(eduSchool);
		EduCanteen eduCanteen = BeanUtils.createBeanByTarget(usersDto, EduCanteen.class);
		if (StringUtils.isNotBlank(usersDto.getCanteenId())) {
			eduCanteen.setId(usersDto.getCanteenId());
			eduCanteenDao.updateByPrimaryKeySelective(eduCanteen);
		} else {
			eduCanteen.setSchoolId(usersDto.getSchoolId());
			eduCanteenDao.insertSelective(eduCanteen);
		}
		
		List<ProLicenseDto> proLicenseDtos = new Gson().fromJson(usersDto.getJsonLic(), new TypeToken<List<ProLicenseDto>>(){}.getType());
		
		ProLicense prolicense = new ProLicense();
		prolicense.setCerSource((short)DataStatus.MANAGERTYPE);
		prolicense.setRelationId(eduCanteen.getId());
		List<ProLicense> proLicenses = proLicenseDao.lookImage(prolicense);
		if (null != proLicenses && proLicenses.size()>0) {
			for (ProLicense proLicense :proLicenses) {
				proLicense.setStat(DataStatus.DISABLED);
				proLicenseDao.updateByPrimaryKeySelective(proLicense);
			}
		}
		for (ProLicenseDto proLicenseDto:proLicenseDtos) {
			if (null != proLicenseDto && StringUtils.isNotBlank(proLicenseDto.getLicNo())) {
				if (StringUtils.isNotBlank(proLicenseDto.getId())) {
					ProLicense proLicense = BeanUtils.createBeanByTarget(proLicenseDto, ProLicense.class);
					if (proLicense.getLicPic().equals("undefined")) {
						proLicense.setLicPic(null);
					}
					proLicense.setStat(DataStatus.ENABLED);
					proLicenseDao.updateByPrimaryKeySelective(proLicense);
				}else {
					ProLicense proLicense = BeanUtils.createBeanByTarget(proLicenseDto, ProLicense.class);
					if (proLicense.getLicPic().equals("undefined")) {
						proLicense.setLicPic(null);
					}
					proLicense.setRelationId(eduCanteen.getId());
					proLicense.setCerSource(usersDto.getCerSource().shortValue());
					proLicense.setCreator(usersDto.getCreator());
					proLicenseDao.insertSelective(proLicense);
				}
				
			}
		}
		return usersDto;
	}
	
	public EduUsersDto getUserInfo(EduUsersDto usersDto) {
		return BeanUtils.createBeanByTarget(eduUsersDao.selectByPrimaryKey(usersDto.getId()), EduUsersDto.class);
	}

	public Integer update(EduUsersDto usersDto) {
		EduUsers eduUsers = BeanUtils.createBeanByTarget(usersDto, EduUsers.class);
		return eduUsersDao.updateByPrimaryKeySelective(eduUsers);
	}
}

package com.ssic.education.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.SchoolDto;
import com.ssic.education.app.constants.SchoolLevel;
import com.ssic.education.app.dto.SchoolUserDto;
import com.ssic.education.app.service.ISchoolService;
import com.ssic.education.handle.dao.CommitteeDao;
import com.ssic.education.handle.dao.SchoolDao;
import com.ssic.education.handle.pojo.EduCommittee;
import com.ssic.education.handle.pojo.EduSchool;
import com.ssic.education.handle.pojo.ProLedger;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

/**	
* @ClassName: SchoolServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 下午2:20:58
*
 */
@Service
public class SchoolsServiceImpl implements ISchoolService {

	@Autowired
	private SchoolDao schoolDao;
	@Autowired
	private CommitteeDao comitDao;

	@Override
	public PageResult<SchoolDto> findSchoolList(SchoolDto schoolDto, PageQuery query, Integer isPage) {
		List<EduSchool> list = schoolDao.findSchoolList(schoolDto, query, isPage);
		List<SchoolDto> schoolDtoList = BeanUtils.createBeanListByTarget(list, SchoolDto.class);
		int total = schoolDao.selectSchoolAccount(schoolDto);
		query.setTotal(total);
		return new PageResult<SchoolDto>(query, schoolDtoList);
	}

	@Override
	public PageResult<EduSchoolDto> findSchoolDetialList(String id, EduSchoolDto eduSchoolDto, PageQuery query) {
		List<EduSchool> list = schoolDao.findSchoolDetialList(id, eduSchoolDto, query);
		List<EduSchoolDto> dtoList = BeanUtils.createBeanListByTarget(list, EduSchoolDto.class);
		int total = schoolDao.selectSchoolDetialAccount(id, eduSchoolDto);
		query.setTotal(total);
		return new PageResult<EduSchoolDto>(query, dtoList);
	}

	@Override
	public PageResult<SchoolDto> findSchoolList(SchoolDto schoolDto, PageQuery query) {
		List<EduSchool> list = schoolDao.findSchoolList(schoolDto, query);
		List<SchoolDto> schoolDtoList = BeanUtils.createBeanListByTarget(list, SchoolDto.class);
		int total = schoolDao.selectSchoolAccount(schoolDto);
		query.setTotal(total);
		return new PageResult<SchoolDto>(query, schoolDtoList);
	}

	@Override
	public SchoolUserDto findSchoolById(String schoolId) {
		EduSchool eduSchool = schoolDao.selectByPrimaryKey(schoolId);
		if (eduSchool != null) {
			SchoolUserDto schoolUser = BeanUtils.createBeanByTarget(eduSchool, SchoolUserDto.class);
			if (schoolUser.getCommitteeId() != null) {
				EduCommittee comm = comitDao.selectByPrimaryKey(schoolUser.getCommitteeId());
				if (null != comm.getName()) {
					schoolUser.setCommitteeName(comm.getName());
				}
			}
			if (schoolUser.getLevel() != null) {
				Map<Integer, String> map = SchoolLevel.getAll();
				String[] strArray = schoolUser.getLevel().split(",");
				List<String> list = new ArrayList<String>();
				if (strArray.length != 1) {
					for (String key : strArray) {
						list.add(map.get(Integer.parseInt(key)));
					}
					schoolUser.setLevelName(listToString(list));
				} else {
					schoolUser.setLevelName(map.get(Integer.parseInt(schoolUser.getLevel())));
				}
			}
			return schoolUser;
		}
		return null;
	}

	/**
	 * List转String
	 * listToString：一句话描述方法功能
	 * @param list
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月26日 下午3:31:15
	 */
	public String listToString(List<String> list) {
		if (list == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (String str : list) {
			if (flag) {
				result.append("," == null ? "" : ",");
			} else {
				flag = true;
			}
			result.append(str);
		}

		return result.toString();
	}
}

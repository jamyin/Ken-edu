package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.EduSchoolSupplierDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.education.handle.mapper.EduSchoolSupplierExMapper;
import com.ssic.education.handle.mapper.EduSchoolSupplierMapper;
import com.ssic.education.handle.pojo.EduSchoolSupplier;
import com.ssic.education.handle.pojo.EduSchoolSupplierExample;
import com.ssic.education.handle.pojo.EduSchoolSupplierExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.StringUtils;

@Repository
public class EduSchoolSupplierDao  extends MyBatisBaseDao<EduSchoolSupplier>{

	@Getter
	@Autowired
	private EduSchoolSupplierMapper mapper;
	
	@Autowired
	private EduSchoolSupplierExMapper exMapper;

	public List<EduSchoolSupplier> searchEduSchoolSupplierDto(EduSchoolSupplierDto eduSchoolSupplierDto) {
		EduSchoolSupplierExample example = new EduSchoolSupplierExample();
		Criteria criteria = example.createCriteria();
		
		if(!StringUtils.isEmpty(eduSchoolSupplierDto.getSchoolId())){
			criteria.andSchoolIdEqualTo(eduSchoolSupplierDto.getSchoolId());
		}
		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.selectByExample(example);
	}

	public String findSchoolIdByReceiverId(String receiverName,String sourceId) {
		return exMapper.findSchoolIdByReceiverId(receiverName,sourceId);
	}

	public List<SupplierDto> searchEduSchoolSupplierListDto(
			String schoolId) {
		// TODO Auto-generated method stub
		return exMapper.searchEduSchoolSupplierListDto(schoolId);
	}
}
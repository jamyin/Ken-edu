package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.handle.mapper.EduSchoolExMapper;
import com.ssic.education.handle.mapper.EduSchoolMapper;
import com.ssic.education.handle.pojo.EduSchool;
import com.ssic.education.handle.pojo.EduSchoolExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;

/**
 * @author pengpeng
 * @Date: 2016年5月12日 下午5:36:21
 */
@Repository
public class EduSchoolDao extends MyBatisBaseDao<EduSchool> {

    @Autowired
    @Getter
    private EduSchoolMapper mapper;
    
    @Autowired
    private EduSchoolExMapper exMapper;;
    
    public List<ProSupplierDto> getSupplier(String schoolId) {    	
    	return exMapper.getSupplierBySchoolId(schoolId);
    }

    public List<EduSchoolDto> findPage(EduSchoolDto dto, PageQuery page) {
        EduSchoolExample example = new EduSchoolExample();
        EduSchoolExample.Criteria criteria = example.createCriteria();
        assemblyParams(dto, criteria);
        if (null != page) {
            example.setOrderByClause("stat desc,create_time desc limit " + page.getStartNum() + "," + page.getPageSize());
        } else {
            example.setOrderByClause("create_time desc");
        }
        return BeanUtils.createBeanListByTarget(mapper.selectByExample(example), EduSchoolDto.class);
    }

    public long count(EduSchoolDto dto) {
        EduSchoolExample example = new EduSchoolExample();
        EduSchoolExample.Criteria criteria = example.createCriteria();
        assemblyParams(dto, criteria);
        return mapper.countByExample(example);
    }

    private void assemblyParams(EduSchoolDto dto, EduSchoolExample.Criteria criteria) {
        if (null != dto) {
            if (StringUtils.isNotBlank(dto.getAddress())) {
                criteria.andAddressEqualTo(dto.getAddress().trim());
            }
            if (StringUtils.isNotBlank(dto.getSchoolName())) {
                criteria.andSchoolNameLike("%" + dto.getSchoolName().trim() + "%");
            }
            if (StringUtils.isNotBlank(dto.getLevel())) {
                criteria.andLevelLike("%" + dto.getLevel().trim()+ "%");
            }
            if (StringUtils.isNotBlank(dto.getArea())) {
                criteria.andAreaEqualTo(dto.getArea().trim());
            }
            if (StringUtils.isNotBlank(dto.getProvince())) {
            	criteria.andProvinceEqualTo(dto.getProvince());
            }
           /* if (StringUtils.isNotBlank(dto.getCommitteeId())) {
                criteria.andCommitteeIdEqualTo(dto.getCommitteeId().trim());
            }*/
            if (null != dto.getReviewed()) {
            	criteria.andReviewedEqualTo(dto.getReviewed());
            }
        }

        criteria.andStatEqualTo(DataStatus.ENABLED);
    }

	public List<EduSchool> searchEduScholDtoList(EduSchoolDto eduSchoolDto) {
        EduSchoolExample example = new EduSchoolExample();
        EduSchoolExample.Criteria criteria = example.createCriteria();
        
        assemblyParams(eduSchoolDto, criteria);
        
		return mapper.selectByExample(example);
	}
}

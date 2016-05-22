package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.mapper.EduAreaMapper;
import com.ssic.education.common.pojo.EduArea;
import com.ssic.education.common.pojo.EduAreaExample;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

/**
* @ClassName: AreaServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 上午11:55:50
*
 */
@Repository
public class AreaDao extends MyBatisBaseDao<EduArea> {

	@Getter
	@Autowired
	private EduAreaMapper mapper;

	public List<EduArea> findAreaList() {
		EduAreaExample example = new EduAreaExample();
		//EduAreaExample.Criteria criteria = example.createCriteria();
        //assemblyParams(eduAreaDto, criteria);
        example.setOrderByClause("address_code ASC");
		return mapper.selectByExample(example);
	}


}


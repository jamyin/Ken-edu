package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.dto.EduAreaDto;
import com.ssic.education.app.service.IAreaService;
import com.ssic.education.common.dao.AreaDao;
import com.ssic.education.common.pojo.EduArea;
import com.ssic.util.BeanUtils;

/**
* @ClassName: AreaServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 上午11:55:50
*
 */
@Service
public class AreasServiceImpl implements IAreaService {

    @Autowired
    private AreaDao areaDao;
    
	@Override
	public List<EduAreaDto> findArea(EduAreaDto eduAreaDto) {
		List<EduArea> list = areaDao.findAreaList();
		List<EduAreaDto> eduAreaDtoList = BeanUtils.createBeanListByTarget(list, EduAreaDto.class);
		return eduAreaDtoList;
	}

}


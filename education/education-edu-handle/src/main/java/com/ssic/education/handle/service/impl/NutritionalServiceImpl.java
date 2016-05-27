package com.ssic.education.handle.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.ProNutritionalDto;
import com.ssic.education.handle.dao.ProNutritionalDao;
import com.ssic.education.handle.pojo.ProNutritional;
import com.ssic.education.handle.service.INutritionalService;
import com.ssic.education.utils.util.BeanUtils;

/**
 * @ClassName: NutritionalServiceImpl
 * @Description: (这里用一句话描述这个类的作用)
 * @author Ken Yin
 * @date 2016年5月25日 上午10:41:28
 *
 */
@Service
public class NutritionalServiceImpl implements INutritionalService {

	protected static final Log logger = LogFactory.getLog(NutritionalServiceImpl.class);

	@Autowired
	private ProNutritionalDao proNutritionalDao;

	@Override
	public List<ProNutritionalDto> selectAllNutritional() {

		List<ProNutritional> list = proNutritionalDao.selectAllNutritional();
		List<ProNutritionalDto> dtoList = BeanUtils.createBeanListByTarget(list, ProNutritionalDto.class);
		return dtoList;
	}

	@Override
	public List<ProNutritionalDto> selectAllNutritionalUnit() {
		List<ProNutritional> list = proNutritionalDao.selectAllNutritionalUnit();
		List<ProNutritionalDto> dtoList = BeanUtils.createBeanListByTarget(list, ProNutritionalDto.class);
		return dtoList;
	}

}

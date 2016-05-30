package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.ProNutritionalDto;

/**
* @ClassName: INutritionalService
* @Description: 
* @author Ken Yin
* @date 2016年5月25日 上午10:31:00
*
 */
public interface INutritionalService {

	//查询所有营养名称
	public List<ProNutritionalDto> selectAllNutritional();
	//查询所有营养单位
	public List<ProNutritionalDto> selectAllNutritionalUnit();
	
	public List<ProNutritionalDto> searchNutritional(
			List<String> packageIdList);
}

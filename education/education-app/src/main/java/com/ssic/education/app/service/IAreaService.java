package com.ssic.education.app.service;

import java.util.List;

import com.ssic.education.app.dto.EduAreaDto;

/**
* @ClassName: IAreaService
* @Description: 上海市区县接口
* @author Ken Yin
* @date 2016年5月12日 上午11:54:24
*
*/
public interface IAreaService {

	//查询上海所有区县
	List<EduAreaDto> findArea(EduAreaDto eduAreaDto);

}


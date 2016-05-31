package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.EduInformationListDto;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

public interface ITaskReceiveService {
	public void save(EduTaskReceiveDto eduTaskReceiveDto);

	public void saveList(List<EduTaskReceiveDto> dataList);

	public PageResult<EduTaskReceiveDto> searchEduTaskReceive(EduTaskReceiveDto eduTaskReceiveDto,
			PageQuery pageQuery);

	public int updateEduTaskReceive(EduTaskReceiveDto eduTaskReceiveDto); 
}

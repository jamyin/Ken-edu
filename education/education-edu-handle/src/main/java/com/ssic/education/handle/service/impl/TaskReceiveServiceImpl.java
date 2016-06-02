package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.education.handle.dao.EduTaskReceiveDao;
import com.ssic.education.handle.pojo.EduTaskReceive;
import com.ssic.education.handle.service.ITaskReceiveService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class TaskReceiveServiceImpl implements ITaskReceiveService {

	@Autowired
	private EduTaskReceiveDao eduTaskReceiveDao;

	@Override
	public void save(EduTaskReceiveDto eduTaskReceiveDto) {
		EduTaskReceive eduTaskReceive = BeanUtils.createBeanByTarget(eduTaskReceiveDto, EduTaskReceive.class);
		eduTaskReceiveDao.insertSelective(eduTaskReceive);
		
	}

	@Override
	public void saveList(List<EduTaskReceiveDto> dataList) {
		//需要单独sql 处理
		for(EduTaskReceiveDto dto : dataList){
			this.save(dto);
		}
	}

	@Override
	public PageResult<EduTaskReceiveDto> searchEduTaskReceive(EduTaskReceiveDto eduTaskReceiveDto,PageQuery pageQuery) {		
			List<EduTaskReceive> results = eduTaskReceiveDao.searchEduTaskReceive(eduTaskReceiveDto,pageQuery);
			List<EduTaskReceiveDto> dataList = BeanUtils.createBeanListByTarget(results, EduTaskReceiveDto.class);
			pageQuery.setTotal(eduTaskReceiveDao.count(eduTaskReceiveDto));
			return new PageResult<EduTaskReceiveDto>(pageQuery, dataList);
	}

	@Override
	public int updateEduTaskReceive(EduTaskReceiveDto eduTaskReceiveDto) {
		EduTaskReceive eduTaskReceive = BeanUtils.createBeanByTarget(eduTaskReceiveDto, EduTaskReceive.class);
		return eduTaskReceiveDao.updateByPrimaryKeySelective(eduTaskReceive);
	}

	@Override
	public List<EduTaskReceiveDto> searchEduTaskReceive(EduTaskReceiveDto eduTaskReceiveDto) {		
		List<EduTaskReceive> results = eduTaskReceiveDao.searchEduTaskReceive(eduTaskReceiveDto,null);
		if(results!=null && results.size()>0){
			List<EduTaskReceiveDto> dataList = BeanUtils.createBeanListByTarget(results, EduTaskReceiveDto.class);
			return dataList;
		}else{
			return null;
		}
}

}

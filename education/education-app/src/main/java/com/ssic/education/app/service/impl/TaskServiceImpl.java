package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.service.ITaskService;
import com.ssic.education.common.dao.TaskDao;
import com.ssic.education.common.dto.EduTaskDto;
import com.ssic.education.common.pojo.EduTask;
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
public class TaskServiceImpl implements ITaskService{

    @Autowired
    private TaskDao taskDao;

	@Override
	public PageResult<EduTaskDto> findTaskListById(String id, int readstat,
			PageQuery query) {
		List<EduTaskDto> list = taskDao.findTaskListById(id, readstat, query);
		int total = taskDao.selectTaskAccount(id, readstat);
		query.setTotal(total);
		return new PageResult<EduTaskDto>(query, list);
	}

	@Override
	public PageResult<EduTaskDto> findSendListById(String id, PageQuery query) {
		List<EduTask> list = taskDao.findSendListById(id, query);
		List<EduTaskDto> dtoList = BeanUtils.createBeanListByTarget(list, EduTaskDto.class);
		int total = taskDao.selectSendAccount(id);
		query.setTotal(total);
		return new PageResult<EduTaskDto>(query, dtoList);
	}
	
	@Override
	public Integer delTask(String id) {
		EduTask task = new EduTask();
		task.setId(id);
		return taskDao.updateByPrimaryKeySelective(task);
	}

	@Override
	public Integer updateTask(String id, String receiveId) {
		return taskDao.updateTask(id, receiveId);
	}

	
}


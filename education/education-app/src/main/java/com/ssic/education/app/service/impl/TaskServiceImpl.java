package com.ssic.education.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduTaskDto;
import com.ssic.educateion.common.dto.EduTaskReadDto;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.education.app.service.ITaskService;
import com.ssic.education.handle.dao.TaskDao;
import com.ssic.education.handle.pojo.EduTask;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.UUIDGenerator;

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
		task.setStat(DataStatus.DISABLED);
		return taskDao.updateByPrimaryKeySelective(task);
	}

	@Override
	public Integer updateTask(String id, String receiveId) {
		return taskDao.updateTask(id, receiveId);
	}

	@Override
	public PageResult<EduTaskReadDto> findReadList(EduTaskReceiveDto receiveDto,
			PageQuery query) {
		List<EduTaskReadDto> list = taskDao.findReadList(receiveDto, query);
		int total = taskDao.selectReadAccount(receiveDto);
		query.setTotal(total);
		return new PageResult<EduTaskReadDto>(query, list);
	}

	@Override
	public int sendTask(EduTaskDto eduTaskDto) {
		
		eduTaskDto.setId(UUIDGenerator.getUUID());
		eduTaskDto.setCreateTime(new Date());
		eduTaskDto.setStat(DataStatus.ENABLED);
		EduTask eduTask = BeanUtils.createBeanByTarget(eduTaskDto, EduTask.class);
		int flag = taskDao.addTask(eduTask);
		int addReceiveFlag = 0;
		if(flag > 0){
			String receiveId = eduTaskDto.getReceiveId();
			String receiveIds = receiveId.substring(0,receiveId.length()-1);   //去逗号
			String ids[] = receiveIds.split(",");
			List<EduTaskReceiveDto> receiveDtoList = new ArrayList<EduTaskReceiveDto>();
			for(String id: ids){
				EduTaskReceiveDto receiveDto = new EduTaskReceiveDto();
				receiveDto.setReceiveId(id);
				receiveDto.setTaskId(eduTaskDto.getId());
				
				receiveDto.setId(UUIDGenerator.getUUID());
				receiveDto.setReadstat(DataStatus.DISABLED);
				receiveDto.setCreateTime(new Date());
				receiveDto.setStat(DataStatus.ENABLED);
				receiveDtoList.add(receiveDto);
			}
			addReceiveFlag = taskDao.addTaskReceiveBatch(receiveDtoList); 
		}
		if(flag >0 && addReceiveFlag > 0){
			return 1;
		}
		return 0;
	}

	
}


package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduTaskDto;
import com.ssic.educateion.common.dto.EduTaskReadDto;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.educateion.common.dto.TaskReceivePageDto;
import com.ssic.education.handle.dao.TaskDao;
import com.ssic.education.handle.pojo.EduTask;
import com.ssic.education.handle.pojo.EduTaskReceive;
import com.ssic.education.handle.service.ITaskService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

/**	
* @ClassName: SchoolServiceImpl
* @Description: 
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
	public Integer updateTask(EduTaskReceiveDto receiveDto) {
		EduTaskReceive task = BeanUtils.createBeanByTarget(receiveDto, EduTaskReceive.class);
		return taskDao.updateTask(task);
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
	public List<EduTaskReceiveDto> findTaskReceiveList(
			EduTaskReceiveDto receiveDto) {
		EduTaskReceive task = BeanUtils.createBeanByTarget(receiveDto, EduTaskReceive.class);
		List<EduTaskReceive> eduTaskReceiveList = taskDao.findTaskReceiveList(task);
		if(eduTaskReceiveList == null || eduTaskReceiveList.size() <=0 ){
			return null;
		}
		List<EduTaskReceiveDto> dtoList = BeanUtils.createBeanListByTarget(eduTaskReceiveList, EduTaskReceiveDto.class);
		return dtoList;
	}

	@Override
	public String sendTask(EduTaskDto eduTaskDto) {
		EduTask eduTask = BeanUtils.createBeanByTarget(eduTaskDto, EduTask.class);
		int flag = taskDao.addTask(eduTask);
		if(flag > 0){
			return eduTaskDto.getId();
		}
		return null;
		/*int addReceiveFlag = 0;
		
		if(flag > 0){
			String receiveId = eduTaskDto.getReceiveId();
			String receiveIds = receiveId.substring(0,receiveId.length()-1);   //去逗号
			String ids[] = receiveIds.split(",");
			List<EduTaskReceiveDto> receiveDtoList = new ArrayList<EduTaskReceiveDto>();
			for(String id: ids){
				EduTaskReceiveDto receiveDto = new EduTaskReceiveDto();
				receiveDto.setReceiveId(id);
				receiveDto.setTaskId(eduTaskDto.getId());
				
				receiveDto.setTaskTitle(eduTaskDto.getTitle());
				
				receiveDto.setSendName(sendName);
				receiveDto.setReceiveName(receiveName);
				
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
		return 0;*/
	}

	@Override
	public EduTaskDto findTaskByPara(EduTaskDto eduTaskDto) {
		EduTask eduTask = taskDao.findTaskByPara(eduTaskDto);
		if(eduTask == null){
			return null;
		} 
		EduTaskDto dto = BeanUtils.createBeanByTarget(eduTask, EduTaskDto.class);
		return dto;
	}

	@Override
	public List<TaskReceivePageDto> findTaskReceiveByPara(String id) {
		List<TaskReceivePageDto> receiveList = taskDao.findTaskReceiveByPara(id);
		if(receiveList == null){
			return null;
		} 
		List<TaskReceivePageDto> dto = BeanUtils.createBeanListByTarget(receiveList, TaskReceivePageDto.class);
		return dto;
	}

	@Override
	public int addTaskReceiveBatch(List<EduTaskReceiveDto> receiveDtoList) {
		return taskDao.addTaskReceiveBatch(receiveDtoList);
	}

	
	@Override
	public int saveInfomation(EduTaskDto eduTaskDto) {
		// TODO Auto-generated method stub
		EduTask eduInformation = BeanUtils.createBeanByTarget(
				eduTaskDto, EduTask.class);
		return taskDao.insertSelective(eduInformation);
	}

	@Override
	public EduTaskDto search(String infoId) {
		EduTask pojo = taskDao.selectByPrimaryKey(infoId);
		return BeanUtils.createBeanByTarget(pojo, EduTaskDto.class);
	}

	@Override
	public PageResult<EduTaskDto> searchInfomation(EduTaskDto eduTaskDto,PageQuery pageQuery) {		
		List<EduTask> results = taskDao.findInformationList(eduTaskDto,pageQuery);
		List<EduTaskDto> dataList = BeanUtils.createBeanListByTarget(results, EduTaskDto.class);
		pageQuery.setTotal(taskDao.selectInformationAccount(eduTaskDto));
		return new PageResult<EduTaskDto>(pageQuery, dataList);
	}	
	
}


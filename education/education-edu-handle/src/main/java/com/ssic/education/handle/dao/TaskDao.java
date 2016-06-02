package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.EduTaskDto;
import com.ssic.educateion.common.dto.EduTaskReadDto;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.educateion.common.dto.TaskReceivePageDto;
import com.ssic.education.handle.mapper.EduTaskExMapper;
import com.ssic.education.handle.mapper.EduTaskMapper;
import com.ssic.education.handle.mapper.EduTaskReceiveExMapper;
import com.ssic.education.handle.mapper.EduTaskReceiveMapper;
import com.ssic.education.handle.pojo.EduTask;
import com.ssic.education.handle.pojo.EduTaskExample;
import com.ssic.education.handle.pojo.EduTaskReceive;
import com.ssic.education.handle.pojo.EduTaskReceiveExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.StringUtils;

/**
 * @ClassName: TaskDao
 * @Description: 
 * @author Ken Yin
 * @date 2016年5月20日 下午4:11:04
 *
 */
@Repository
public class TaskDao extends MyBatisBaseDao<EduTask> {

	@Autowired
	@Getter
	private EduTaskMapper mapper;

	@Autowired
	private EduTaskExMapper mappers;
	
	@Autowired
	@Getter
	private EduTaskReceiveMapper exMapper;
	
	@Autowired
	@Getter
	private EduTaskReceiveExMapper exMappers;
	
	public List<EduTaskDto> findTaskListById(String id, int readstat,
			PageQuery query) {
		return mappers.findTaskListById(id, readstat,
			query);
	}

	public int selectTaskAccount(String id, int readstat) {
		return mappers.selectTaskAccount(id, readstat);
	}


	public List<EduTask> findSendListById(String id, PageQuery query) {
		EduTaskExample example = new EduTaskExample();
		EduTaskExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(id)){
    		criteria.andCreateIdEqualTo(id);
    	}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if(query != null && query.getPageSize() > 0){
        	example.setOrderByClause("create_time DESC limit "+query.getStartNum() +"," + query.getPageSize());
		}
		return mapper.selectByExample(example);
	}

	public int selectSendAccount(String id) {
		EduTaskExample example = new EduTaskExample();
		EduTaskExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(id)){
    		criteria.andCreateIdEqualTo(id);
    	}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.countByExample(example);
	}
	public Integer updateTask(EduTaskReceive receive) {
		receive.setReadstat(DataStatus.ENABLED);      //设置已读
		EduTaskReceiveExample example = new EduTaskReceiveExample();
		EduTaskReceiveExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(receive.getTaskId())){
    		criteria.andTaskIdEqualTo(receive.getTaskId());
    	}
		if (StringUtils.isNotEmpty(receive.getReceiveId())){
    		criteria.andReceiveIdEqualTo(receive.getReceiveId());
    	}
		return exMapper.updateByExampleSelective(receive, example);
	}

	public List<EduTaskReadDto> findReadList(EduTaskReceiveDto receiveDto,
			PageQuery query) {
		return exMappers.findReadList(receiveDto,
				query);
	}
	
	public List<EduTaskReceive> findTaskReceiveList(EduTaskReceive task) {
		EduTaskReceiveExample example = new EduTaskReceiveExample();
		EduTaskReceiveExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(task.getId())){
    		criteria.andIdEqualTo(task.getId());
    	}
		if (StringUtils.isNotEmpty(task.getTaskId())){
    		criteria.andTaskIdEqualTo(task.getTaskId());
    	}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return exMapper.selectByExample(example);
	}

	public int selectReadAccount(EduTaskReceiveDto receiveDto) {
		return exMappers.selectReadAccount(receiveDto);
	}

	public int addTask(EduTask eduTask) {
		return mapper.insertSelective(eduTask);
	}

	public int addTaskReceiveBatch(List<EduTaskReceiveDto> receiveDtoList) {
		return exMappers.addTaskReceiveBatch(receiveDtoList);
	}

	public EduTask findTaskByPara(EduTaskDto eduTaskDto) {
		EduTaskExample example = new EduTaskExample();
		EduTaskExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(eduTaskDto.getId())){
    		criteria.andIdEqualTo(eduTaskDto.getId());
    	}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		List<EduTask> task = mapper.selectByExample(example);
		if(task != null && task.size() > 0){
			return task.get(0);
		}
		return null;
	}

	public List<TaskReceivePageDto> findTaskReceiveByPara(
			String id) {
		/*EduTaskReceiveExample example = new EduTaskReceiveExample();
		EduTaskReceiveExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(id)){
    		criteria.andTaskIdEqualTo(id);
    	}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		List<EduTaskReceive> taskReceiveList = exMapper.selectByExample(example);
		if(taskReceiveList != null && taskReceiveList.size() > 0){
			return taskReceiveList;
		}
		return null;*/
		return exMappers.findTaskReceiveByPara(id);
	}
	
	
	
	public List<EduTask> searchTask(EduTaskDto eduInformationDto,PageQuery query) {
		EduTaskExample example = new EduTaskExample();
		EduTaskExample.Criteria criteria = example.createCriteria();
        assemblyParams(eduInformationDto, criteria);
        if(query != null && query.getPageSize() > 0){
        	example.setOrderByClause("create_time DESC limit "+query.getStartNum() +"," + query.getPageSize());
		}
		List<EduTask> list = mapper.selectByExample(example);
		return list;
	}

	private void assemblyParams(EduTaskDto eduInformationDto, EduTaskExample.Criteria criteria) {
		if (null != eduInformationDto) {
        	if (StringUtils.isNotEmpty(eduInformationDto.getId())){
        		criteria.andIdEqualTo(eduInformationDto.getId().trim());
        	}
        	if (StringUtils.isNotBlank(eduInformationDto.getTitle())){
        		criteria.andTitleLike("%"+eduInformationDto.getTitle().trim()+"%");
        	}	
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
	}

	public int selectInformationAccount(EduTaskDto eduInformationDto) {
		EduTaskExample example = new EduTaskExample();
		EduTaskExample.Criteria criteria = example.createCriteria();
        assemblyParams(eduInformationDto, criteria);  
        return mapper.countByExample(example);
	}
	

}

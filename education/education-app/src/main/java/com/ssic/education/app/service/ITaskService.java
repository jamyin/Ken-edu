package com.ssic.education.app.service;

import com.ssic.educateion.common.dto.EduTaskDto;
import com.ssic.educateion.common.dto.EduTaskReadDto;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;


/**
* @ClassName: ITaskService
* @Description: 根据Id查询当前用户任务列表 -带分页(未读和历史-已读)
* @author Ken Yin
* @date 2016年5月20日 下午4:02:42
*
 */
public interface ITaskService {

	//根据Id查询当前用户任务列表 -带分页(未读和历史-已读)
	PageResult<EduTaskDto> findTaskListById(String id, int readstat,
			PageQuery query);
	
	//根据Id查询当前用户发送任务列表
	PageResult<EduTaskDto> findSendListById(String id, PageQuery query);
	
	//逻辑删除任务
	Integer delTask(String id);
	
	//修改任务阅读状态
	Integer updateTask(String id);

	//根据任务Id查询当前任务已读和未读列表
	PageResult<EduTaskReadDto> findReadList(EduTaskReceiveDto receiveDto,
			PageQuery query);

	//发布任务
	int sendTask(EduTaskDto eduTaskDto);
	
	//根据任务Id查询任务详情
	EduTaskDto findTaskByPara(EduTaskDto eduTaskDto);

}


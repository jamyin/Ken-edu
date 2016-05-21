package com.ssic.education.app.service;

import com.ssic.education.common.dto.EduTaskDto;
import com.ssic.util.model.PageQuery;
import com.ssic.util.model.PageResult;


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
	Integer updateTask(String id, String receiveId);


}

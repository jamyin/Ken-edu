package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.EduTaskDto;
import com.ssic.educateion.common.dto.EduTaskReadDto;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.education.app.service.ITaskService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.StringUtils;

/**
* @ClassName: TaskController
* @Description: 任务(通知)controll
* @author Ken Yin
* @date 2016年5月20日 下午2:53:15
*
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {
	
	@Autowired
	private ITaskService taskService;
    
   /**
   * @Title: findTaskListById
   * @Description: 根据Id查询当前用户接收任务列表 -带分页(未读和已读-历史)
   * @author Ken Yin  
   * @date 2016年5月20日 下午3:17:18
   * @return Response<EduTaskDto>    返回类型
    */
    @RequestMapping("/findTaskListById/{id}")
    @ResponseBody
    public Response<EduTaskDto> findTaskListById(@PathVariable("id")String id, PageQuery query) {
    	Response<EduTaskDto> result = new Response<EduTaskDto>();
    	EduTaskDto dto = new EduTaskDto();
    	if(StringUtils.isEmpty(id)){
     		result.setStatus(DataStatus.HTTP_FAILE);
     		result.setMessage("查询Id为空");
     		return result;
     	}
    	//查询当前用户接收任务列表-已读 readStat=1
    	PageResult<EduTaskDto> receiveReadList = taskService.findTaskListById(id, 1, query);
    	
    	//查询当前用户接收任务列表-未读 readStat=0
    	PageResult<EduTaskDto> receiveNotReadList = taskService.findTaskListById(id, 0, query);
    	
    	//查询当前用户发送任务列表
    	PageResult<EduTaskDto> sendList = taskService.findSendListById(id, query);
    	
    	dto.setSendList(sendList);
    	dto.setReceiveReadList(receiveReadList);
    	dto.setReceiveNotReadList(receiveNotReadList);
    	
		result.setData(dto);
    	return result;
    	/*if(taskList.getResults() != null && taskList.getResults().size() >0 ){
    		result.setStatus(DataStatus.HTTP_SUCCESS);
    		result.setMessage("查询任务成功！");
    		result.setData(taskList);
    		return result;
    	}else{
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("未查到相关记录！");
    		return result;
    	}*/
    }
    
    /**
    * @Title: delTask
    * @Description: 逻辑删除任务
    * @author Ken Yin  
    * @date 2016年5月20日 下午5:39:27
    * @return Response<String>    返回类型
     */
    @RequestMapping("/delTask/{id}")
    @ResponseBody
    public Response<String> delTask(@PathVariable("id")String id){
    	Response<String> result = new Response<String>();
    	if(StringUtils.isEmpty(id)){
     		result.setStatus(DataStatus.HTTP_FAILE);
     		result.setMessage("查询Id为空");
     		return result;
     	}
    	Integer flag = taskService.delTask(id);
    	if(flag > 0){
    		result.setStatus(DataStatus.HTTP_SUCCESS);
    		result.setMessage("删除任务成功");
    		return result;
    	}else{
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("删除任务失败");
    		return result;
    	}
    }
    
    /**
    * @Title: upadteTask
    * @Description: 修改任务阅读状态
    * @author Ken Yin  
    * @date 2016年5月20日 下午5:53:55
    * @return Response<String>    返回类型
     */
    @RequestMapping("/upadteTask/{id}/{receiveId}")
    @ResponseBody
    public Response<String> upadteTask(@PathVariable("id")String id, @PathVariable("receiveId")String receiveId){
    	Response<String> result = new Response<String>();
    	if(StringUtils.isEmpty(id)){
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("任务Id为空");
    		return result;
    	}
    	if(StringUtils.isEmpty(receiveId)){ 
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("用户Id为空");
    		return result;
    	}
    	Integer flag = taskService.updateTask(id, receiveId);
    	if(flag > 0){
    		result.setStatus(DataStatus.HTTP_SUCCESS);
    		result.setMessage("修改任务成功");
    		return result;
    	}else{
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("修改任务失败");
    		return result;
    	}
    }
    
    /**
    * @Title: findReadList
    * @Description: 根据任务Id查询当前任务已读和未读列表
    * @author Ken Yin  
    * @date 2016年5月21日 上午11:34:50
    * @return Response<EduTaskReadDto>    返回类型
     */
      @RequestMapping("/findReceiveList/{id}")
      @ResponseBody
      public Response<EduTaskReadDto> findReadList(@PathVariable("id")String id, PageQuery query) {
      	Response<EduTaskReadDto> result = new Response<EduTaskReadDto>();
      	if(StringUtils.isEmpty(id)){
       		result.setStatus(DataStatus.HTTP_FAILE);
       		result.setMessage("任务Id为空");
       		return result;
       	}
      	EduTaskReceiveDto receiveDto = new EduTaskReceiveDto();
      	receiveDto.setTaskId(id);
      	receiveDto.setReadstat(1);    //已读
      	PageResult<EduTaskReadDto> readList = taskService.findReadList(receiveDto, query);
      	receiveDto.setReadstat(0);	  //未读
    	PageResult<EduTaskReadDto> notReadList = taskService.findReadList(receiveDto, query);
    	EduTaskReadDto dto = new EduTaskReadDto();
    	dto.setReadList(readList);
    	dto.setNotReadList(notReadList);
    	result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("查询成功");
		result.setData(dto);
		return result;
      }
      
      /**
      * @Title: findReadList
      * @Description: 发送任务
      * @author Ken Yin  
      * @date 2016年5月26日 上午10:50:28
      * @return Response<EduTaskReadDto>    返回类型
       */
      @RequestMapping("/sendTask")
      @ResponseBody
      public Response<String> sendTask(EduTaskDto eduTaskDto) {
    	  Response<String> result = new Response<String>();
    	  if(StringUtils.isEmpty(eduTaskDto.getReceiveId())){
    		  result.setStatus(DataStatus.HTTP_FAILE);
    		  result.setMessage("任务接收者为空");
    		  return result;
    	  }
    	  int flag = taskService.sendTask(eduTaskDto);
    	  if(flag > 0){
    		  result.setStatus(DataStatus.HTTP_SUCCESS);
    		  result.setMessage("发布任务成功");
    		  return result;
    	  }else{
    		  result.setStatus(DataStatus.HTTP_FAILE);
    		  result.setMessage("发布任务失败");
    		  return result;
    	  }
      }
    
}


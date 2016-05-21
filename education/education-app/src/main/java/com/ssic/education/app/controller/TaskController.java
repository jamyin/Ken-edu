package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.service.ITaskService;
import com.ssic.education.common.dto.EduTaskDto;
import com.ssic.education.common.dto.EduTaskReceiveDto;
import com.ssic.util.StringUtils;
import com.ssic.util.constants.DataStatus;
import com.ssic.util.model.PageQuery;
import com.ssic.util.model.PageResult;
import com.ssic.util.model.Response;

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
   * @Description: 根据Id查询当前用户接收任务列表 -带分页(未读和历史-已读)
   * @author Ken Yin  
   * @date 2016年5月20日 下午3:17:18
   * @return Response<EduTaskDto>    返回类型
    */
    @RequestMapping("/findTaskListById/{id}")
    @ResponseBody
    public Response<PageResult<EduTaskDto>> findTaskListById(@PathVariable("id")String id, @PathVariable("readstat")int readstat, PageQuery query) {
    	Response<PageResult<EduTaskDto>> result = new Response<PageResult<EduTaskDto>>();
    	if(StringUtils.isEmpty(id)){
     		result.setStatus(DataStatus.HTTP_FAILE);
     		result.setMessage("查询Id为空");
     		return result;
     	}
    	PageResult<EduTaskDto> taskList = taskService.findTaskListById(id, readstat, query);
    	if(taskList.getResults() != null && taskList.getResults().size() >0 ){
    		result.setStatus(DataStatus.HTTP_SUCCESS);
    		result.setMessage("查询任务成功！");
    		result.setData(taskList);
    		return result;
    	}else{
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("未查到相关记录！");
    		return result;
    	}
    }
    /**
    * @Title: findSendListById
    * @Description: 根据Id查询当前用户发送任务列表
    * @author Ken Yin  
    * @date 2016年5月21日 上午10:42:02
    * @return Response<PageResult<EduTaskDto>>    返回类型
     */
    @RequestMapping("/findSendListById/{id}")
    @ResponseBody
    public Response<PageResult<EduTaskDto>> findSendListById(@PathVariable("id")String id, PageQuery query) {
    	Response<PageResult<EduTaskDto>> result = new Response<PageResult<EduTaskDto>>();
    	if(StringUtils.isEmpty(id)){
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("查询Id为空");
    		return result;
    	}
    	PageResult<EduTaskDto> taskList = taskService.findSendListById(id, query);
    	if(taskList.getResults() != null && taskList.getResults().size() >0 ){
    		result.setStatus(DataStatus.HTTP_SUCCESS);
    		result.setMessage("查询任务成功！");
    		result.setData(taskList);
    		return result;
    	}else{
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("未查到相关记录！");
    		return result;
    	}
    }
    
    /**
    * @Title: delTask
    * @Description: 逻辑删除任务
    * @author Ken Yin  
    * @date 2016年5月20日 下午5:39:27
    * @return Response<String>    返回类型
     */
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
    * @Title: findTaskListById
    * @Description: 根据任务Id查询当前任务已读和未读列表
    * @author Ken Yin  
    * @date 2016年5月21日 上午11:34:50
    * @return Response<PageResult<EduTaskDto>>    返回类型
     */
      /*@RequestMapping("/findReceiveList/{id}")
      @ResponseBody
      public Response<PageResult<EduTaskReceiveDto>> findReceiveList(@PathVariable("id")String id, @PathVariable("readstat")int readstat, PageQuery query) {
      	Response<PageResult<EduTaskReceiveDto>> result = new Response<PageResult<EduTaskReceiveDto>>();
      	if(StringUtils.isEmpty(id)){
       		result.setStatus(DataStatus.HTTP_FAILE);
       		result.setMessage("任务Id为空");
       		return result;
       	}
      	PageResult<EduTaskDto> taskList = taskService.findReceiveList(id, readstat, query);
      	if(taskList.getResults() != null && taskList.getResults().size() >0 ){
      		result.setStatus(DataStatus.HTTP_SUCCESS);
      		result.setMessage("查询任务成功！");
      		result.setData(taskList);
      		return result;
      	}else{
      		result.setStatus(DataStatus.HTTP_FAILE);
      		result.setMessage("未查到相关记录！");
      		return result;
      	}
      }*/
    
}


package com.ssic.education.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.util.model.PageQuery;
import com.ssic.util.model.Response;

/**
* @ClassName: TaskController
* @Description: 任务controller
* @author Ken Yin
* @date 2016年5月12日 上午10:30:02
*
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {
    
   /**
    * @Title: findTask
    * @Description: 查询任务列表 -带分页
    * @author Ken Yin  
    * @date 2016年5月12日 上午11:27:34
    * @return Response<EduTaskDto>    返回类型
    */
    /*@RequestMapping("/findTask")
    @ResponseBody
    public Response<EduTaskDto> findTask(EduTaskDto eduTaskDto, PageQuery query) {
		return null;
    	Response<List<EduTaskDto>> result = new Response<List<EduTaskDto>>();
    	List<EduTaskDto> taskList = iTaskService.findTask(eduTaskDto);
    	if(taskList.size()>0){
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


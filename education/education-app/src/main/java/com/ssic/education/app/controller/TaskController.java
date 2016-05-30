package com.ssic.education.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.EduTaskDto;
import com.ssic.educateion.common.dto.EduTaskReadDto;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.educateion.common.dto.EduUsersDto;
import com.ssic.educateion.common.dto.SchoolDto;
import com.ssic.educateion.common.dto.TaskReceivePageDto;
import com.ssic.education.app.constants.SchoolLevel;
import com.ssic.education.app.dto.MapToListDto;
import com.ssic.education.app.dto.TaskReceiveDto;
import com.ssic.education.app.service.ICommitteeService;
import com.ssic.education.app.service.ISchoolService;
import com.ssic.education.app.service.ITaskService;
import com.ssic.education.handle.service.EduUsersService;
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

	@Autowired
	private EduUsersService eduUsersService;

	@Autowired
	private ICommitteeService committeeService;

	@Autowired
	private ISchoolService schoolService;

	/**
	 * @Title: findTaskListById
	 * @Description: 根据Id查询当前用户接收任务列表 -带分页(未读和已读-历史)readstat=1，2，3，分别表示  未读;已读和已发送
	 * @author Ken Yin  
	 * @date 2016年5月20日 下午3:17:18
	 * @return Response<EduTaskDto>    返回类型
	 */
	@RequestMapping("/findTaskListById/{id}")
	@ResponseBody
	public Response<PageResult<EduTaskDto>> findTaskListById(@PathVariable("id")String id,String readstat, PageQuery query) {
		Response<PageResult<EduTaskDto>> result = new Response<PageResult<EduTaskDto>>();
		if(StringUtils.isEmpty(id)){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("查询Id为空");
			return result;
		}
		if(StringUtils.isEmpty(readstat)){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("通知状态为空");
			return result;
		}

		PageResult<EduTaskDto> dataList = null;
		//查询当前用户接收任务列表-已读 
		if(readstat.equals("2")){
			dataList = taskService.findTaskListById(id, 1, query);
		}
		//查询当前用户接收任务列表-未读 
		if(readstat.equals("1")){
			dataList = taskService.findTaskListById(id, 0, query);
		}
		//查询当前用户发送任务列表
		if(readstat.equals("3")){
			dataList = taskService.findSendListById(id, query);
		}
		//    	dto.setReceiveReadList(dataList);
		//    	dto.setReceiveNotReadList(receiveNotReadList);
		if(dataList != null){
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功");
			result.setData(dataList);
			return result;
		}
		result.setStatus(DataStatus.HTTP_FAILE);
		result.setMessage("查询失败");
		return result;
	}

	/**
	 * @Title: findTask
	 * @Description: 根据任务Id查询任务详情
	 * @author Ken Yin  
	 * @date 2016年5月29日 下午2:41:41
	 * @return Response<EduTaskDto>    返回类型
	 */
	@RequestMapping("/findTaskByPara")
	@ResponseBody
	public Response<EduTaskDto> findTaskByPara(EduTaskDto eduTaskDto) {
		Response<EduTaskDto> result = new Response<EduTaskDto>();
		if(eduTaskDto == null){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("请求参数为空");
			return result;
		}
		if(StringUtils.isEmpty(eduTaskDto.getId())){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("任务Id为空");
			return result;
		}
		EduTaskDto taskDto = taskService.findTaskByPara(eduTaskDto);
		if(taskDto == null){
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("未查到相关任务");
			result.setData(taskDto);
			return result;
		}

		//发送的任务(显示所有接收者和  已读人数 未读人数)
		if(eduTaskDto.getTaskType() == 1){
			//查询所有接收者
			List<TaskReceivePageDto> receives = taskService.findTaskReceiveByPara(eduTaskDto.getId());
			StringBuffer sb = new StringBuffer() ;
			int reads = 0;
			int notReads = 0;
			if(receives != null && receives.size() > 0){
				for(TaskReceivePageDto receive: receives){
					sb.append(receive.getName()+";");
					if(receive.getReadstat() == 0){
						notReads++;
					}else{
						reads++;
					}
				}
			}
			eduTaskDto.setReceiveNames(sb.toString().substring(0, sb.toString().length()-1));   //去逗号
			eduTaskDto.setReads(reads);
			eduTaskDto.setNotReads(notReads);

			//已读人数

		}
		result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("查询成功");
		result.setData(eduTaskDto);
		return result;
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
	@RequestMapping("/upadteTask/{id}")
	@ResponseBody
	public Response<String> upadteTask(@PathVariable("id")String id){
		Response<String> result = new Response<String>();
		if(StringUtils.isEmpty(id)){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("任务Id为空");
			return result;
		}
		Integer flag = taskService.updateTask(id);
		if(flag > 0){
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("修改阅读状态成功");
			return result;
		}else{
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("修改阅读状态失败");
			return result;
		}
	}

	/**
	 * @Title: findReceiveList
	 * @Description: 根据任务Id查询当前任务已读和未读列表   (弃用的方法)
	 * @author Ken Yin  
	 * @date 2016年5月21日 上午11:34:50
	 * @return Response<EduTaskReadDto>    返回类型
	 */
	@Deprecated   
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
	 * @Title: chooseReceive
	 * @Description: 发送任务选择接收者接口
	 * @author Ken Yin  
	 * @date 2016年5月30日 下午1:27:53
	 * @return Response<String>    返回类型
	 */
	@RequestMapping("/chooseReceive")
	@ResponseBody
	public Response<TaskReceiveDto> chooseReceive(String id, String level,PageQuery query) {
		Response<TaskReceiveDto> result = new Response<TaskReceiveDto>();
		TaskReceiveDto taskReceiveDto = new TaskReceiveDto();
		if(StringUtils.isEmpty(id)){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("当前用户Id为空");
			return result;
		}
		//判断当前用户类型
		EduUsersDto user = new EduUsersDto();
		user.setId(id);
		EduUsersDto userInfo = eduUsersService.getUserInfo(user);
		Byte userType = -1; 
		if(userInfo != null){
			userType = userInfo.getSourceType();    //获取用户类型  : 0市教委，1学校, 2区教委 
		}
		if(userType == -1 ){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("用户类型为空");
			return result;
		}
		//当前用户是市教委
		if(userType == 0){
			EduCommitteeDto committeeDto = new EduCommitteeDto();
			committeeDto.setType((short) 2);
			List<EduCommitteeDto> committeeList = committeeService.findCommitteeListNoPage(committeeDto);
			taskReceiveDto.setEduCommitteeList(committeeList);

			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setData(taskReceiveDto);
			result.setMessage("成功获取区教委列表");
			return result;
		}
		//当前用户是区教委,则获取学校列表
		if(userType == 2){
			//获取学校类型level列表   
			List<MapToListDto> levelList = new ArrayList<MapToListDto>();
			for(Entry<Integer, String> entry: SchoolLevel.getAll().entrySet()) {
				MapToListDto mapToListDto = new MapToListDto();
				mapToListDto.setKey(entry.getKey());
				mapToListDto.setValue(entry.getValue());
				levelList.add(mapToListDto);
			}
			taskReceiveDto.setLevelList(levelList);
			//获取学校列表
			SchoolDto schoolDto = new SchoolDto();
			schoolDto.setLevel(level);
			PageResult<SchoolDto> schoolList = schoolService.findSchoolList(schoolDto, query);
			taskReceiveDto.setSchoolList(schoolList);

			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setData(taskReceiveDto);
			result.setMessage("成功获取学校列表");
			return result;

		}
		result.setStatus(DataStatus.HTTP_FAILE);
		result.setMessage("用户类型不存在");
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


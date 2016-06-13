package com.ssic.education.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.EduTaskDto;
import com.ssic.educateion.common.dto.EduTaskReadDto;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.educateion.common.dto.SchoolDto;
import com.ssic.education.app.constants.SchoolLevel;
import com.ssic.education.app.dto.MapToListDto;
import com.ssic.education.app.dto.TaskReceiveDto;
import com.ssic.education.app.service.ICommitteeService;
import com.ssic.education.app.service.ISchoolService;
import com.ssic.education.handle.service.EduUsersService;
import com.ssic.education.handle.service.ITaskService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.StringUtils;
import com.ssic.education.utils.util.UUIDGenerator;

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
	protected static final Log logger = LogFactory.getLog(TaskController.class);
	
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
	@Deprecated
	public Response<PageResult<EduTaskDto>> findTaskListById(@PathVariable("id")String id,String readstat, PageQuery query) {
		logger.info("id : " + id + ";readstat : " + readstat );
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
		logger.info("EduTaskDto : " + eduTaskDto );
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
			/*
			 * List<TaskReceivePageDto> receives = taskService.findTaskReceiveByPara(eduTaskDto.getId());
			 */
			EduTaskReceiveDto eduTaskReceiveDto = new EduTaskReceiveDto();
			eduTaskReceiveDto.setTaskId(eduTaskDto.getId());
			List<EduTaskReceiveDto> receives = taskService.findTaskReceiveList(eduTaskReceiveDto);
			StringBuffer sb = new StringBuffer() ;
			StringBuffer sb_read = new StringBuffer() ;
			StringBuffer sb_notRead = new StringBuffer() ;
			int reads = 0;
			int notReads = 0;
			if(receives != null && receives.size() > 0){
				for(EduTaskReceiveDto receive: receives){
					if(StringUtils.isNotEmpty(receive.getReceiveName())){
						sb.append(receive.getReceiveName()+";");
					}
					if(receive.getReadstat() == 0){
						sb_notRead.append(receive.getReceiveName()+";");
						notReads++;
					}else{
						sb_read.append(receive.getReceiveName()+";");
						reads++;
					}
				}
			}
			if(StringUtils.isNotEmpty(sb.toString())){
				taskDto.setReceiveNames(sb.toString().substring(0, sb.toString().length()-1));   //去逗号
			}
			taskDto.setReadNames(sb_read.toString());
			taskDto.setNotReadNames(sb_notRead.toString());
			taskDto.setReads(reads);
			taskDto.setNotReads(notReads);
		}
		result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("查询成功");
		result.setData(taskDto);
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
		logger.info("id : " + id );
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
	@RequestMapping("/upadteTask")
	@ResponseBody
	public Response<String> upadteTask(EduTaskReceiveDto receiveDto){
		logger.info("EduTaskReceiveDto : " + receiveDto );
		Response<String> result = new Response<String>();
		if(receiveDto == null){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("参数为空");
			return result;
		}
		if(StringUtils.isEmpty(receiveDto.getTaskId()) ){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("任务Id为空");
			return result;
		}
		if(StringUtils.isEmpty(receiveDto.getReceiveId())){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("阅读者Id为空");
			return result;
		}
		Integer flag = taskService.updateTask(receiveDto);
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
		logger.info("id : " + id );
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
	
	@RequestMapping("/chooseReceive")
	@ResponseBody
	public Response<TaskReceiveDto> chooseReceive(Integer sourceType, String level,PageQuery query, String committeeId ,String schoolName) {
		logger.info("sourceType : " + sourceType + ";committeeId : " + committeeId  + ";schoolName : " + schoolName );
		Response<TaskReceiveDto> result = new Response<TaskReceiveDto>();
		if(level != null && level.equals("-1")){
			level = null;
		}
		TaskReceiveDto taskReceiveDto = new TaskReceiveDto();
		if(sourceType == null){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("教委或学校类型为空");
			return result;
		}
		
		//当前用户是市教委
		if(sourceType == 0){
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
		if(sourceType == 2){
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
			schoolDto.setCommitteeId(committeeId);   				 //设置区教委
			if(StringUtils.isNotEmpty(schoolName)){ 
				schoolDto.setSchoolName(schoolName);                //学校名
			}
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
		logger.info("EduTaskDto : " + eduTaskDto);
		Response<String> result = new Response<String>();
		if(eduTaskDto == null){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("参数为空");
			return result;
		}
		if(StringUtils.isEmpty(eduTaskDto.getTitle()) ){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("标题为空");
			return result;
		}
		if(eduTaskDto.getTitle().length() > 20){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("标题长度超过20个字符");
			return result;
		}
		if(StringUtils.isEmpty(eduTaskDto.getContent()) ){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("任务内容为空");
			return result;
		}
		if(StringUtils.isEmpty(eduTaskDto.getReceiveIdsNames()) ){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("任务接收者为空");
			return result;
		}
		if(StringUtils.isEmpty(eduTaskDto.getSendIdsNames()) ){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("任务发送者为空");
			return result;
		}
		int addReceiveFlag = 0;
		
		//接收者id和名字
		String receiveIdsNames = eduTaskDto.getReceiveIdsNames();
		String receiveIds = receiveIdsNames.substring(0,receiveIdsNames.length()-1);   //去逗号
		String idsNames[] = receiveIds.split(",");    //获取接收者Id 和name
		int length = idsNames.length;
		eduTaskDto.setId(UUIDGenerator.getUUID());
		eduTaskDto.setCreateTime(new Date());
		eduTaskDto.setStat(DataStatus.ENABLED);
		
		//发送者id和名字
		String sendIdsNames = eduTaskDto.getSendIdsNames();   
		String sendIdsNames_[] = sendIdsNames.split(";");    //获取接收者Id 和name
		eduTaskDto.setCreateId(sendIdsNames_[0]);
		eduTaskDto.setCreateName(sendIdsNames_[1]);
		
		String id = taskService.sendTask(eduTaskDto);
		
		if(id != null){
			List<EduTaskReceiveDto> receiveDtoList = new ArrayList<EduTaskReceiveDto>();
			/*EduCommitteeDto committeeDto = new EduCommitteeDto();
			List<EduCommitteeDto> list = committeeService.findCommitteeListNoPage(committeeDto);
			String sendName = "";
			if(list !=null && list.size()> 0){
				sendName = list.get(0).getName();
			}*/
			//市教委发送给区教委
				for(String i: idsNames){
					EduTaskReceiveDto receiveDto = new EduTaskReceiveDto();
					String idsNames_[] = i.split(";");
					receiveDto.setReceiveId(idsNames_[0]);
					receiveDto.setReceiveName(idsNames_[1]);
					receiveDto.setTaskId(eduTaskDto.getId());
					
					receiveDto.setTaskTitle(eduTaskDto.getTitle());
					receiveDto.setSendName(sendIdsNames_[1]);
					receiveDto.setCreateId(sendIdsNames_[0]);     //插入创建者sourceId
					
					receiveDto.setId(UUIDGenerator.getUUID());
					receiveDto.setReadstat(DataStatus.DISABLED);
					receiveDto.setCreateTime(new Date());
					receiveDto.setStat(DataStatus.ENABLED);
					receiveDtoList.add(receiveDto);
				}
				 addReceiveFlag = taskService.addTaskReceiveBatch(receiveDtoList);
		}
		
		if(addReceiveFlag == length){
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


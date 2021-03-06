package com.ssic.education.government.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.educateion.common.dto.EduTaskDto;
import com.ssic.educateion.common.dto.EduTaskReceiveDto;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.IEduCommitteeService;
import com.ssic.education.handle.service.IEduInformationService;
import com.ssic.education.handle.service.ITaskReceiveService;
import com.ssic.education.handle.service.ITaskService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.UUIDGenerator;

@Controller
@RequestMapping(value = "motive")
public class MotiveController extends BaseController {

	@Autowired
	private IEduCommitteeService iEduCommitteeService;

	@Autowired
	private EduSchoolService eduSchoolService;

	@Autowired
	private IEduInformationService iEduInformationService;
	
//	@Autowired
//	private ITaskReceiveService iTaskReceiveService;
	
	@Autowired
	private ITaskService iTaskService;
	
	@Autowired
	private ITaskReceiveService iTaskReceiveService;
	
	
	/**
	 * 
		 * 此方法描述的是：异步删除
		 * @author: cwftalus@163.com
		 * @version: 2016年5月30日 下午7:06:52
	 */
	@RequestMapping(value="ajaxDelete")
	@ResponseBody
	public Response<String> ajaxDelete(EduTaskReceiveDto eduTaskReceiveDto){
		Response<String> response = new Response<String>();

		int result = iTaskReceiveService.updateEduTaskReceive(eduTaskReceiveDto);
		
		return response;
	}
	
	/**
	 * 
		 * 此方法描述的是：查询联系人列表异步
		 * @author: cwftalus@163.com
		 * @version: 2016年5月30日 下午7:06:52
	 */
	@RequestMapping(value="ajaxSearch")
	@ResponseBody
	public Response<List<InfoList>> ajaxSearch(String name){
		Response<List<InfoList>> response = new Response<List<InfoList>>();
		List<InfoList> dataList = new ArrayList<MotiveController.InfoList>();
		if (Objects.equal(getEduUsersDto().getSourceType(), Byte.valueOf("0"))) {// 查询市教委下的区教委信息
			EduCommitteeDto eduCommitteeDto = new EduCommitteeDto();
			eduCommitteeDto.setType(Short.valueOf("2"));
			eduCommitteeDto.setName(name);
			List<EduCommitteeDto> resultList = iEduCommitteeService.queryCommittee(eduCommitteeDto);
			if(resultList!=null && resultList.size()>0){
				dataList = copyProperty(resultList);	
			}
		} else if (Objects.equal(getEduUsersDto().getSourceType(),Byte.valueOf("2"))) {// 查询区县教委下的学校信息
			EduSchoolDto eduSchoolDto = new EduSchoolDto();
			eduSchoolDto.setCommitteeId(getEduUsersDto().getSourceId());
			eduSchoolDto.setSchoolName(name);
			List<EduSchoolDto> resultList = eduSchoolService.searchEduScholDtoList(eduSchoolDto);
			if(resultList!=null && resultList.size()>0){
				dataList = copyProperty(resultList);	
			}
		}
		response.setData(dataList);
		return response;
	}
	
	/**
	 * 
	 * 此方法描述的是：发布
	 * 市教委  新建 0
	 * 区教委  新建 未读 已读 已发 2
	 * 学校 未读 已读 1
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:41:57
	 */
	@RequestMapping(value = "release")
	public ModelAndView index() {
		ModelAndView mv = getModelAndView();

		// 0市教委，1学校, 2区教委
		List<InfoList> dataList = new ArrayList<MotiveController.InfoList>();
		if (Objects.equal(getEduUsersDto(),null)) {// 查询市教委下的区教委信息
			return new ModelAndView("redirect:/login.htm");
		}
		if (Objects.equal(getEduUsersDto().getSourceType(), Byte.valueOf("0"))) {// 查询市教委下的区教委信息
			EduCommitteeDto eduCommitteeDto = new EduCommitteeDto();
			eduCommitteeDto.setType(Short.valueOf("2"));
			List<EduCommitteeDto> resultList = iEduCommitteeService.queryCommittee(eduCommitteeDto);
			dataList = copyProperty(resultList);
		} else if (Objects.equal(getEduUsersDto().getSourceType(),
				Byte.valueOf("2"))) {// 查询区县教委下的学校信息
			EduSchoolDto eduSchoolDto = new EduSchoolDto();
			eduSchoolDto.setCommitteeId(getEduUsersDto().getSourceId());
			eduSchoolDto.setReviewed(Byte.valueOf("1"));//审核通过的 
			List<EduSchoolDto> resultList = eduSchoolService.searchEduScholDtoList(eduSchoolDto);
			if(resultList!=null && resultList.size()>0){
				dataList = copyProperty(resultList);	
			}
		}else{
			
		}
		
		getSourceType(mv);
		
		mv.addObject("dataList", dataList);
		mv.setViewName("motive/dis_edu_motive_release");
		return mv;
	}
	
	
	public void getSourceType(ModelAndView mv){
		if(getEduUsersDto()!=null){
			mv.addObject("sourceType", getEduUsersDto().getSourceType());	
		}
		
	}

	/**
	 * 
	 * 此方法描述的是：发布 -->保存
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:03
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public Response<String> save(EduTaskDto eduTaskDto) {
		Response<String> response = new Response<String>();
		eduTaskDto.setContent(eduTaskDto.getEditorValue());
		
		String infoId = UUIDGenerator.getUUID32Bit();
		eduTaskDto.setId(infoId);
		eduTaskDto.setCreateId(getEduUsersDto().getSourceId());//创建者的Id修改为该登录用户的类型 教委 或学校
		eduTaskDto.setCreateName(getEduUsersDto().getName());

//		int result = iEduInformationService.saveInfomation(eduTaskDto);
		int result = iTaskService.saveInfomation(eduTaskDto);
		if (!(result > 0)) {
			response.setStatus(DataStatus.HTTP_FAILE);
		} else {
			// String lianxiIds = getRequest().getParameter("lianxiIds");
			List<EduTaskReceiveDto> dataList = copyList(eduTaskDto);
			if (dataList != null) {
				iTaskReceiveService.saveList(dataList);
			}
		}
		return response;
	}

	public List<EduTaskReceiveDto> copyList(EduTaskDto eduTaskDto) {
		List<EduTaskReceiveDto> dList = null;
		// if(!StringUtils.isNotEmpty(lianxiIds)){
		String[] lianxiId = getRequest().getParameterValues("lianxiIds");
		dList = new ArrayList<EduTaskReceiveDto>();
		for (String lxId : lianxiId) {
			String[] idName = lxId.split("#");
			EduTaskReceiveDto dto = new EduTaskReceiveDto();
			dto.setCreateId(eduTaskDto.getCreateId());
			dto.setTaskId(eduTaskDto.getId());
			dto.setTaskTitle(eduTaskDto.getTitle());
			dto.setReceiveId(idName[0]);
			dto.setReceiveName(idName[1]);
			dto.setSendName(eduTaskDto.getCreateName());
			dList.add(dto);
		}
		// }
		return dList;
	}

	/**
	 * 
	 * 此方法描述的是：未读
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value = "unreaded")
	public ModelAndView unreaded(EduTaskReceiveDto eduTaskReceiveDto,PageQuery pageQuery) {
		ModelAndView mv = getModelAndView();

		String sourceId = getEduUsersDto().getSourceId();//用户所属教委 或学校
		eduTaskReceiveDto.setReceiveId(sourceId);
		eduTaskReceiveDto.setReadstat(DataStatus.DISABLED);
//		PageResult<EduInformationListDto> pageList = iTaskReceiveService.searchEduTaskReceive(eduInformationListDto,pageQuery);
		PageResult<EduTaskReceiveDto> pageList = iTaskReceiveService.searchEduTaskReceive(eduTaskReceiveDto,pageQuery);
		
		getSourceType(mv);
		mv.addObject("pageList", pageList);
		mv.setViewName("motive/dis_edu_motive_unreaded");
		return mv;
	}

	/**
	 * 
	 * 此方法描述的是：发送的
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value = "sended")
	public ModelAndView sended(EduTaskReceiveDto eduTaskReceiveDto,PageQuery pageQuery) {
		ModelAndView mv = getModelAndView();
		
		EduTaskDto eduTaskDto = new EduTaskDto();
		eduTaskDto.setCreateId(getEduUsersDto().getSourceId());
		PageResult<EduTaskDto> pageList = iTaskService.searchTask(eduTaskDto, pageQuery);
		
		eduTaskReceiveDto.setCreateId(getEduUsersDto().getSourceId());//创建者的Id修改为该登录用户的类型 教委 或学校
		List<EduTaskReceiveDto> dataList = iTaskReceiveService.searchEduTaskReceive(eduTaskReceiveDto);

		if(dataList!=null && dataList.size()>0){
			HashMap<String,List<EduTaskReceiveDto>> beanMapList = copyListToTaskReceiceMap(dataList);
			
			for(EduTaskDto task  : pageList.getResults()){
				task.setTaskReceiceList(beanMapList.get(task.getId()));
			}
		}

		getSourceType(mv);
		mv.addObject("pageList", pageList);
		mv.setViewName("motive/dis_edu_motive_sended");
		return mv;
	}

	private HashMap<String, List<EduTaskReceiveDto>> copyListToTaskReceiceMap(List<EduTaskReceiveDto> dataList) {
		HashMap<String,List<EduTaskReceiveDto>> readMap = new HashMap<String,List<EduTaskReceiveDto>>();
		List<EduTaskReceiveDto> resultList = null;
		for(EduTaskReceiveDto mapDto :dataList){
			String keyCode = mapDto.getTaskId();
			if(readMap.containsKey(keyCode)){
				resultList = readMap.get(keyCode);
			}else{
				resultList = new ArrayList<EduTaskReceiveDto>();
			}
			resultList.add(mapDto);
			readMap.put(keyCode, resultList);
		}
		return readMap;
	}

	/**
	 * 
	 * 此方法描述的是：发送的
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value = "readed")
	public ModelAndView readed(EduTaskReceiveDto eduTaskReceiveDto,PageQuery pageQuery) {
		ModelAndView mv = getModelAndView();

		String sourceId = getEduUsersDto().getSourceId();//用户所属教委 或学校
		eduTaskReceiveDto.setReceiveId(sourceId);
		eduTaskReceiveDto.setReadstat(DataStatus.ENABLED);
//		PageResult<EduInformationListDto> pageList = iTaskReceiveService.searchEduTaskReceive(eduInformationListDto,pageQuery);
		PageResult<EduTaskReceiveDto> pageList = iTaskReceiveService.searchEduTaskReceive(eduTaskReceiveDto,pageQuery);
		
		getSourceType(mv);
		mv.addObject("pageList", pageList);
		mv.setViewName("motive/dis_edu_motive_readed");
		return mv;
	}

	/**
	 * 
	 * 此方法描述的是：infomation 详情信息 并且修改是否读取的状态
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value = "details/{infoId}")
	public ModelAndView details(@PathVariable String infoId) {
		ModelAndView mv = getModelAndView();

		String sourceId = getEduUsersDto().getSourceId();
		
		EduTaskDto data = iTaskService.search(infoId);
		EduTaskReceiveDto eduTaskReceiveDto = new EduTaskReceiveDto();
		eduTaskReceiveDto.setReceiveId(sourceId);
		eduTaskReceiveDto.setTaskId(infoId);
		List<EduTaskReceiveDto> dataList = iTaskReceiveService.searchEduTaskReceive(eduTaskReceiveDto);
		if(dataList!=null && dataList.size()>0){
			eduTaskReceiveDto = dataList.get(0);
			eduTaskReceiveDto.setReadstat(DataStatus.ENABLED);
			eduTaskReceiveDto.setReadTime(new Date());
			iTaskReceiveService.updateEduTaskReceive(eduTaskReceiveDto);			
		}

		//获取已读未读 数据
		EduTaskReceiveDto listDto = new EduTaskReceiveDto();
		listDto.setTaskId(infoId);
		List<EduTaskReceiveDto> resultList = iTaskReceiveService.searchEduTaskReceive(listDto);
		HashMap<String,Integer> readMap = new HashMap<String, Integer>();	
		if(resultList!=null && resultList.size()>0){
			readMap = copyListToMap(resultList);	
		}
		
		boolean isowner = false;
		if(Objects.equal(sourceId,data.getCreateId())){
			isowner = true;
		}
		
		mv.addObject("isowner", isowner);
		mv.addObject("resultList",resultList);//已读未读的所有数据
		mv.addObject("readMap", readMap);
		mv.addObject("data", data);
		mv.setViewName("motive/dis_edu_motice_detail");
		return mv;
	}

	private HashMap<String, Integer> copyListToMap(List<EduTaskReceiveDto> resultList) {
		HashMap<String,Integer> readMap = new HashMap<String,Integer>();
		int read = 0;
		int unread = 0;
		for(EduTaskReceiveDto mapDto :resultList){
			if(Objects.equal(mapDto.getReadstat(),DataStatus.ENABLED)){
				if(readMap.containsKey("read")){
					read = readMap.get("read");
					readMap.put("read",read+1);
				}else{
					readMap.put("read",1);
				}
			}
			if(Objects.equal(mapDto.getReadstat(),DataStatus.DISABLED)){
				if(readMap.containsKey("unread")){
					unread = readMap.get("unread");
					readMap.put("unread",unread+1);
				}else{
					readMap.put("unread",1);
				}
			}
		}
		return readMap;
	}

	public List<InfoList> copyProperty(Object xObj) {
		List<InfoList> infoList = new ArrayList<MotiveController.InfoList>();
		if (xObj instanceof List<?>) {
			if (((List<?>) xObj).get(0) instanceof EduCommitteeDto) {
				List<EduCommitteeDto> dataList = (List<EduCommitteeDto>) xObj;
				for (EduCommitteeDto obj : dataList) {
					InfoList e = new InfoList();
					e.setId(obj.getId());
					e.setName(obj.getName());
					infoList.add(e);
				}
			} else if (((List<?>) xObj).get(0) instanceof EduSchoolDto) {
				List<EduSchoolDto> dataList = (List<EduSchoolDto>) xObj;
				for (EduSchoolDto obj : dataList) {
					InfoList e = new InfoList();
					e.setId(obj.getId());
					e.setName(obj.getSchoolName());
					infoList.add(e);
				}
			}
		}
		return infoList;
	}

	@Data
	public class InfoList implements Serializable {
		private String id;
		private String name;

	}

}

package com.ssic.education.app.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.education.app.service.ICommitteeService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;

/**
 * @ClassName: CommitteeController
 * @Description: 教委comtroller
 * @author Ken Yin
 * @date 2016年5月23日 下午4:53:16
 *
 */
@Controller
@RequestMapping(value = "committee")
public class CommitteeController {
	protected static final Log logger = LogFactory.getLog(CommitteeController.class);

	@Autowired
	private ICommitteeService committeeService;

	/**
	 * @Title: findCommitteeList
	 * @Description: 查询全部区教委列表-带分页
	 * @author Ken Yin  
	 * @date 2016年5月23日 下午4:55:23
	 * @return Response<PageResult<EduCommitteeDto>>    返回类型
	 */
	@RequestMapping("/findCommitteeList")
	@ResponseBody
	public Response<PageResult<EduCommitteeDto>>  findCommitteeList(EduCommitteeDto eduCommitteeDto, PageQuery query) {
		logger.info("EduCommitteeDto : " + eduCommitteeDto);
		Response<PageResult<EduCommitteeDto>> result = new Response<PageResult<EduCommitteeDto>>();
		PageResult<EduCommitteeDto> committeeList = committeeService.findCommitteeList(eduCommitteeDto, query);
		if(committeeList.getResults() != null && committeeList.getResults().size() >0 ){
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(committeeList);
			return result;
		}else{
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("未查到相关记录！");
			return result;
		}
	}

	/**
	 * @Title: findCommitteeListNoPage
	 * @Description: 查询全部区教委列表-不带分页
	 * @author Ken Yin  
	 * @date 2016年5月23日 下午4:55:23
	 * @return Response<PageResult<EduCommitteeDto>>    返回类型
	 */
	@RequestMapping("/findCommitteeListNoPage")
	@ResponseBody
	public Response<List<EduCommitteeDto>>  findCommitteeListNoPage(EduCommitteeDto eduCommitteeDto) {
		logger.info("EduCommitteeDto : " + eduCommitteeDto);
		Response<List<EduCommitteeDto>> result = new Response<List<EduCommitteeDto>>();
		List<EduCommitteeDto> committeeList = committeeService.findCommitteeListNoPage(eduCommitteeDto);
		if(committeeList != null && committeeList.size() >0 ){
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(committeeList);
			return result;
		}else{
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("未查到相关记录！");
			return result;
		}
	}

}


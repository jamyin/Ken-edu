package com.ssic.education.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.EduAreaDto;
import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.education.handle.service.AreaService;
import com.ssic.education.handle.service.IEduCommitteeService;
import com.ssic.education.utils.model.Response;

@Controller
@RequestMapping(value="/area")
public class AreaController extends BaseController{

	@Autowired
	private AreaService areaService;
	

	@Autowired
	private IEduCommitteeService iEduCommitteeService;
	
	@RequestMapping(value="/init")
	@ResponseBody
	public List<EduAreaDto> init() {
		List<EduAreaDto> result = areaService.queryAll();
		// TODO Auto-generated constructor stub
		return result;
	}
	
	@RequestMapping(value="/committee")
	@ResponseBody
	public Response<List<EduCommitteeDto>> committee(EduCommitteeDto eduCommitteeDto) {
		Response<List<EduCommitteeDto>> result = new Response<List<EduCommitteeDto>>();
		List<EduCommitteeDto> dataList = iEduCommitteeService.queryCommittee(eduCommitteeDto);
		result.setData(dataList);
		return result;
	}

}

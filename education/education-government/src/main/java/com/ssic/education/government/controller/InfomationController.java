package com.ssic.education.government.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.education.handle.service.IEduInformationService;
import com.ssic.education.utils.model.Response;

@Controller
@RequestMapping(value="info")
public class InfomationController extends BaseController{

	@Autowired
	private IEduInformationService iEduInformationService;
	
	@RequestMapping(value="notice")
	public ModelAndView notice(){
		ModelAndView mv = getModelAndView();
		
		mv.setViewName("info/notice");
		return mv;
	}
	
	
	@RequestMapping(value="save")
	@ResponseBody
	public Response<String> save(EduInformationDto eduInformationDto){
		Response<String> response = new Response<String>();
		eduInformationDto.setContent(eduInformationDto.getEditorValue());
		int result = iEduInformationService.saveInfomation(eduInformationDto);
		
		return response;
	}

}

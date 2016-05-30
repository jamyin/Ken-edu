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
@RequestMapping(value="motive")
public class MotiveController  extends BaseController{
	
	@Autowired
	private IEduInformationService iEduInformationService;
	/**
	 * 
		 * 此方法描述的是：发布
		 * @author: cwftalus@163.com
		 * @version: 2016年5月30日 上午10:41:57
	 */
	@RequestMapping(value="release")
	public ModelAndView index(){
		ModelAndView mv = getModelAndView();
		
		mv.setViewName("motive/dis_edu_motive_release");
		return mv;
	}
	/**
	 * 
		 * 此方法描述的是：发布 -->保存
		 * @author: cwftalus@163.com
		 * @version: 2016年5月30日 上午10:42:03
	 */
	@RequestMapping(value="save")
	@ResponseBody
	public Response<String> save(EduInformationDto eduInformationDto){
		Response<String> response = new Response<String>();
		eduInformationDto.setContent(eduInformationDto.getEditorValue());
		int result = iEduInformationService.saveInfomation(eduInformationDto);
		
		return response;
	}
	/**
	 * 
		 * 此方法描述的是：未读
		 * @author: cwftalus@163.com
		 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value="unreaded")
	public ModelAndView unreaded(){
		ModelAndView mv = getModelAndView();
		
		mv.setViewName("motive/dis_edu_motive_unreaded");
		return mv;
	}
	
	/**
	 * 
		 * 此方法描述的是：发送的
		 * @author: cwftalus@163.com
		 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value="sended")
	public ModelAndView sended(){
		ModelAndView mv = getModelAndView();
		
		mv.setViewName("motive/dis_edu_motive_sended");
		return mv;
	}
	
	/**
	 * 
		 * 此方法描述的是：发送的
		 * @author: cwftalus@163.com
		 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value="readed")
	public ModelAndView readed(){
		ModelAndView mv = getModelAndView();
		
		mv.setViewName("motive/dis_edu_motive_readed");
		return mv;
	}

}

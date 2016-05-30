package com.ssic.education.government.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Objects;
import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.educateion.common.dto.EduInformationListDto;
import com.ssic.educateion.common.dto.EduSchoolDto;
import com.ssic.education.government.controller.MotiveController.InfoList;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.IEduCommitteeService;
import com.ssic.education.handle.service.IEduInformationListService;
import com.ssic.education.handle.service.IEduInformationService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.UUIDGenerator;

@Controller
@RequestMapping(value = "info")
public class InfomationController extends BaseController {
	
	@Autowired
	private IEduInformationService iEduInformationService;

	@Autowired
	private IEduCommitteeService iEduCommitteeService;

	@Autowired
	private EduSchoolService eduSchoolService;

	@Autowired
	private IEduInformationListService iEduInformationListService;

	/**
	 * 
	 * 此方法描述的是：发布
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:41:57
	 */
	@RequestMapping(value = "release")
	public ModelAndView index() {
		ModelAndView mv = getModelAndView();

		mv.setViewName("info/dis_edu_motive_release");
		return mv;
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
	public Response<String> save(EduInformationDto eduInformationDto) {
		Response<String> response = new Response<String>();
		eduInformationDto.setContent(eduInformationDto.getEditorValue());
		String infoId = UUIDGenerator.getUUID32Bit();
		eduInformationDto.setId(infoId);
		int result = iEduInformationService.saveInfomation(eduInformationDto);
		if (!(result > 0)) {
			response.setStatus(DataStatus.HTTP_FAILE);
		}
		return response;
	}

}

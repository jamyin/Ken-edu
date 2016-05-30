package com.ssic.education.government.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.education.handle.service.EduSchoolService;
import com.ssic.education.handle.service.IEduCommitteeService;
import com.ssic.education.handle.service.IEduInformationListService;
import com.ssic.education.handle.service.IEduInformationService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
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
	@RequestMapping(value = "index/{type}")
	public ModelAndView index(@PathVariable String type,PageQuery pageQuery) {
		ModelAndView mv = getModelAndView();
		EduInformationDto eduInformationDto = new EduInformationDto();
		eduInformationDto.setType(Integer.valueOf(type));
		PageResult<EduInformationDto> pageList =  iEduInformationService.searchInfomation(eduInformationDto,pageQuery);
		mv.addObject("type",type);
		mv.addObject("pageList", pageList);
		mv.setViewName("info/dis_edu_motive_index");
		return mv;
	}
	
	
	/**
	 * 
	 * 此方法描述的是：发布
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:41:57
	 */
	@RequestMapping(value = "release")
	public ModelAndView release() {
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
	
	
	/**
	 * 
	 * 此方法描述的是：infomation 详情信息
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月30日 上午10:42:24
	 */
	@RequestMapping(value = "details/{infoId}")
	public ModelAndView details(@PathVariable String infoId,PageQuery pageQuery) {
		ModelAndView mv = getModelAndView();

		EduInformationDto data = iEduInformationService.search(infoId);
		
		EduInformationDto eduInformationDto = new EduInformationDto();
		eduInformationDto.setType(data.getType());
		PageResult<EduInformationDto> pageList =  iEduInformationService.searchInfomation(eduInformationDto,pageQuery);
		mv.addObject("pageList", pageList);
		
		mv.addObject("data", data);
		mv.setViewName("info/dis_edu_motice_detail");
		return mv;
	}

}

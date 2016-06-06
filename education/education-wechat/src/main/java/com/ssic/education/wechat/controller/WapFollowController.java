package com.ssic.education.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.handle.dto.EduParentScChDto;
import com.ssic.education.handle.service.IEduParentScChService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.Response;

/**
 * 
 * 此类描述的是：wap 和学校信息相关的接口信息
 * 
 * @author: cwftalus@163.com
 * @version: 2016年5月21日 下午2:18:27
 */
@Controller
@RequestMapping(value = "/wap/follow")
public class WapFollowController extends BaseController {
	
	
	@Autowired
	private IEduParentScChService iEduParentScChService;
	
	
	/**
	 * 
	 * 此方法描述的是：我的关注列表
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月21日 下午3:31:44
	 */
	@RequestMapping(value = "index")
	public ModelAndView index(EduParentScChDto eduParentScChDto,String code) {
		
		setWeixinOpenId(code);
		
		ModelAndView mv = getModelAndView();
		eduParentScChDto.setParentId(parentId);
		List<EduParentScChDto> dataList = iEduParentScChService.searchParentScChDtoList(eduParentScChDto);
		
		mv.addObject("dataList",dataList);
		mv.setViewName("follow");
		return mv;
	}
	
	
	/**
	 * 
	 * 此方法描述的是：关注 相当于保存信息处理
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月21日 下午3:31:44
	 */
	@RequestMapping(value = "follow")
	@ResponseBody
	public Response<EduParentScChDto> follow(EduParentScChDto eduParentScChDto) {
		Response<EduParentScChDto> result = new Response<EduParentScChDto>();

		eduParentScChDto.setParentId(parentId);
		int data = iEduParentScChService.saveFollow(eduParentScChDto);
		if (data > 0) {
			result.setMessage("关注成功");
		} else {
			result.setStatus(DataStatus.HTTP_FAILE);
		}
		return result;
	}

	/**
	 * 
	 * 此方法描述的是：取消关注
	 * 
	 * @author: cwftalus@163.com
	 * @version: 2016年5月24日 下午2:15:12
	 */
	@RequestMapping(value = "unFollow")
	@ResponseBody
	public Response<EduParentScChDto> unFollow(EduParentScChDto eduParentScChDto) {
		Response<EduParentScChDto> result = new Response<EduParentScChDto>();
		eduParentScChDto.setStat(DataStatus.DISABLED);
		int data = iEduParentScChService.updateFollow(eduParentScChDto);
		if (data > 0) {
			result.setMessage("操作成功");
		} else {
			result.setStatus(DataStatus.HTTP_FAILE);
		}
		return result;
	}
}

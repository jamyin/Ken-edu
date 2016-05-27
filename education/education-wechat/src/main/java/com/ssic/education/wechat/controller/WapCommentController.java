package com.ssic.education.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.handle.dto.EduParentPackCommentDto;
import com.ssic.education.handle.service.IEduParentPackCommentService;
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
@RequestMapping(value = "/wap/comment")
public class WapCommentController extends BaseController {
	
	
	@Autowired
	private IEduParentPackCommentService iEduParentPackCommentService;
	
	/**
	 * 
		 * 此方法描述的是：进入某一个菜的点评功能页面
		 * @author: cwftalus@163.com
		 * @version: 2016年5月23日 下午3:50:56
	 */
	@RequestMapping(value="/join/{packageId}")
	public ModelAndView join(@PathVariable String packageId){	
		ModelAndView mv = getModelAndView();

		mv.addObject("packageId", packageId);
		mv.setViewName("join");
		return mv;
	}
	
	/**
	 * 
		 * 此方法描述的是：针对某一菜进行评价
		 * @author: cwftalus@163.com
		 * @version: 2016年5月23日 下午3:50:56
	 */
	@RequestMapping(value="comment")
	@ResponseBody
	public Response<String> comment(EduParentPackCommentDto eduParentPackCommentDto){
		Response<String> result = new Response<String>();
		eduParentPackCommentDto.setParentId(parentId);
		int data = iEduParentPackCommentService.saveComment(eduParentPackCommentDto);
		if (data > 0) {
			result.setMessage("点评成功");
		} else {
			result.setStatus(DataStatus.HTTP_FAILE);
		}		
		return result;
	}
	/**
	 * 
		 * 此方法描述的是：查询菜对应的点评信息 我的点评信息
		 * @author: cwftalus@163.com
		 * @version: 2016年5月24日 上午9:26:45
	 */
	@RequestMapping(value="index")
	public ModelAndView searchComment(EduParentPackCommentDto eduParentPackCommentDto){
		
		ModelAndView mv = getModelAndView();

		eduParentPackCommentDto.setParentId(parentId);
		List<EduParentPackCommentDto> dataList = iEduParentPackCommentService.searchComment(eduParentPackCommentDto);
		
		mv.addObject("dataList",dataList);
		mv.setViewName("comment");
		return mv;
	}	
	
	
//	/**
//	 * 
//	 * 此方法描述的是：关注 相当于保存信息处理
//	 * 
//	 * @author: cwftalus@163.com
//	 * @version: 2016年5月21日 下午3:31:44
//	 */
//	@RequestMapping(value = "follow")
//	@ResponseBody
//	public Response<EduParentScChDto> follow(EduParentScChDto eduParentScChDto) {
//		Response<EduParentScChDto> result = new Response<EduParentScChDto>();
//
//		eduParentScChDto.setParentId(parentId);
//		int data = iEduParentScChService.saveFollow(eduParentScChDto);
//		if (data > 0) {
//			result.setMessage("关注成功");
//		} else {
//			result.setStatus(DataStatus.HTTP_FAILE);
//		}
//		return result;
//	}
//
//	/**
//	 * 
//	 * 此方法描述的是：取消关注
//	 * 
//	 * @author: cwftalus@163.com
//	 * @version: 2016年5月24日 下午2:15:12
//	 */
//	@RequestMapping(value = "unFollow")
//	@ResponseBody
//	public Response<EduParentScChDto> unFollow(EduParentScChDto eduParentScChDto) {
//		Response<EduParentScChDto> result = new Response<EduParentScChDto>();
//		eduParentScChDto.setStat(DataStatus.DISABLED);
//		int data = iEduParentScChService.updateFollow(eduParentScChDto);
//		if (data > 0) {
//			result.setMessage("操作成功");
//		} else {
//			result.setStatus(DataStatus.HTTP_FAILE);
//		}
//		return result;
//	}
}

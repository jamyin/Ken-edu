package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.education.app.service.IInformationService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.StringUtils;

/**
* @ClassName: InformationController
* @Description: 资讯controller (1:公告 2:卫生检查 3:健康宣教)  
* @author Ken Yin
* @date 2016年5月20日 上午10:41:26
*
 */
@Controller
@RequestMapping(value = "information")
public class InformationController {
	
	@Autowired
	private IInformationService informationService;
    
	   /**
	   * @Title: findInformationList
	   * @Description: 查询全部公告列表
	   * @author Ken Yin  
	   * @date 2016年5月20日 上午10:26:05
	   * @return Response<PageResult<EduInformationDto>>    返回类型
	    */
	    @RequestMapping("/findInformationList")
	    @ResponseBody
	    public Response<PageResult<EduInformationDto>>  findInformationList(EduInformationDto eduInformationDto, PageQuery query) {
	    	Response<PageResult<EduInformationDto>> result = new Response<PageResult<EduInformationDto>>();
	    	PageResult<EduInformationDto> informationList = informationService.findInformationList(eduInformationDto, query);
	    	if(informationList != null ){
	    		result.setStatus(DataStatus.HTTP_SUCCESS);
	    		result.setMessage("查询成功！");
	    		result.setData(informationList);
	    		return result;
	    	}else{
	    		result.setStatus(DataStatus.HTTP_SUCCESS);
	    		result.setMessage("未查到相关记录！");
	    		return result;
	    	}
	    }
		
	    /**
	    * @Title: findInformationDetialList
	    * @Description: 根据公告id查公告详细信息
	    * @author Ken Yin  
	    * @date 2016年5月20日 上午10:29:45
	    * @return Response<PageResult<EduInformationDto>>    返回类型
	     */
	    @RequestMapping("/findInformationDetial/{id}")
	    @ResponseBody
	    public Response<EduInformationDto> findInformationDetial(@PathVariable("id")String id) {
	    	Response<EduInformationDto> result = new Response<EduInformationDto>();
	    	if(StringUtils.isEmpty(id)){
	     		result.setStatus(DataStatus.HTTP_FAILE);
	     		result.setMessage("查询Id为空");
	     		return result;
	     	}
	    	EduInformationDto dto = informationService.findInformationDetial(id);
	    	if(dto != null){
	    		result.setStatus(DataStatus.HTTP_SUCCESS);
	    		result.setMessage("查询成功！");
	    		result.setData(dto);
	    		return result;
	    	}else{
	    		result.setStatus(DataStatus.HTTP_SUCCESS);
	    		result.setMessage("未查到相关记录！");
	    		return result;
	    	}
	    }
}


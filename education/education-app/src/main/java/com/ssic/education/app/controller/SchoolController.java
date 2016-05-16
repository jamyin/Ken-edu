package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.service.ISchoolService;
import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.util.constants.DataStatus;
import com.ssic.util.model.PageQuery;
import com.ssic.util.model.PageResult;
import com.ssic.util.model.Response;

/**
* @ClassName: AreaController
* @Description: 查询上海市全部区县controller
* @author Ken Yin
* @date 2016年5月12日 上午10:30:02
*
 */
@Controller
@RequestMapping(value = "/school")
public class SchoolController {
	
	@Autowired
	private ISchoolService schoolService;
    
   /**
   * @Title: findSchoolList
   * @Description: 查询全部学校列表
   * @author Ken Yin  
   * @date 2016年5月13日 上午9:14:56
   * @return Response<PageResult<EduSchoolDto>>    返回类型
    */
    @RequestMapping("/findSchoolList")
    @ResponseBody
    public Response<PageResult<EduSchoolDto>>  findSchoolList(EduSchoolDto eduSchoolDto, PageQuery query) {
    	Response<PageResult<EduSchoolDto>> result = new Response<PageResult<EduSchoolDto>>();
    	PageResult<EduSchoolDto> schoolList = schoolService.findSchoolList(eduSchoolDto, query);
    	if(schoolList.getResults() != null && schoolList.getResults().size() >0 ){
    		result.setStatus(DataStatus.HTTP_SUCCESS);
    		result.setMessage("查询成功！");
    		result.setData(schoolList);
    		return result;
    	}else{
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("未查到相关记录！");
    		return result;
    	}
    }
    /**
    * @Title: findSchoolDetialList
    * @Description: 根据学校id查学校信息（需要带出当天全部年级菜单）
    * @author Ken Yin  
    * @date 2016年5月13日 上午10:53:53
    * @return Response<PageResult<EduSchoolDto>>    返回类型
     */
    @RequestMapping("/findSchoolDetialList/{id}")
    @ResponseBody
    public Response<PageResult<EduSchoolDto>> findSchoolDetialList(@PathVariable("id")String id, PageQuery query) {
    	Response<PageResult<EduSchoolDto>> result = new Response<PageResult<EduSchoolDto>>();
    	PageResult<EduSchoolDto> schoolDetialList = schoolService.findSchoolDetialList(id, query);
    	if(schoolDetialList.getResults() != null && schoolDetialList.getResults().size() >0 ){
    		result.setStatus(DataStatus.HTTP_SUCCESS);
    		result.setMessage("查询成功！");
    		result.setData(schoolDetialList);
    		return result;
    	}else{
    		result.setStatus(DataStatus.HTTP_FAILE);
    		result.setMessage("未查到相关记录！");
    		return result;
    	}
    }
}


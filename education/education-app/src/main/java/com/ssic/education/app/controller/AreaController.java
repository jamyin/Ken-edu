package com.ssic.education.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.EduAreaDto;
import com.ssic.education.app.service.IAreaService;
import com.ssic.util.constants.DataStatus;
import com.ssic.util.model.Response;

/**
* @ClassName: AreaController
* @Description: 查询上海市全部区县controller
* @author Ken Yin
* @date 2016年5月12日 上午10:30:02
*
 */
@Controller
@RequestMapping(value = "/area")
public class AreaController {
	
	@Autowired
	private IAreaService areaService;
    
   /**
    * @Title: findArea
    * @Description: 查询上海市全部区县
    * @author Ken Yin  
    * @date 2016年5月12日 上午11:27:34
    * @return Response<EduTaskDto>    返回类型
    */
    @RequestMapping("/findArea")
    @ResponseBody
    public Response<List<EduAreaDto>> findArea(EduAreaDto eduAreaDto) {
    	Response<List<EduAreaDto>> result = new Response<List<EduAreaDto>>();
    	List<EduAreaDto> areaList = areaService.findArea(eduAreaDto);
    	if(areaList.size()>0){
    		result.setStatus(DataStatus.HTTP_SUCCESS);
    		result.setMessage("查询成功！");
    		result.setData(areaList);
    		return result;
    	}else{
    		result.setStatus(DataStatus.HTTP_SUCCESS);
    		result.setMessage("未查到相关记录！");
    		return result;
    	}
    }
}


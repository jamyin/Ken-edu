package com.ssic.education.government.controller.api;

import com.ssic.education.common.dto.EduAreaDto;
import com.ssic.education.common.dto.EduSchoolDto;
import com.ssic.education.government.controller.BaseController;
import com.ssic.education.utils.model.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>Description: 类描述:api接口提供controller层
 *  含有接口:
 *          1.上海各地区接口
 *          2.供应学校接口
 * </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 *
 * @author wangxiang
 * @version 1.0
 * @date 2016/5/13 12:45
 */
@Controller
@RequestMapping(value = "api")
public class ApiController extends BaseController {
    protected static final Log logger = LogFactory.getLog(ApiController.class);

    /**
     * <p>Description: 返回地区接口 </p>
     * <p>Company: 上海天坊信息科技有限公司</p>
     * @return Response<List<EduAreaDto>>
     * @author wangxiang
     * @date 2016/5/13 13:18
     * @version 1.0
     */
    @RequestMapping(value = "areas")
    @ResponseBody
    public Response<List<EduAreaDto>> areas(){
        Response<List<EduAreaDto>> response = new Response<List<EduAreaDto>>();
        List<EduAreaDto> datas = queryAllareas();
        response.setData(datas);
        return response;
    }

    /**
     * <p>Description: 返回全部学校接口 </p>
     * <p>Company: 上海天坊信息科技有限公司</p>
     * @return  Response<List<EduSchoolDto>>
     * @author wangxiang
     * @date 2016/5/13 13:18
     * @version 1.0
     */
    @RequestMapping(value = "schools")
    @ResponseBody
    public Response<List<EduSchoolDto>> schools(){
        Response<List<EduSchoolDto>> response = new Response<List<EduSchoolDto>>();
        List<EduSchoolDto> datas = queryAllschools();
        response.setData(datas);
        return response;
    }
}
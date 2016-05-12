package com.ssic.education.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.ProWaresDto;
import com.ssic.education.app.service.IProWaresService;
import com.ssic.util.model.Response;

/**		
 * <p>Title: ProWaresController </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月12日 上午10:46:34	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月12日 上午10:46:34</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping(value = "/wares")
public class ProWaresController {
	@Autowired
	private IProWaresService proWaresService;

	@RequestMapping("/list")
	@ResponseBody
	public Response<List<ProWaresDto>> getwareslist() {
		List<ProWaresDto> list = new ArrayList<ProWaresDto>();
		return null;
	}
}

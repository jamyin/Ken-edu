package com.ssic.education.app.controller;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.token.Token;
import com.ssic.education.app.token.TokenUtil;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.redis.WdRedisDao;

/**		
 * <p>Title: TokenController </p>
 * <p>Description: Token操作类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月19日 下午1:52:00	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月19日 下午1:52:00</p>
 * <p>修改备注：</p>
 */
@Controller
@RequestMapping(value = "/token")
public class TokenController {
	public static String id = "123456";
	public static String signature = "73d458f5fc44cf6df9be25073ac243b3";
	public static String timestamp = "1463638518240";
	@Getter
	@Autowired
	private WdRedisDao<String> redisdao;

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Response<Token> get(@PathVariable("id") String id) {
		Response<Token> result = new Response<Token>();
		result.setData(TokenUtil.getToken(id));
		redisdao.set("dasdfdgdfgdf", 123456);
		return result;
	}

	@RequestMapping(value = "check/{id}/{signature}", method = RequestMethod.GET)
	@ResponseBody
	public Response<Object> get(@PathVariable("id") int id, @PathVariable("signature") String signature) {
		Response<Object> result = new Response<Object>();
		TokenUtil.volidateToken(signature, id);
		result.setData(TokenUtil.volidateToken(signature, id));
		return result;
	}

}

package com.ssic.education.provider.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.utils.model.RequestResult;
import com.ssic.education.utils.util.JsonUtil;



/**
 * 统一异常处理器
 * @author rkzhang
 */
public class ExceptionHandler implements HandlerExceptionResolver  {

	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
			String requestUrl = request.getRequestURI();

	        
	        try {
	        	response.setContentType("application/json");
	        	response.setCharacterEncoding("utf-8");
				response.getWriter().print(JsonUtil.getJsonStr(new RequestResult(false, "message")));
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			};
           
	        return new ModelAndView();  
	}


}

package com.ssic.education.wechat.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.JsonUtil;
import com.ssic.education.utils.util.LogWriter;
import com.ssic.education.wechat.exception.EduException;

/**
 * 统一异常处理器
 * @author rkzhang
 */
public class ExceptionHandler implements HandlerExceptionResolver  {

    private static final Logger log = Logger.getLogger(ExceptionHandler.class);
	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
   
	        log.error("exception message :"+ex.getMessage());
	        log.error(LogWriter.getStackMsg(ex.getStackTrace()));
	        
	        if(ex instanceof EduException) {
	            EduException appEx = (EduException) ex;
    	        	try {
        	        	response.setContentType("application/json");
        	        	response.setCharacterEncoding("utf-8");
        			response.getWriter().print(JsonUtil.getJsonStr(new Response<String>(appEx.getErrorCode() == null ? DataStatus.HTTP_FAILE : appEx.getErrorCode(), appEx.getMessage(), null)));
        			response.getWriter().close();
        		} catch (IOException e) {
        			e.printStackTrace();
        		};
	        }
	        return new ModelAndView();  
	}


}

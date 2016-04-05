package com.ssic.education.app.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.app.exception.AppException;
import com.ssic.util.JsonUtil;
import com.ssic.util.LogWriter;
import com.ssic.util.constants.DataStatus;
import com.ssic.util.model.Response;

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
	        
	        if(ex instanceof AppException) {
	            AppException appEx = (AppException) ex;
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

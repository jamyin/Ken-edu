package com.ssic.education.government.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.education.utils.constants.SessionConstants;

public class UserHandler implements HandlerInterceptor  {

	private List<String> uncheckUrls; 
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws java.lang.Exception {
		Object obj = request.getSession().getAttribute(SessionConstants.LOGIN_USER_INFO);
		String requestUrl = request.getRequestURI();
		if(obj==null && !requestUrl.contains("login")){
			response.sendRedirect("/login.htm");
//			request.getRequestDispatcher("/login.htm").forward(request, response);
			return false;
		}
		
//		String requestUrl = request.getRequestURI();
//		System.out.println(requestUrl.contains("login"));
//		if(requestUrl.contains("login")){ 
//			return true; 
//		}else{ 
//				
//		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws java.lang.Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, java.lang.Exception ex)
			throws java.lang.Exception {
		// TODO Auto-generated method stub
		
	}
	
}

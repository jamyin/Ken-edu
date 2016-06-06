package com.ssic.education.app.interceptor;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssic.education.utils.model.Response;

/**
 * 拦截url中的token
 * @author SeanYoung
 *
 */
public class UserAccessApiInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Response<String> resoult = new Response<String>();
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		AccessRequired annotation = method.getAnnotation(AccessRequired.class);
		if (annotation != null) {
			System.out.println("扫描到注解：@AccessRequired");
			String accessToken = request.getParameter("token");
			/**
			 * Do something
			 */
			response.setContentType("text/html;charset=utf-8"); //设置响应编码与浏览器查看编码
			PrintWriter out = response.getWriter();
			out.print(resoult);
			response.getWriter().write("没有通过拦截，accessToken的值为：" + accessToken);
			response.sendError(403, "Exception Request");
			return false;
		}
		// 没有注解通过拦截
		return true;
	}
}

//if (annotation != null) {
//	System.out.println("扫描到注解：@AccessRequired");
//	String accessToken = request.getParameter("token");
//	/**
//	 * Do something
//	 */
//
//	//response.getOutputStream().print("没有通过拦截，token的值为：" + accessToken);
//	//需要通知浏览器查看编码
//	response.setContentType("text/html;charset=utf-8"); //设置响应编码与浏览器查看编码
//	PrintWriter out = response.getWriter();
//	//out.println("没有通过拦截，token的值为：" + accessToken);
//	//response.sendError(500, "没有通过拦截，token的值为：" + accessToken);
//	response.getWriter().write("没有通过拦截，token的值为：" + accessToken);
//	return false;
//} else {
//	// 没有注解通过拦截
//	return true;
//}
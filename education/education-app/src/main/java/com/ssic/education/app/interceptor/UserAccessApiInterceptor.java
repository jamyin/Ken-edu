package com.ssic.education.app.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssic.education.app.dto.AppEduUserDto;
import com.ssic.education.app.dto.AppProUserDto;
import com.ssic.education.utils.redis.WdRedisDao;
import com.ssic.education.utils.util.StringUtils;

/**
 * 拦截url中的token
 * @author SeanYoung
 *
 */
public class UserAccessApiInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private WdRedisDao<AppEduUserDto> eduRedisdao;
	@Autowired
	private WdRedisDao<AppProUserDto> proRedisdao;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		AccessRequired annotation = method.getAnnotation(AccessRequired.class);
		if (annotation != null) {
			String eduHeader = request.getHeader("edutk");
			String eduParam = request.getParameter("edutk");
			String eduToken = StringUtils.isNotBlank(eduHeader) ? eduHeader : eduParam;

			String proHeader = request.getHeader("edutk");
			String proParam = request.getParameter("edutk");
			String proToken = StringUtils.isNotBlank(proHeader) ? proHeader : proParam;

			if (StringUtils.isNotBlank(eduToken)) {
				AppEduUserDto eduAppUser = eduRedisdao.get(eduToken, AppEduUserDto.class);
				if (eduAppUser != null) {
					return true;
				} else {
					response.setContentType("text/html;charset=utf-8"); //设置响应编码与浏览器查看编码
					//PrintWriter out = response.getWriter();
					//response.getWriter().write("没有通过拦截，accessToken的值为：" + eduToken + proToken);
					response.sendError(403, "Access Denied！");
					return false;
				}
			} else if (StringUtils.isNotBlank(proToken)) {
				AppProUserDto proAppUser = proRedisdao.get(proToken, AppProUserDto.class);
				if (proAppUser != null) {
					return true;
				} else {
					response.setContentType("text/html;charset=utf-8"); //设置响应编码与浏览器查看编码
					response.sendError(403, "Access Denied！");
					return false;
				}
			} else {
				response.setContentType("text/html;charset=utf-8"); //设置响应编码与浏览器查看编码
				response.sendError(403, "Access Denied！");
				return false;
			}
		} else {
			return true;
		}
	}
}
package com.ssic.education.app.token;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**		
 * <p>Title: TokenFilter </p>
 * <p>Description: 令牌过滤器</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月19日 上午11:49:32	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月19日 上午11:49:32</p>
 * <p>修改备注：</p>
 */
public class TokenFilter implements Filter {

	/** 
	* (non-Javadoc)   
	* @see javax.servlet.Filter#init(javax.servlet.FilterConfig)   
	*/
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO 添加方法注释

	}

	/** 
	* (non-Javadoc)   
	* @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)   
	*/
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO 添加方法注释

	}

	/** 
	* (non-Javadoc)   
	* @see javax.servlet.Filter#destroy()   
	*/
	@Override
	public void destroy() {
		// TODO 添加方法注释

	}

}

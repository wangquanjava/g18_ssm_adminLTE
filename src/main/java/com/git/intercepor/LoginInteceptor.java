package com.git.intercepor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mchange.lang.IntegerUtils;

/*
 * 登录拦截器
 */
public class LoginInteceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (true) {
			request.getSession().setAttribute("id", 1);
			
			return true;
		}
		//如果是登录注册就直接允许
		if (StringUtils.indexOfAny(request.getRequestURI(), "login","register","check","add")!=-1) {
			return true;
		}
		
		//登录用户
		Integer id = (Integer) request.getSession().getAttribute("id");
		if (id!=null) {
			return true;
		}
		
		//未登录用户
		response.sendRedirect(request.getContextPath()+"/pageController/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}

package com.git.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class BusinessExceptionResolver implements HandlerExceptionResolver{
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {
		ex.printStackTrace();
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "出现异常了");
		mv.setViewName("500");
		return mv;
	}
}
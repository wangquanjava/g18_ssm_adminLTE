package com.git.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.git.domain.UserEntity;
import com.git.service.UserService;

@Controller
@RequestMapping("pageController")
public class PageController {
	@Autowired
	private UserService userService;
	/**
	 * 用于进入登录页面
	 */
	@RequestMapping("login")
	public String login(Model model){
		return "auth/login";
	}
	
	/**
	 * 用于进入注册页面
	 */
	@RequestMapping("register")
	public String register(){
		return "auth/register";
	}
	/**
	 * 用于进入管理界面
	 */
	@RequestMapping("manager-import")
	public String manager(){
		return "manager-import";
	}
	
	/**
	 * 进入主页
	 */
	@RequestMapping("index")
	public String main(HttpServletRequest request,Model model){
		UserEntity userEntity = this.userService.getUserById((Integer) request.getSession().getAttribute("id"));
		model.addAttribute("userEntity", userEntity);
		return "index";
	}
	/**
	 * 进入个人页面
	 */
	@RequestMapping("profile")
	public String profile(HttpServletRequest request,Model model){
		UserEntity userEntity = this.userService.getUserById((Integer) request.getSession().getAttribute("id"));
		model.addAttribute("userEntity", userEntity);
		return "profile";
	}
}

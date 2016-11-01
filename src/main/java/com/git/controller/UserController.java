package com.git.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.git.domain.AjaxJson;
import com.git.domain.UserEntity;
import com.git.service.UserService;

@Controller
@RequestMapping("userController")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "check",method=RequestMethod.POST)
	public String check(UserEntity userEntity,Model model,HttpServletRequest request){
		try {
			boolean success = this.userService.check(userEntity);
			if (success) {
				request.getSession().setAttribute("username", userEntity.getUsername());
				return "redirect:/pageController/index";
			}else{
				model.addAttribute("msg","用户名或密码错误");
				return "auth/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg","服务器出现错误");
			return "";
		}
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "auth/login";
	}
	
	@RequestMapping(value = "add",method=RequestMethod.POST)
	public String add(UserEntity userEntity,HttpServletRequest request){
		try {
			request.getSession().setAttribute("username", userEntity.getUsername());
			return "redirect:/pageController/index";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
}

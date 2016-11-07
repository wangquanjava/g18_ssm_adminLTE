package com.git.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.git.domain.UserEntity;
import com.git.service.UserService;

@Controller
@RequestMapping("userController")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "check",method=RequestMethod.POST)
	public String check(UserEntity userEntity,Model model,HttpServletRequest request){
		UserEntity temp = this.userService.check(userEntity);
		if (temp!=null) {
			request.getSession().setAttribute("id", temp.getId());
			return "redirect:/pageController/index";
		}else{
			model.addAttribute("msg","用户名或密码错误");
			return "auth/login";
		}
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "auth/login";
	}
	
	@RequestMapping(value = "add",method=RequestMethod.POST)
	public String add(UserEntity userEntity,HttpServletRequest request) throws Exception{
		this.userService.add(userEntity);
		request.getSession().setAttribute("id", userEntity.getId());
		return "redirect:/pageController/index";
	}
	
	@RequestMapping(value = "update",method=RequestMethod.POST)
	public String update(UserEntity userEntity,HttpServletRequest request) throws Exception{
		this.userService.update(userEntity);
		return "redirect:/pageController/profile";
	}
	
	@RequestMapping("getUser")
	public ResponseEntity<UserEntity> getUser(int id){
		UserEntity userEntity = this.userService.getUserById(id);
		return ResponseEntity.status(200).body(userEntity);
	}
	
}

package com.git.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "add",method=RequestMethod.POST)
	public ResponseEntity<AjaxJson> add(@RequestBody UserEntity userEntity){
		try {
			this.userService.add(userEntity);
			return ResponseEntity.status(200).body(new AjaxJson(true, "用户加入成功", null));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(new AjaxJson(false, "服务器报错", null));
		}
	}
}

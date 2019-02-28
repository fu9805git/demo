package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Users;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(Users users) {
		userService.addUser(users);
		return "ok";
	}
	
}

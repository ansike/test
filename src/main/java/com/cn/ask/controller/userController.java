package com.cn.ask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cn.ask.model.User;
import com.cn.ask.service.UserService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("user")
public class userController {

	@Autowired private UserService userService;
	@RequestMapping(value="checkUser" , method=RequestMethod.POST)
	public String checkUser(String phone,String password,String randomCode){
		User user=userService.checkUser(phone,password,randomCode);
		String code="1234";

		if(!user.getPassword().equals(password)){
			return "密码错误";
		}
		if(!code.equals(randomCode)){
			return "验证码错误";
		}
		return "登录成功";
	}
}
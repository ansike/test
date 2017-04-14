package com.cn.ask.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.cn.ask.model.User;
import com.cn.ask.service.UserService;
import com.cn.ask.utils.MD5Util;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("user")
public class userController {
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UserService userService;
	
	@Autowired
	private StringRedisTemplate redis;

	@RequestMapping(value = "checkUser", method = RequestMethod.POST)
	public Map<String, String> checkUser(String phone, String password, String randomCode, Boolean rememberMe) {
		Map<String, String> returnMap = new HashMap<>();
		User user = userService.checkUser(phone);
		String code = "1234";
		String turncode = "200";
		String msg = "登录成功";

		if (user == null) {
			turncode = "100";
			msg = "用户不存在！";
		} else {
			if (!user.getPassword().equals(MD5Util.string2MD5(password))) {
				turncode = "201";
				msg = "密码错误！";
			}
			if (!code.equals(randomCode)) {
				turncode = "202";
				msg = "验证码错误！";
			}
		}

		// REMEMBERME
		if (rememberMe != null && rememberMe) {
			// 加密用户名
			String cookieValue = MD5Util.string2MD5(phone + Math.random());
			String cookieKey = "ASK_LOGIN";
			Cookie cookie = new Cookie(cookieKey, cookieValue);
			redis.opsForValue().set(cookieValue, user.getPhone());
			redis.boundValueOps(cookieValue).expire(7, TimeUnit.DAYS);
			cookie.setMaxAge(604800);// 秒：60*60*24*7//记住7天
			cookie.setPath("/");
			response.addCookie(cookie);
		} else {
			request.getSession().setAttribute("ASK_LOGIN", user);
		}
		returnMap.put("code", turncode);
		returnMap.put("msg", msg);
		return returnMap;
	}
	@RequestMapping(value="/checkLogin")
	public User checkLogin() {
		User user = (User) request.getSession().getAttribute("ASK_LOGIN");
		if (user == null) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				String login_key = null;
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("ASK_LOGIN")) {
						login_key = cookie.getValue();
					}
				}
				if (!StringUtils.isEmpty(login_key)) {
					String phone=redis.opsForValue().get(login_key);
					if(!StringUtils.isEmpty(phone)){
						user=userService.findByPhone(phone);
						request.getSession().setAttribute("ASK_LOGIN", user);
					}
				}
			}
		}
		return user;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, String> register(String phone, String password, String randomCode) {
		Map<String, String> returnMap = new HashMap<String, String>();
		User user = userService.checkUser(phone);
		String turncode = "";
		String msg = "";
		if (user != null) {
			turncode = "100";
			msg = "用户已经存在！";
		} else {
			if(userService.insertUser(phone,password)){
				turncode = "200";
				msg = "注册成功";
			}
		}
		
		returnMap.put("code", turncode);
		returnMap.put("msg", msg);

		return returnMap;
	}
}
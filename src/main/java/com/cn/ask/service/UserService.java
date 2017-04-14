package com.cn.ask.service;

import com.cn.ask.model.User;

public interface UserService {
	User checkUser(String phone);
	boolean insertUser(String phone,String pwd);
	User findByPhone(String phone);
}

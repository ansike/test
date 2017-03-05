package com.cn.ask.service;

import com.cn.ask.model.User;

public interface UserService {
	User checkUser(String phone,String password,String randomCode);
}

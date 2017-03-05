package com.cn.ask.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.ask.dao.UserMapper;
import com.cn.ask.model.User;
import com.cn.ask.model.UserExample;
import com.cn.ask.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserMapper userMapper;
	@Override
	public User checkUser(String phone, String password, String randomCode) {
		UserExample example=new UserExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<User> list= userMapper.selectByExample(example);
		return list.get(0);
	}
	
}

package com.cn.ask.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.ask.dao.UserMapper;
import com.cn.ask.model.User;
import com.cn.ask.model.UserExample;
import com.cn.ask.service.UserService;
import com.cn.ask.utils.MD5Util;
@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserMapper userMapper;
	@Override
	public User checkUser(String phone) {
		UserExample example=new UserExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<User> list= userMapper.selectByExample(example);
		return list.size()>0?list.get(0):null;
	}
	@Override
	public boolean insertUser(String phone, String pwd) {
		UserExample example=new UserExample();
		User user = new User();
		user.setPhone(phone);
		user.setPassword(MD5Util.string2MD5(pwd));
		boolean flag=userMapper.insert(user)>0?true:false;
		return flag;
	}
	@Override
	public User findByPhone(String phone) {
		UserExample ue=new UserExample();
		ue.createCriteria().andPhoneEqualTo(phone);
		List<User> users=userMapper.selectByExample(ue);
		return users.size()>0?users.get(0):null;
	}
	
}

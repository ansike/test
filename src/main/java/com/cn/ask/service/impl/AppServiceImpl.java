package com.cn.ask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.ask.dao.AppMapper;
import com.cn.ask.model.App;
import com.cn.ask.model.AppExample;
import com.cn.ask.service.AppService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class AppServiceImpl implements AppService {

	@Autowired AppMapper appMapper;
	@Override
	public PageInfo<App> findApp(Integer start, Integer size, String appName) {
		String name=appName==null?appName="":appName;
		PageHelper.startPage(start, size);
		AppExample example=new AppExample();
		example.createCriteria().andAppNameLike("%"+name+"%");
		example.clear();
		return new PageInfo<App>(appMapper.selectByExample(example));
	}

	@Override
	public void insertApp(App app) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteApp(App apps) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateApp(App app) {
		// TODO Auto-generated method stub

	}





}

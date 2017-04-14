package com.cn.ask.service;

import com.cn.ask.model.App;
import com.github.pagehelper.PageInfo;

public interface AppService {

	PageInfo<App> findApp(Integer start,Integer size,String appName);
	void insertApp(App app);
	void deleteApp(App apps);
	void updateApp(App app);
}

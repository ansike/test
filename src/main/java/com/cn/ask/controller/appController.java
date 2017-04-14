package com.cn.ask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.ask.model.App;
import com.cn.ask.service.AppService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("app")
public class appController {

	@Autowired AppService appService;
	@RequestMapping(value="findApp")
	public PageInfo<App> findApp(String appName){
		return appService.findApp(1, 10, appName);
	}
}

package com.cn.ask.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cn.ask.model.Tag;
import com.cn.ask.service.TagService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping(value = "/tag")
public class tagController {

	@Autowired
	TagService tagService;

	@RequestMapping(value = "/getAllTags", method = RequestMethod.GET)
	public Map getAllTags() {
		return tagService.getAllTags();

	}

	@RequestMapping(value = "/getTags")
	@GetMapping
	public Map<String, Long> getTags() {
		return tagService.getTagBooks();

	}
}

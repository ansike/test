
package com.cn.ask.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cn.ask.service.TagService;

@RestController
@RequestMapping(value = "/tag")
public class tagController {

	@Autowired
	TagService tagService;

	@RequestMapping(value = "/getAllTags", method = RequestMethod.GET)
	public Map getAllTags() {
		return tagService.getAllTags();

	}

	@RequestMapping(value = "/getBooksByTagId")
	@GetMapping
	public Map<String, Object> getTags(Integer tagId) {
		return tagService.getBooksByTagid(tagId);

	}
	
	@RequestMapping(value = "/bookCity")
	@GetMapping
	public Map<String, Object> bookCity() {
		/**
		 * *大体分类5为男生
		 * 1，2，3
		 * 6为女生
		 */
		Integer[] a={1,2,3};
		return tagService.getCateBooks(5,6,a);
	}
	
}

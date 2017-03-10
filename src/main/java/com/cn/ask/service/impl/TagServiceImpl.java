package com.cn.ask.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.ask.dao.TagBookMapper;
import com.cn.ask.dao.TagMapper;
import com.cn.ask.model.Tag;
import com.cn.ask.model.TagBookExample;
import com.cn.ask.model.TagExample;
import com.cn.ask.service.TagService;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagMapper tagMapper;
	@Autowired private TagBookMapper tagBookMapper;
	@Override
	public Map getAllTags() {
		TagExample example = new TagExample();
		Map<String,Object> tags=new HashMap<>();
		tags.put("tags", tagMapper.selectByExample(example));
		tags.put("nums",getTagBooks() );
		return tags;
	}

	@Override
	public Map<String,Long> getTagBooks() {
		Map<String,Long> books = new HashMap<>();
		
		TagExample texample = new TagExample();
		for (Tag t : tagMapper.selectByExample(texample)) {
			
			TagBookExample tbexample = new TagBookExample();
			tbexample.createCriteria().andTagIdEqualTo(t.getTagId());
			books.put(t.getTagId().toString(),tagBookMapper.countByExample(tbexample));
			
		}
		return books;
	}

}

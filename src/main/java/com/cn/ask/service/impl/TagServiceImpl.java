package com.cn.ask.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.ask.dao.BookMapper;
import com.cn.ask.dao.TagBookMapper;
import com.cn.ask.dao.TagMapper;
import com.cn.ask.model.Tag;
import com.cn.ask.model.TagBook;
import com.cn.ask.model.TagBookExample;
import com.cn.ask.model.TagExample;
import com.cn.ask.service.TagService;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagMapper tagMapper;
	@Autowired
	private TagBookMapper tagBookMapper;
	@Autowired
	private BookMapper bookMapper;

	@Override
	public Map getAllTags() {
		TagExample example = new TagExample();
		Map<String, Object> tags = new HashMap<>();
		tags.put("tags", tagMapper.selectByExample(example));
		tags.put("nums", getTagBooks());
		return tags;
	}

	@Override
	public Map<String, Long> getTagBooks() {
		Map<String, Long> books = new HashMap<>();

		TagExample texample = new TagExample();
		for (Tag t : tagMapper.selectByExample(texample)) {

			TagBookExample tbexample = new TagBookExample();
			tbexample.createCriteria().andTagIdEqualTo(t.getTagId());
			books.put(t.getTagId().toString(), tagBookMapper.countByExample(tbexample));

		}
		return books;
	}

	@Override
	public Map<String, Object> getCateBooks(Integer cate1, Integer cate2, Integer[] array) {
		Map<String, Object> cateBooks = new HashMap<>();

		
		List<Object> catebook1 = new ArrayList<>();
		TagBookExample exampleMan = new TagBookExample();
		exampleMan.createCriteria().andTagIdEqualTo(cate1);
		for (int i = 0; i < array.length; i++) {
			int cateId = array[i];
			Map<String, Object> catebookMan = new HashMap<>();
			Set<Object> books = new HashSet<>();
			catebookMan.put("tagId", cateId);
			catebookMan.put("cateName", tagMapper.selectByPrimaryKey(cateId).getTagValue());
			for (TagBook tb : tagBookMapper.selectByExample(exampleMan)) {
				TagBookExample example = new TagBookExample();
				example.createCriteria().andBookIdEqualTo(tb.getBookId());
				for(TagBook t2:tagBookMapper.selectByExample(example)){
					if (t2.getTagId().equals(cateId) ) {
						books.add(bookMapper.selectByPrimaryKey(tb.getBookId()));
					}
				}
			}
			
			catebookMan.put("cateBooks", books);
			catebook1.add(catebookMan);
		}
		//男人分类传入
		cateBooks.put(tagMapper.selectByPrimaryKey(cate1).getTagValue(), catebook1);

		
		List<Object> catebook2 = new ArrayList<>();
		TagBookExample exampleWoman = new TagBookExample();
		exampleWoman.createCriteria().andTagIdEqualTo(cate2);
		for (int i = 0; i < array.length; i++) {
			Map<String, Object> catebookWoman = new HashMap<>();
			int cateId = array[i];
			Set<Object> books = new HashSet<>();
			catebookWoman.put("tagId", cateId);
			catebookWoman.put("cateName", tagMapper.selectByPrimaryKey(cateId).getTagValue());
			for (TagBook tb : tagBookMapper.selectByExample(exampleWoman)) {
				TagBookExample example = new TagBookExample();
				example.createCriteria().andBookIdEqualTo(tb.getBookId());
				for(TagBook t2:tagBookMapper.selectByExample(example)){
					if (t2.getTagId().equals(cateId) ) {
						books.add(bookMapper.selectByPrimaryKey(tb.getBookId()));
					}
				}
			}
			catebookWoman.put("cateBooks", books);
			catebook2.add(catebookWoman);
		}
		//女人分类传入
		cateBooks.put(tagMapper.selectByPrimaryKey(cate2).getTagValue(), catebook2);
		
		return cateBooks;
	}

}

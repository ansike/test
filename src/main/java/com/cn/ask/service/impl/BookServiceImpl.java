package com.cn.ask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.ask.dao.BookMapper;
import com.cn.ask.model.Book;
import com.cn.ask.model.BookExample;
import com.cn.ask.service.BookService;
import com.github.pagehelper.PageInfo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired private BookMapper bookMapper;
	@Override
	public PageInfo<Book> findBook(Integer start, Integer size) {

		BookExample example=new BookExample();
//		for(Book b: bookMapper.selectByExample(example)){
//			System.out.println(b);
//		}
		return new PageInfo<Book>(bookMapper.selectByExample(example));
	}

}

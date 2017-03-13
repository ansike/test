package com.cn.ask.service;

import java.util.Map;

import com.cn.ask.model.Book;
import com.github.pagehelper.PageInfo;

public interface BookService {
	PageInfo<Book> findBook(Integer start,Integer size,String name);
	Map getBook(Integer id);
}

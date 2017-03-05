package com.cn.ask.service;

import com.cn.ask.model.Book;
import com.github.pagehelper.PageInfo;

public interface BookService {
	PageInfo<Book> findBook(Integer start,Integer size);
}

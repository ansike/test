package com.cn.ask.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cn.ask.model.Book;
import com.cn.ask.service.BookService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired private BookService bookservice;
	@RequestMapping(value="/getAllBooks" ,method=RequestMethod.GET)
	public PageInfo<Book> getAllBooks(String name){
		return bookservice.findBook(1,10,name);
		
	}
	
	@RequestMapping("/getBook")
	public Map getBook(Integer id){
		return bookservice.getBook(id);
	}
	@RequestMapping("/search")
	public List search(String name){
		return bookservice.search(name);
	}
	
}

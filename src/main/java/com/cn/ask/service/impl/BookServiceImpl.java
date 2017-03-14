package com.cn.ask.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.ask.dao.BookMapper;
import com.cn.ask.model.Book;
import com.cn.ask.model.BookExample;
import com.cn.ask.service.BookService;
import com.github.pagehelper.PageInfo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public PageInfo<Book> findBook(Integer start, Integer size, String name) {

		BookExample example = new BookExample();
		// for(Book b: bookMapper.selectByExample(example)){
		// System.out.println(b);
		// }
		BookExample.Criteria criteria = example.createCriteria();
		criteria.andBookNameLike("%" + name + "%");
		criteria.andBookNameLike("%" + name + "%");
		return new PageInfo<Book>(bookMapper.selectByExample(example));
	}

	@Override
	public Map getBook(Integer id) {
		Map<String,String> bookUrl=new HashMap<>();
		bookUrl.put("url", bookMapper.selectByPrimaryKey(id).getBookUrl());
		return bookUrl;
	}

	public static String readTxtFile(String filePath) {
		String txt = "";
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					System.out.println(lineTxt);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return txt;
	}

}

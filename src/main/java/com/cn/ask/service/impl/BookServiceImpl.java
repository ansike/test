package com.cn.ask.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.ask.dao.BookMapper;
import com.cn.ask.dao.TagMapper;
import com.cn.ask.dao.UserMapper;
import com.cn.ask.model.Book;
import com.cn.ask.model.BookExample;
import com.cn.ask.model.TagExample;
import com.cn.ask.service.BookService;
import com.github.pagehelper.PageInfo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private TagMapper tagMapper;

	@Autowired
	private UserMapper userMapper;
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
		bookUrl.put("chapterNum", bookMapper.selectByPrimaryKey(id).getChapter().toString());
		bookUrl.put("bookName", bookMapper.selectByPrimaryKey(id).getBookName());
		bookUrl.put("pic", bookMapper.selectByPrimaryKey(id).getCoverPic());
		bookUrl.put("author", bookMapper.selectByPrimaryKey(id).getBookAuthor());
		bookUrl.put("info", bookMapper.selectByPrimaryKey(id).getInfo());
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

	@Override
	public List<Object>  search(String name) {
		
		List<Object> resList=new ArrayList<>();
		
		//作者名字
		Map<String,Object> res1=new HashMap<>();
		BookExample be=new BookExample();
		be.createCriteria().andBookAuthorLike("%"+name+"%");
		res1.put("name", "author");
		res1.put("data", bookMapper.selectByExample(be));
		
		//书名字
		Map<String,Object> res2=new HashMap<>();
		BookExample be2=new BookExample();
		be2.createCriteria().andBookNameLike("%"+name+"%");
		res2.put("name", "book");
		res2.put("data", bookMapper.selectByExample(be2));
		//分类
		Map<String,Object> res3=new HashMap<>();
		TagExample te =new TagExample();
		te.createCriteria().andTagValueLike("%"+name+"%");
		res3.put("name", "tag");
		res3.put("data", tagMapper.selectByExample(te));
		resList.add(res1);
		resList.add(res2);
		resList.add(res3);
		return resList;
	}

}

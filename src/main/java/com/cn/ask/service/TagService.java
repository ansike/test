package com.cn.ask.service;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;

public interface TagService {
	Map getAllTags();
	Map<String,Long> getTagBooks();
	Map<String,Object> getCateBooks(Integer cate1,Integer cate2,Integer[] a);
}

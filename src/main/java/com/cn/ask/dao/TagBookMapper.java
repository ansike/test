package com.cn.ask.dao;

import com.cn.ask.model.TagBook;
import com.cn.ask.model.TagBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagBookMapper {
    long countByExample(TagBookExample example);

    int deleteByExample(TagBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TagBook record);

    int insertSelective(TagBook record);

    List<TagBook> selectByExample(TagBookExample example);

    TagBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TagBook record, @Param("example") TagBookExample example);

    int updateByExample(@Param("record") TagBook record, @Param("example") TagBookExample example);

    int updateByPrimaryKeySelective(TagBook record);

    int updateByPrimaryKey(TagBook record);
}
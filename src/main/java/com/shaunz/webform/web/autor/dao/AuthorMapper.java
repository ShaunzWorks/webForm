package com.shaunz.webform.web.autor.dao;

import org.springframework.stereotype.Repository;

import com.shaunz.webform.web.autor.entity.Author;

@Repository
public interface AuthorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}
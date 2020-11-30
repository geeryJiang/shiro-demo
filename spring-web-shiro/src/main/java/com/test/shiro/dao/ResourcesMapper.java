package com.test.shiro.dao;

import com.test.shiro.entity.Resources;

public interface ResourcesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Resources record);

    Resources selectByPrimaryKey(Long id);


}
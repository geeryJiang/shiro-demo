package com.test.shiro.dao;

import com.test.shiro.entity.Resources;

import java.util.List;
import java.util.Map;

public interface ResourcesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Resources record);

    Resources selectByPrimaryKey(Long id);

    List<Map> selectAllResourceAndPermission();

}
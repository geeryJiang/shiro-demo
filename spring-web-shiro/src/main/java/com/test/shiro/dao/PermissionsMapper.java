package com.test.shiro.dao;

import com.test.shiro.entity.Permissions;


public interface PermissionsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Permissions record);

    Permissions selectByPrimaryKey(Long id);

}
package com.test.shiro.dao;

import com.test.shiro.entity.Roles;

public interface RolesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Roles record);

    Roles selectByPrimaryKey(Long id);

}
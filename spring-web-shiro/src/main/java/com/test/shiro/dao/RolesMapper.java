package com.test.shiro.dao;

import com.test.shiro.entity.Roles;

import java.util.Set;

public interface RolesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Roles record);

    Roles selectByPrimaryKey(Long id);

    Set<String> selectByUserName(String userName);

}
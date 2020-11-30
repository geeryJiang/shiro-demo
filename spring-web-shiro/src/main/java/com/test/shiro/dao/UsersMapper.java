package com.test.shiro.dao;

import com.test.shiro.entity.Users;

public interface UsersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    Users selectByPrimaryKey(Long id);

    Users selectByUserName(String userName);

}
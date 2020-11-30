package com.test.shiro.service.impl;

import com.test.shiro.dao.UsersMapper;
import com.test.shiro.entity.Users;
import com.test.shiro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserService
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/30 10:06
 * @Version: 1.0
 */
@Service
public class UserService implements IUserService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public Users selectByUserName(String userName) {
        return usersMapper.selectByUserName(userName);
    }
}

package com.test.shiro.service;

import com.test.shiro.entity.Users;

/**
 * @ClassName: IUserService
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/30 10:07
 * @Version: 1.0
 */
public interface IUserService {

    Users selectByUserName(String userName);

}

package com.atguigu.shiro.service;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: ShiroService
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/27 18:00
 * @Version: 1.0
 */
// @Service 注意 若使用 @Service 则 @RequiresRoles 不生效
public class ShiroService {

    @RequiresRoles({"admin"})
    public void testMethod() {
        System.out.println("testMethod, time :" + new Date());

    }
}

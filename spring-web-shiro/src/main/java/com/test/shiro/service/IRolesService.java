package com.test.shiro.service;

import java.util.Set;

/**
 * @ClassName: IRolesService
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/30 10:53
 * @Version: 1.0
 */
public interface IRolesService {

    Set<String> selectByUserName(String userName);

}

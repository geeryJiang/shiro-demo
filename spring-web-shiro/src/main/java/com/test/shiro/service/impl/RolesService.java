package com.test.shiro.service.impl;

import com.test.shiro.dao.RolesMapper;
import com.test.shiro.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName: RolesService
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/30 10:54
 * @Version: 1.0
 */
@Service
public class RolesService implements IRolesService {

    @Autowired
    RolesMapper rolesMapper;

    @Override
    public Set<String> selectByUserName(String userName) {
        return rolesMapper.selectByUserName(userName);
    }
}

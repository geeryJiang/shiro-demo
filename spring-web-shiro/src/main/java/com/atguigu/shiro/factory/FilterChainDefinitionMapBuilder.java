package com.atguigu.shiro.factory;

import java.util.LinkedHashMap;

/**
 * @ClassName: FilterChainDefinitionMapBuilder
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/27 18:18
 * @Version: 1.0
 */
public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        map.put("/login.jsp", "anon");
        map.put("/shiro/login", "anon");
        map.put("/shiro/logout", "logout");
        map.put("/user.jsp", "roles[user]");
        map.put("/admin.jsp", "roles[admin]");
        map.put("/**", "authc");

        return map;
    }

}

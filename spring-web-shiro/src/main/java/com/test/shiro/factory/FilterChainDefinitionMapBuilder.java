package com.test.shiro.factory;

import com.test.shiro.service.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: FilterChainDefinitionMapBuilder
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/27 18:18
 * @Version: 1.0
 */
public class FilterChainDefinitionMapBuilder {

    @Autowired
    IResourcesService resourcesService;

    /**
     * anon: 允许立即访问路径而不执行任何类型的安全检查的过滤器。
     * authc: 要求请求用户经过身份验证才能继续请求，如果没有，则通过将用户重定向到您配置的loginUrl强制用户登录。
     * authcBasic: 要求对请求用户进行身份验证以继续请求，如果没有，则要求用户通过特定于HTTP基本协议的查询登录。成功登录后，允许它们继续访问所请求的资源/url。
     * authcBearer: 要求对请求用户进行身份验证以继续请求，如果没有，则要求用户通过特定于HTTP承载协议的质询登录。成功登录后，允许它们继续访问所请求的资源/url。
     * invalidRequest: 一个阻止恶意请求的请求过滤器。无效的请求将响应400响应码。
     * logout: 简单的过滤器，在收到请求后，将立即注销当前执行的subject，然后将它们重定向到一个配置的重定向。
     * noSessionCreation: 将在请求期间禁用创建新会话的路径匹配过滤器。这是一个非常有用的过滤器，可以放置在任何过滤器链的前端，这些过滤器链可能导致REST、SOAP或其他不打算参与会话的服务调用。
     * perms: 筛选器，如果当前用户具有映射值指定的权限，则允许访问;如果用户不具有指定的所有权限，则拒绝访问。
     * port: 要求请求位于特定端口上，如果不是，则重定向到该端口上的相同URL的过滤器
     * rest: 一个过滤器，它将HTTP请求的方法(如GET、POST等)转换为相应的动作(谓词)，并使用该谓词构造将被检查以确定访问的权限。
     * roles: 筛选器，如果当前用户具有映射值指定的角色，则允许访问;如果用户没有指定的所有角色，则拒绝访问。
     * ssl: 要求请求通过SSL的筛选器。如果在配置的服务器端口接收到请求，并且请求. issecure()，则允许访问。如果任一条件为假，则过滤器链将不继续。
     * user: 如果访问器是已知用户(定义为具有已知主体)，则允许访问资源的筛选器。这意味着任何通过“记住我”功能进行身份验证或记忆的用户都将被允许从这个过滤器访问。
     */

    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/login.jsp", "anon");
        map.put("/shiro/login", "anon");

        List<Map> maps = resourcesService.selectAllResourceAndPermission();
        for (Map tmp : maps) {
            map.put(tmp.get("url").toString(), tmp.get("permissionNames").toString());
        }

        map.put("/**", "authc");
        return map;
    }

}

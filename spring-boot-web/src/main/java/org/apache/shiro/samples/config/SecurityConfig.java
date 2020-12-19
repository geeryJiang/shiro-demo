package org.apache.shiro.samples.config;

import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.Filter;

/**
 * @ClassName: SecurityConfig
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/12/8 19:37
 * @Version: 1.0
 */
@Configuration
public class SecurityConfig {

    // 缓存配置
    @Bean
    public CacheManager shiroCacheManagerBean(RedisTemplate template) {
        ShiroCacheManager shiroCacheManager = new ShiroCacheManager(template);
        return shiroCacheManager;
    }

    @Bean
    public PermissionResolver shiroPermissionResolver() {
        ShiroPermissionResolver permissionResolver = new ShiroPermissionResolver();
        return permissionResolver;
    }

    @Bean
    public Realm shiroRealm() {
        MyRealm realm = new MyRealm();
        realm.setPermissionResolver(shiroPermissionResolver);
        return realm;
    }

    @Bean
    public WebSecurityManager shiroWebSecurityManager() {
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setCacheManager(shiroCacheManagerBean);
        webSecurityManager.setRealm(shiroRealm);
        return webSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean MyShiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(shiroWebSecurityManager);
        factoryBean.setLoginUrl("");
        factoryBean.setUnauthorizedUrl("");
        factoryBean.setSuccessUrl("");
        factoryBean.setFilters();
        factoryBean.setFilterChainDefinitions();
        return factoryBean;
    }

    @Bean
    public Filter shiroFilter(ShiroFilterFactoryBean factoryBean, Realm realm) throws Exception {
        ((DefaultWebSecurityManager) factoryBean.getSecurityManager()).setRealm(realm);
        return factoryBean.getObject();
    }

    @Bean
    public FilterRegistrationBean shiroFilterRegistrationBean(@Qualifier("shiroFilter") Filter shiroFilter) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(shiroFilter);
        return registrationBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor shiroAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(shiroWebSecurityManager);
        return sourceAdvisor;
    }

    @Bean
    public LifecycleBeanPostProcessor shiroLifecycleBeanPostProcessor() {
        LifecycleBeanPostProcessor processor = new LifecycleBeanPostProcessor();
        return processor;
    }

    @Bean
    public MyLogoutFilter shiroMyLogoutFilter() {
        MyLogoutFilter logoutFilter = new MyLogoutFilter();
        return logoutFilter;
    }
    @Bean
    public FilterRegistrationBean shiroLogoutFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(shiroMyLogoutFilter);
        return registrationBean;
    }

    @Bean
    public MyAuthorizationFilter shiroMyAuthorizationFilter() {
        MyAuthorizationFilter authorizationFilter = new MyAuthorizationFilter();
        return authorizationFilter;
    }
    @Bean
    public FilterRegistrationBean shiroAuthorizationFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(shiroMyAuthorizationFilter);
        return registrationBean;
    }

    @Bean
    public MyFormAuthenticationFilter shiroMyFormAuthenticationFilter() {
        MyFormAuthenticationFilter filter = new MyFormAuthenticationFilter();
        return filter;
    }
    @Bean
    public FilterRegistrationBean shiroFormFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(shiroMyFormAuthenticationFilter);
        return registrationBean;
    }

}

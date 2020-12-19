package org.apache.shiro.samples.config;

import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @ClassName: MyLogoutFilter
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/12/19 17:06
 * @Version: 1.0
 */
public class MyLogoutFilter extends LogoutFilter {
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        return super.preHandle(request, response);
    }
}

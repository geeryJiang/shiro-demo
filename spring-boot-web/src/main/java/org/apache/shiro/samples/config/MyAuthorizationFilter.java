package org.apache.shiro.samples.config;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @ClassName: MyAuthorizationFilter
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/12/19 17:00
 * @Version: 1.0
 */
public class MyAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected void saveRequestAndRedirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        super.saveRequestAndRedirectToLogin(request, response);
    }
}

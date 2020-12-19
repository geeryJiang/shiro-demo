package org.apache.shiro.samples.config;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @ClassName: ShiroWildcardPermission
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/12/8 20:47
 * @Version: 1.0
 */
public class ShiroWildcardPermission extends WildcardPermission {

    @Override
    public boolean implies(Permission p) {
        return super.implies(p);
    }
}

package org.apache.shiro.samples.config;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;

/**
 * @ClassName: ShiroWildcardPermission
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/12/8 20:09
 * @Version: 1.0
 */
public class ShiroPermissionResolver implements PermissionResolver {
    @Override
    public Permission resolvePermission(String permissionString) {
        return null;
    }
}

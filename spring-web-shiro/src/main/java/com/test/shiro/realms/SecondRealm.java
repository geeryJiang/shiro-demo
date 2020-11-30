package com.test.shiro.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName: ShiroRealm
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/27 11:31
 * @Version: 1.0
 */
// public class ShiroRealm implements Realm  {
public class SecondRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("[secondRealm] doGetAuthenticationInfo:" + token.hashCode());

        // 1. 把AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        // 2. 从UsernamePasswordToken 中获取 username
        String username = upToken.getUsername();

        // 3. 调用数据库方法，从数据库获取username对应的用户信息
        System.out.println("从数据库中获取username:" + username + "所对应的用户信息");

        // 4. 若用户不存在，则可以抛出 UnKnownAccountException
        if ("unknown".equals(username)) {
            throw new UnknownAccountException("用户不存在");
        }

        // 5. 根据用户信息，决定是否需要抛出其他的AuthenticationException
        if ("monster".equals(username)) {
            throw new LockedAccountException("用户被锁定");
        }

        // 6. 根据用户情况，来构建 AuthenticationInfo 对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        // 一下信息是从数据库中获取的
        // 1). principal: 认证的实体信息，可以是username, 也可以是数据表对应的用户的实体类对象.
        Object principal = username;
        // 2). credentials: 密码
        Object credentials =  null;// "fc1709d0a95a6be30bc5926fdb7f22f4";
        if ("admin".equals(username)) {
            credentials = "ce2f6417c7e1d32c1d81a797ee0b499f87c5de06";
        } else if ("user".equals(username)) {
            credentials = "073d4c3ae812935f23cb3f2a71943f49e082a718";
        }
        // 3). realmName: 当前realm对象的name，调用父类的getName()方法即可
        String realmName = getName();
        // 4). credentialsSalt: 盐值;
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
//        1. SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
//  2. SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("secondName", credentials, credentialsSalt,
                realmName);
        return info;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "SHA1";
        Object credentials = "123456";
        ByteSource salt = ByteSource.Util.bytes("admin");
        int hashIterations = 1024;
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(simpleHash);
    }

}

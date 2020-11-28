package com.atguigu.shiro.realms;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

import java.io.Serializable;

/**
 * @ClassName: MySessionDao
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/11/28 10:31
 * @Version: 1.0
 */
public class MySessionDao extends EnterpriseCacheSessionDAO {

    @Override
    protected Serializable doCreate(Session session) {
        return super.doCreate(session);
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return super.doReadSession(sessionId);
    }

    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
    }

    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
    }
}

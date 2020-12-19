package org.apache.shiro.samples.config;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;

/**
 * @ClassName: ShiroRedisCache
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/12/8 19:39
 * @Version: 1.0
 */
public class ShiroRedisCache<K, V> implements Cache<K, V> {

    private RedisTemplate template;

    @Override
    public Object get(Object o) throws CacheException {
        return null;
    }

    @Override
    public Object put(Object o, Object o2) throws CacheException {
        return null;
    }

    @Override
    public Object remove(Object o) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set keys() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    public void setTemplate(RedisTemplate template) {
        this.template = template;
    }
}

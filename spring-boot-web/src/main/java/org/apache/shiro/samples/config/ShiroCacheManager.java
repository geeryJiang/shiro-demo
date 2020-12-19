package org.apache.shiro.samples.config;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName: ShiroCacheManager
 * @Author: jiangguoqing
 * @Description: DOTO
 * @Date: 2020/12/8 19:41
 * @Version: 1.0
 */
public class ShiroCacheManager implements CacheManager {

    private RedisTemplate template;

    public ShiroCacheManager() {
    }

    public ShiroCacheManager(RedisTemplate template) {
        this.template = template;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        ShiroRedisCache cache = new ShiroRedisCache();
        cache.setTemplate(template);
        return cache;
    }

}

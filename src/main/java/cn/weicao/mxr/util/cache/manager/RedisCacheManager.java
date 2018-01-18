package cn.weicao.mxr.util.cache.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import cn.weicao.mxr.util.cache.RedisCache;
import cn.weicao.mxr.util.cache.abs.AbstractRedisCache;

public class RedisCacheManager implements CacheManager {
	private final ConcurrentMap<String,Cache<Object,Object>> CACHES = new ConcurrentHashMap<>() ;
	private Map<String,JedisConnectionFactory> connectionFactoryMap ;
	@Override
	public Cache<Object, Object> getCache(String name) throws CacheException {
		Cache<Object,Object> cache = CACHES.get(name) ;
		if(cache == null) {
			AbstractRedisCache<Object, Object> abstractCache = null ;
			if("authenticationCache".equals(name)) {
				abstractCache = new RedisCache<Object,Object>() ;
				abstractCache.setConnectionFactory(this.connectionFactoryMap.get("authentication"));
			}else if("authorizationCache".equals(name)) {
				abstractCache = new RedisCache<Object,Object>() ;
				abstractCache.setConnectionFactory(this.connectionFactoryMap.get("authorization"));
			}else if("activeSessionCache".equals(name)) {
				abstractCache = new RedisCache<Object,Object>() ;
				abstractCache.setConnectionFactory(this.connectionFactoryMap.get("activeSessionCache"));
			}else if("retryCount".equals(name)) {
				abstractCache = new RedisCache<Object,Object>() ;
				abstractCache.setConnectionFactory(this.connectionFactoryMap.get("retryCount"));
			}else if("kickout".equals(name)) {
				abstractCache = new RedisCache<Object,Object>() ;
				abstractCache.setConnectionFactory(this.connectionFactoryMap.get("kickout"));
			}
			cache = abstractCache ;
		}
		return cache ;
	}
	public void setConnectionFactoryMap(Map<String,JedisConnectionFactory> connectionFactoryMap) {
		this.connectionFactoryMap = connectionFactoryMap ;
	}
}

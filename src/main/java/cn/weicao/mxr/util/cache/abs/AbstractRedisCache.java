package cn.weicao.mxr.util.cache.abs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.util.SerializationUtils;

public abstract class AbstractRedisCache<K,V> implements Cache<K,V> {
	private JedisConnectionFactory connectionFactory ; //定义一个Jedis连接工厂
	/**
	 * 由于RedisConnection的所有操作都是以字节数组的形式出现的，所以建议直接设置一个工具方法转换
	 * @param obj 要转换的任意对象
	 * @return 对象的字节数组
	 */
	protected byte[] objectToArray(Object obj) {
		return SerializationUtils.serialize(obj) ;
	}
	/**
	 * 将字节数组重新变为Object对象
	 * @param data 要转变的字节数组
	 * @return 目标处理对象
	 */
	protected Object byteArrayToObject(byte data[]) {
		return SerializationUtils.deserialize(data) ;
	}
	@Override
	public V get(K key) throws CacheException {
		V obj = null ;
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			obj = (V) this.byteArrayToObject(connection.get(this.objectToArray(key))) ;
		}catch(Exception e) {}
		connection.close();
		return obj ;
	}
	@Override
	public V put(K key, V value) throws CacheException {
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			connection.set(this.objectToArray(key), this.objectToArray(value));
		}catch(Exception e) {}
		connection.close();
		return value ;
	}
	public V putEx(K key,Long expire,V value) throws CacheException{
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			connection.setEx(this.objectToArray(key), expire, this.objectToArray(value));
		}catch(Exception e) {}
		connection.close();
		return value ;
	}
	public V putEx(K key,String expire,V value) throws CacheException{
		return this.putEx(key, Long.parseLong(expire), value) ;
	}
	@Override
	public V remove(K key) throws CacheException {
		V obj = null ;
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			obj = (V) this.byteArrayToObject(connection.get(this.objectToArray(key))) ;
			connection.del(this.objectToArray(key)) ;
		}catch(Exception e) {}
		connection.close();
		return obj ;
	}
	@Override
	public void clear() throws CacheException {
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			connection.flushDb();
		}catch(Exception e) {}
		connection.close() ;
	}
	@Override
	public int size() {
		int size = 0 ;
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			Set<byte[]> keys = connection.keys(this.objectToArray("*")) ;
			size = keys.size() ;
		}catch(Exception e) {}
		connection.close();
		return size ;
	}
	public Set<K> keys() {
		Set<K> allKeys = new HashSet<K>() ;
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			Set<byte[]> keys = connection.keys(this.objectToArray("*")) ;
			for(byte[] key : keys) {
				allKeys.add((K)this.byteArrayToObject(key)) ;
			}
		}catch(Exception e) {}
		connection.close();
		return allKeys ;
	}
	@Override
	public Collection<V> values() {
		Set<V> allValues = new HashSet<V>() ;
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			Set<byte[]> keys = connection.keys(this.objectToArray("*")) ;
			for(byte[] key : keys) {
				allValues.add((V)this.byteArrayToObject(connection.get(key))) ;
			}
		}catch(Exception e) {}
		connection.close();
		return allValues ;
	}
	public void setConnectionFactory(JedisConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory ;
	}
}

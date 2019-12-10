package com.app.redis.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ConditionalOnClass({JedisCluster.class})
public class JedisClusterConfig extends CachingConfigurerSupport{

	@Autowired
	private RedisProperties redisProperties;

	@Bean
	public JedisCluster getJedisCluster() {
		String[] serverArray = {redisProperties.getIp1() + ":" + redisProperties.getHost1(), redisProperties.getIp2() + ":" + redisProperties.getHost2()
								, redisProperties.getIp3() + ":" + redisProperties.getHost3(), redisProperties.getIp4() + ":" + redisProperties.getHost4()
								, redisProperties.getIp5() + ":" + redisProperties.getHost5(), redisProperties.getIp6() + ":" + redisProperties.getHost6()};
		Set<HostAndPort> nodes = new HashSet<>();

		for (String ipPort : serverArray) {
			if(StringUtils.isNotBlank(ipPort)){
				String[] ipPortPair = ipPort.split(":");
				if(StringUtils.isNotBlank(ipPortPair[0]) && StringUtils.isNotBlank(ipPortPair[1])){
					nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
				}
			}
		}
		if(nodes.size() > 0){
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			jedisPoolConfig.setMaxIdle(200);//最大空闲连接数
			jedisPoolConfig.setMinIdle(20);//最小空闲连接数
			jedisPoolConfig.setMaxTotal(400);//最大连接数
			jedisPoolConfig.setBlockWhenExhausted(true);
			jedisPoolConfig.setTestOnBorrow(true);
			//Idle时进行连接扫描
			jedisPoolConfig.setTestWhileIdle(true);
			//表示idle object evitor每次扫描的最多的对象数
			jedisPoolConfig.setNumTestsPerEvictionRun(10);
			//表示idle object evitor两次扫描之间要sleep的毫秒数
			jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000);
			//表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
			jedisPoolConfig.setMinEvictableIdleTimeMillis(60000);
			jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(60000);
			jedisPoolConfig.setMaxWaitMillis(100000);//最大阻塞等待时间，负值为无限制
			return new JedisCluster(nodes, redisProperties.getCommandTimeout(), 5000, 3, jedisPoolConfig);
		}else{
			return null;
		}
	}
	
	/**
	 * 管理缓存
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(600); //设置key-value超时时间，时间单位是秒。
		return cacheManager;
	}

	@Bean
	@Override
	public CacheErrorHandler errorHandler() {
		// 异常处理，当Redis发生异常时，打印日志，但是程序正常
		CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
			@Override
			public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
				System.out.println(e);
			}

			@Override
			public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
				System.out.println(e);
			}

			@Override
			public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
				System.out.println(e);
			}

			@Override
			public void handleCacheClearError(RuntimeException e, Cache cache) {
				System.out.println(e);
			}
		};
		return cacheErrorHandler;
	}
}
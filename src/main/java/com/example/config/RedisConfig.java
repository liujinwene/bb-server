package com.example.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
//	@Bean  
//	public KeyGenerator wiselyKeyGenerator(){ 
//		return new KeyGenerator() {
//			@Override
//			public Object generate(Object target, Method method, Object... params) {  
//				StringBuilder sb = new StringBuilder();  
//				sb.append(target.getClass().getName());  
//				sb.append(method.getName());  
//				for (Object obj : params) {  
//					sb.append(obj.toString());  
//				}  
//				return sb.toString();  
//			}  
//		};  
//
//	}  

	@Bean  
	public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {  
		return new RedisCacheManager(redisTemplate);  
	}  

	@Bean  
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {  
		StringRedisTemplate template = new StringRedisTemplate(factory);
		setRedisSerializer(template);
		return template;  
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setRedisSerializer(StringRedisTemplate template) {
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);  
		ObjectMapper om = new ObjectMapper();  
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
		jackson2JsonRedisSerializer.setObjectMapper(om);  
		
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer2 = new Jackson2JsonRedisSerializer(Object.class);  
		ObjectMapper om2 = new ObjectMapper();  
		om2.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
		om2.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
		jackson2JsonRedisSerializer2.setObjectMapper(om2);  
		
		template.setKeySerializer(jackson2JsonRedisSerializer2);
		template.setValueSerializer(jackson2JsonRedisSerializer);  
		template.afterPropertiesSet();  
	} 

}

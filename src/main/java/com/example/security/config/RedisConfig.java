//package com.example.security.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//@Configuration
//@EnableRedisRepositories
//public class RedisConfig {
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        try {
//            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//            redisStandaloneConfiguration.setHostName("127.0.0.1");
//            redisStandaloneConfiguration.setPort(6379);
//
//            JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
//            return jedisConnectionFactory;
//        } catch (Exception e) {
//            // Handle exceptions or log an error.
//            throw new RuntimeException("Error creating JedisConnectionFactory", e);
//        }
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        try {
//            RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//            redisTemplate.setConnectionFactory(jedisConnectionFactory());
//            redisTemplate.setKeySerializer(new StringRedisSerializer());
//            redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//            redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
//            redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//            redisTemplate.setEnableTransactionSupport(true);
//            redisTemplate.afterPropertiesSet();
//            return redisTemplate;
//        } catch (Exception e) {
//            // Handle exceptions or log an error.
//            throw new RuntimeException("Error creating RedisTemplate", e);
//        }
//    }
//}

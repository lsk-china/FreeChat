package com.lsk.freechat.backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import javax.annotation.Resource;

/**
 * Redis Configuration
 * Use Jedis to connect redis
 */
@Configuration
public class RedisConfiguration {

    @Resource
    private RedisConnectionProperties properties;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setDatabase(properties.getDatabase());
        configuration.setPassword(properties.getPassword());
        configuration.setHostName(properties.getHost());
        configuration.setPort(properties.getPort());
        return new JedisConnectionFactory(configuration);
    }

    /**
     * Used to map spring.redis.* configurations from application.yml
     */
    @Data
    @Configuration
    @ConfigurationProperties("spring.redis")
    public static class RedisConnectionProperties {
        /**
         * Redis database index
         */
        private Integer database;

        /**
         * Redis password
         */
        private String password;

        /**
         * Redis host, localhost by default
         */
        private String host = "localhost";

        /**
         * Redis port, 6379 by default
         */
        private Integer port = 6379;
    }
}

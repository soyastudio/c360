package com.c360.doctc360api.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.redis.cache")
@Setter
@Getter
public class ApplicationProperties {
    private String host;
    private String port;
    private String password;
    private String redisSwitch;
    private int ttl;

}

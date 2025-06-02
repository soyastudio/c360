package com.c360.doctc360api.configuration;


import com.c360.doctc360api.model.C360CustomerDataModel;
import com.c360.doctc360api.model.bnc.BncTransactionDataModel;
import com.c360.doctc360api.model.v2.CustomerProfileResponse;
import com.fasterxml.jackson.databind.JsonNode;
import io.lettuce.core.ClientOptions;
import io.lettuce.core.ReadFrom;
import io.lettuce.core.protocol.ProtocolVersion;
import org.apache.commons.pool2.BaseObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfigStandalone {

    @Value("${spring.redis.cache.host}")
    private String redisHost;

    @Value("${spring.redis.cache.port}")
    private int redisPort;
/*

    @Value("${spring.redis.cache.password}")
    private String redisPassword;

    @Value("${spring.redis.cache.ssl}")
    private String ssl;
    @Value("${spring.redis.cache.cluster.nodes}")
    private String clusterNodes;

    @Value("${spring.redis.cache.cluster.max-redirects}")
    private int maxRedirects;

    @Value("${spring.redis.cache.redisSwitch}")
    private String flag;
*/

    @Bean
    @ConditionalOnProperty(name = "spring.redis.cache.redisSwitch", havingValue = "ON")
    protected GenericObjectPoolConfig<BaseObject> poolConfig() {
        GenericObjectPoolConfig<BaseObject> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxTotal(3);
        poolConfig.setMaxIdle(2);
        poolConfig.setMinIdle(1);
        poolConfig.setTimeBetweenEvictionRuns(Duration.ofMinutes(10));
        poolConfig.setJmxNamePrefix("OFFER_DETAILS_REDIS");
        return poolConfig;
    }

    @Bean
    @ConditionalOnProperty(name = "spring.redis.cache.redisSwitch", havingValue = "ON")
    public ClientOptions clientOptions() {

        return ClientOptions.builder()
                .protocolVersion(ProtocolVersion.RESP3)
                .pingBeforeActivateConnection(true)
                .disconnectedBehavior(ClientOptions.DisconnectedBehavior.REJECT_COMMANDS)
                .build();
    }
    @Bean
    @ConditionalOnProperty(name = "spring.redis.cache.redisSwitch", havingValue = "ON")
    public LettuceConnectionFactory redisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisHost);
        redisStandaloneConfiguration.setPort(redisPort);
        //redisStandaloneConfiguration.setPassword(redisPassword);
        LettucePoolingClientConfiguration lc = LettucePoolingClientConfiguration.builder()
               // .clientOptions(clientOptions())
                .poolConfig(poolConfig())
                .readFrom(ReadFrom.REPLICA_PREFERRED)
                .commandTimeout(Duration.ofMillis(50000))
                .useSsl()
                .disablePeerVerification()
                .build();
        //redisStandaloneConfiguration
        return new LettuceConnectionFactory(redisStandaloneConfiguration,lc);
    }

    @Bean
    @ConditionalOnProperty(name = "spring.redis.cache.redisSwitch", havingValue = "ON")
    @Primary
    public ReactiveRedisOperations<String, C360CustomerDataModel> redisOperationsForMealPreferences(
            LettuceConnectionFactory redisConnectionFactory) {
        Jackson2JsonRedisSerializer<C360CustomerDataModel> serializer = new Jackson2JsonRedisSerializer<>(C360CustomerDataModel.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, C360CustomerDataModel> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        RedisSerializationContext<String, C360CustomerDataModel> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(redisConnectionFactory, context);
    }
    private RedisNode redisSslNode() {
        return new RedisNode(redisHost, redisPort);
    }

    @Bean
    @ConditionalOnProperty(name = "spring.redis.cache.redisSwitch", havingValue = "ON")
    @Primary
    public ReactiveRedisOperations<String, CustomerProfileResponse> redisOperationsForCustomerProfile(
            LettuceConnectionFactory redisConnectionFactory) {
        Jackson2JsonRedisSerializer<CustomerProfileResponse> serializer = new Jackson2JsonRedisSerializer<>(CustomerProfileResponse.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, CustomerProfileResponse> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        RedisSerializationContext<String, CustomerProfileResponse> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(redisConnectionFactory, context);
    }

    @Bean
    @ConditionalOnProperty(name = "spring.redis.cache.redisSwitch", havingValue = "ON")
    @Primary
    public ReactiveRedisOperations<String, BncTransactionDataModel> redisOperationsForFulfillmentApi(
            LettuceConnectionFactory redisConnectionFactory) {
        Jackson2JsonRedisSerializer<BncTransactionDataModel> serializer = new Jackson2JsonRedisSerializer<>(BncTransactionDataModel.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, BncTransactionDataModel> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        RedisSerializationContext<String, BncTransactionDataModel> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(redisConnectionFactory, context);
    }

    @Bean
    @ConditionalOnProperty(name = "spring.redis.cache.redisSwitch", havingValue = "ON")
    @Primary
    public ReactiveRedisOperations<String, JsonNode> redisOperationsForCatalogApi(
            LettuceConnectionFactory redisConnectionFactory) {
        Jackson2JsonRedisSerializer<JsonNode> serializer = new Jackson2JsonRedisSerializer<>(JsonNode.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, JsonNode> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        RedisSerializationContext<String, JsonNode> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(redisConnectionFactory, context);
    }

}



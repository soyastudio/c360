package com.c360.doctc360api.configuration;


import com.mongodb.ReadPreference;
import com.mongodb.reactivestreams.client.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;


@Configuration
public class MongoConfig {

    private static final Logger logger = LoggerFactory.getLogger(MongoConfig.class);

    @Value("${spring.data.mongodb.readPreference}")
    private String readPreference;


    @Bean
    @Primary
    public ReactiveMongoTemplate reactiveMongoTemplate(@Value("${spring.data.mongodb.database}") String databaseName,
                                                       @Autowired MongoClient mongoClient) {

        ReactiveMongoTemplate reactiveMongoTemplate = null;
            try {
                reactiveMongoTemplate = new ReactiveMongoTemplate(mongoClient, databaseName);
                if (ReadPreference.secondaryPreferred().getName().equalsIgnoreCase(readPreference)) {
                    reactiveMongoTemplate.setReadPreference(ReadPreference.secondaryPreferred());
                } else if (ReadPreference.primaryPreferred().getName().equalsIgnoreCase(readPreference)) {
                    reactiveMongoTemplate.setReadPreference(ReadPreference.primaryPreferred());
                } else {
                    reactiveMongoTemplate.setReadPreference(ReadPreference.nearest());
                }

            } catch(Exception e){
                logger.error("MongoDb Connection error:-->"+e.getLocalizedMessage());
           }
            return reactiveMongoTemplate;

    }
}

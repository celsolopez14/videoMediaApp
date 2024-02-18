package com.videomedia.videoappbackend.config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {
    @Value("${application.databaseName}")
    private String databaseName;

    @Value("${application.databaseClient}")
    private String databaseClient;


    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create(databaseClient);
    }

    @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

}

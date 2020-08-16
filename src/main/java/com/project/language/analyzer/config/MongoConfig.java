package com.project.language.analyzer.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongo:27017");
    }

    @Override
    protected String getDatabaseName() {
        return "analysis";
    }

}

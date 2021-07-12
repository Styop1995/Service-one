package com.mudigal.one.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Profile("default")
@Configuration
public class ReactiveMongoConfiguration
    extends AbstractReactiveMongoConfiguration {

  @Bean
  public ReactiveMongoTemplate mongoTemplate() {
    return new ReactiveMongoTemplate(
        reactiveMongoClient(), getDatabaseName());
  }

  @Override
  public MongoClient reactiveMongoClient() {
    return MongoClients.create("mongodb://admin:admin@3.137.153.129:27017");
  }

  @Override
  protected String getDatabaseName() {
    return "service_one";
  }
}
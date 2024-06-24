package com.example.challenge4.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

public class KafkaTopicConfig {
    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name("test-send").build();
    }
}

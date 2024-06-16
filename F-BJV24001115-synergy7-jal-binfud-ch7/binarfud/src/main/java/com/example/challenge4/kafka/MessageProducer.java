package com.example.challenge4.kafka;

import com.example.challenge4.dto.auth.register.RegisterUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String otp){
        kafkaTemplate.send(topic, otp);
    }
}

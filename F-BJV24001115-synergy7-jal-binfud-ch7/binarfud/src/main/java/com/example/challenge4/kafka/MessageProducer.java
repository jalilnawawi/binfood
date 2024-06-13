package com.example.challenge4.kafka;

import com.example.challenge4.dto.users.MailOtpDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    @Autowired
    KafkaTemplate<String, MailOtpDto> kafkaTemplate;

    public void sendMessage(String topic, MailOtpDto mailOtpDto){
        kafkaTemplate.send(topic, mailOtpDto);
    }
}

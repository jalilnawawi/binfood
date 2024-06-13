package com.example.challenge4.kafka.controller;

import com.example.challenge4.dto.users.MailOtpDto;
import com.example.challenge4.kafka.MessageProducer;
import com.example.challenge4.model.accounts.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    MessageProducer messageProducer;

    private static final String topic = "testTopic";

    @PostMapping("/sendUser")
    public String sendUser(@RequestBody MailOtpDto mailOtpDto){
        messageProducer.sendMessage(topic, mailOtpDto);
        return "send otp";
    }
}

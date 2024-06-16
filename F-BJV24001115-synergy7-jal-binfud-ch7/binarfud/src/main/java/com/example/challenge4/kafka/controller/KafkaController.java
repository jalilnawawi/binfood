package com.example.challenge4.kafka.controller;

import com.example.challenge4.dto.users.MailOtpDto;
import com.example.challenge4.kafka.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    MessageProducer messageProducer;

    private static final String topic = "testTopic";

    @PostMapping("/sendUser")
    public String sendUser(@RequestBody String otp){
        messageProducer.sendMessage(topic, otp);
        return "send otp " + otp;
    }
}

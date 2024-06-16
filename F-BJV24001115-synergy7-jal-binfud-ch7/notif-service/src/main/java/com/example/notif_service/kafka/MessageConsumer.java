package com.example.notif_service.kafka;

import com.example.notif_service.dto.MailOtpDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "testTopic", groupId = "mail-otp-id")
    public void sendMessage(String otp){
        System.out.println("Message received your OTP : " + otp);
    }
}

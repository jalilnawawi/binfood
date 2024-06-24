package com.example.challenge4.kafka;

import com.example.challenge4.dto.auth.register.RegisterUserRequestDto;
import com.example.challenge4.security.service.register.RegisServiceImpl;
import com.example.challenge4.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    MailService mailService;

    @Autowired
    RegisServiceImpl regisService;

    public void sendMessage(String topic, RegisterUserRequestDto registerUserRequestDto){
        String otp = regisService.generateOtp();
        registerUserRequestDto.setOtp(otp);
        kafkaTemplate.send(topic, otp);

        mailService.sendMail(
                registerUserRequestDto.getEmail(),
                "Activate your account",
                "Don't share this OTP " + otp
        );
    }
}

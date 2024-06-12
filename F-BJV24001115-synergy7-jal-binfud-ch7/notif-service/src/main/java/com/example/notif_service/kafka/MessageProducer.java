package com.example.notif_service.kafka;

//import com.example.challenge4.model.accounts.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String theMessage){
        kafkaTemplate.send(topic, theMessage);
    }

//    public void sendMessage(String topic, Users user){
//        kafkaTemplate.send(topic, user.getOtp());
//    }
}

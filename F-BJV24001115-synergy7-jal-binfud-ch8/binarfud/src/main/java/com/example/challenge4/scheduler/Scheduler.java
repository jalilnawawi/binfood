package com.example.challenge4.scheduler;

import com.example.challenge4.fcm.dto.NotificationRequest;
import com.example.challenge4.fcm.service.FCMService;
import com.example.challenge4.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class Scheduler {
    @Autowired
    MailService mailService;

    @Autowired
    FCMService fcmService;

    @Scheduled(cron = "0 0 12 * * *")
    public void send() throws ExecutionException, InterruptedException {
        NotificationRequest request = new NotificationRequest();
        request.setTitle("Promo Binarfud Siang Panas");
        request.setBody("Diskon 20% untuk setiap pembelian Kopi pada pukul 12.00");
        request.setToken("cugAUxyLgT_pqGBKVHpATR:APA91bE825BQzAnpwdbK4eqzlJaA7QFhnqWo0Rb8GWRR2PTJD80E8p4veqJVwoMjGuaB6FoSfSI8fCtFr6ZyDIJOfuWdQ08fTrOTdUwd08zMrfnGAg0ewLkFybLhedUBlxW2P-b--XSU");
        fcmService.sendMessageToToken(request);
    }

}

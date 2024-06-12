package com.example.notif_service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "send-otp-service", url = "http://localhost:8081", path = "/send-otp-service")
public interface OtpClient {
}

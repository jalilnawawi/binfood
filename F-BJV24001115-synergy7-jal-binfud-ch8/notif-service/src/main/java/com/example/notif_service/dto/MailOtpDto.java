package com.example.notif_service.dto;

import lombok.Data;

@Data
public class MailOtpDto {
    private String email;
    private String otp;

    public MailOtpDto(){}

    public MailOtpDto(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}

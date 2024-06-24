package com.example.challenge4.dto.auth.login;

import lombok.Data;

import java.util.List;

@Data
public class LoginResponseDto {
    private String token;
    private String type = "Bearer";
    private String username;
    private boolean isActive = Boolean.TRUE;

    public LoginResponseDto(String token, String username, boolean isActive) {
        this.token = token;
        this.username = username;
        this.isActive = isActive;
    }
}

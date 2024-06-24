package com.example.challenge4.service;

import com.example.challenge4.dto.auth.login.LoginRequestDto;
import com.example.challenge4.dto.auth.login.TokenResponse;

public interface AuthService {
    TokenResponse login(LoginRequestDto loginRequestDto);
}

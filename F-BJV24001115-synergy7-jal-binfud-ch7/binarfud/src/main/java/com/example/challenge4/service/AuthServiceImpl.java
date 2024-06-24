package com.example.challenge4.service;

import com.example.challenge4.dto.auth.login.LoginRequestDto;
import com.example.challenge4.dto.auth.login.TokenResponse;
import com.example.challenge4.model.accounts.Users;
import com.example.challenge4.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public TokenResponse login(LoginRequestDto loginRequestDto) {
        Users user = usersRepository.findByUsername(loginRequestDto.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong"));

        if (BCrypt.checkpw(loginRequestDto.getPassword(), user.getPassword())){
            
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong");
        }
        return null;
    }
}

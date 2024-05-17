package com.example.challenge4.dto.users;

import lombok.Data;

@Data
public class UsersCreateRequestDto {
    private String username;
    private String email;
    private String password;
}

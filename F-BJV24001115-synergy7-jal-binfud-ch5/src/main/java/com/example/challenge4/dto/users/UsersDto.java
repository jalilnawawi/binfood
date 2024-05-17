package com.example.challenge4.dto.users;

import lombok.Data;

import java.util.UUID;

@Data
public class UsersDto {
    private UUID id;
    private String username;
    private String emailAddress;
    private String password;
    private boolean deleted;
}

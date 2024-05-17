package com.example.challenge4.service;

import com.example.challenge4.dto.users.UsersCreateRequestDto;
import com.example.challenge4.dto.users.UsersDeleteRequestDto;
import com.example.challenge4.dto.users.UsersDto;
import com.example.challenge4.dto.users.UsersUpdatePasswordRequsetDto;
import com.example.challenge4.model.Users;

import java.util.List;
import java.util.UUID;

public interface UsersService {
    List<Users> getAll();

    Users getUserById(UUID userId);

    UsersDto create(UsersCreateRequestDto usersCreateRequestDto);

    UsersDto update(UUID userId, UsersUpdatePasswordRequsetDto usersUpdatePasswordRequsetDto);

    UsersDto delete(UUID userId, UsersDeleteRequestDto usersDeleteRequestDto);
}

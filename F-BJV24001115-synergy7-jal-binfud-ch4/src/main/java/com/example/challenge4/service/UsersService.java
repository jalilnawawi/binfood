package com.example.challenge4.service;

import com.example.challenge4.model.Users;

import java.util.List;
import java.util.UUID;

public interface UsersService {
    void createUserByProcedure(String username, String email, String password);
    List<Users> showUser();
    void updateUserByProcedure(UUID id, String username, String email, String password);
    void deleteUserByProcedure(UUID id);
    Users getUserByUsername(String username);
}

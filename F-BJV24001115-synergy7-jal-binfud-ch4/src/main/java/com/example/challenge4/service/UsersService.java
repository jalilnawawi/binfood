package com.example.challenge4.service;

import com.example.challenge4.model.Users;

import java.util.List;
import java.util.UUID;

public interface UsersService {
    Users createUser(Users users);

    void createUserByProcedure(String username, String email, String password);
    List<Users> showUserByProcedure();
    void updateUserByProcedure(UUID id, String username, String email, String password);
}

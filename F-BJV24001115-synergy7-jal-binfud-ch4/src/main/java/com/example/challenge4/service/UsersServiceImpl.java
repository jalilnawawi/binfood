package com.example.challenge4.service;

import com.example.challenge4.model.Users;
import com.example.challenge4.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService{
    @Autowired
    UserRepository userRepository;

    @Override
    public Users createUser(Users user) {
        user = userRepository.save(user);
        return user;
    }

    @Override
    public void createUserByProcedure(String username, String email, String password) {
        userRepository.usersInsertData(username,email,password);
    }

    @Override
    public List<Users> showUserByProcedure() {
        return userRepository.usersSelectData();
    }

    @Override
    public void updateUserByProcedure(UUID id, String username, String email, String password) {
        userRepository.usersUpdateData(id, username, email, password);
    }
}

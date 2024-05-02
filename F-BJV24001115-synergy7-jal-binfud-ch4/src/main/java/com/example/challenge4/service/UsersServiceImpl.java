package com.example.challenge4.service;

import com.example.challenge4.model.Users;
import com.example.challenge4.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

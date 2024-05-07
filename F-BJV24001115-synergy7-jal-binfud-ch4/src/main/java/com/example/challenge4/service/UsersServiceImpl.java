package com.example.challenge4.service;

import com.example.challenge4.model.Users;
import com.example.challenge4.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService{
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUserByProcedure(String username, String email, String password) {
        userRepository.usersInsertData(username,email,password);
    }


    @Override
    public List<Users> showUser() {
        return userRepository.findAll();
    }

    @Override
    public void updateUserByProcedure(UUID id, String username, String email, String password) {
        userRepository.usersUpdateData(id, username, email, password);
    }

    @Override
    public void deleteUserByProcedure(UUID id) {
        userRepository.usersDeleteData(id);
    }

    @Override
    public Users getUserByUsername(String username) {
        Optional<Users> usersOptional = userRepository.findByUsername(username);
        return  usersOptional.get();
    }

    @Override
    public List<Users> getAllUsersPageable(String username, int page, int amount) {
        Pageable pageable = PageRequest.of(page-1, amount, Sort.by("username"));
        return userRepository.findByUsernameLike(username, pageable);
    }
}

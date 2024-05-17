package com.example.challenge4.service;

import com.example.challenge4.dto.users.UsersCreateRequestDto;
import com.example.challenge4.dto.users.UsersDeleteRequestDto;
import com.example.challenge4.dto.users.UsersDto;
import com.example.challenge4.dto.users.UsersUpdatePasswordRequsetDto;
import com.example.challenge4.model.Users;
import com.example.challenge4.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(UUID userId) {
        Optional<Users> usersOptional = usersRepository.findById(userId);
        return usersOptional.get();
    }

    @Override
    public UsersDto create(UsersCreateRequestDto usersCreateRequestDto) {
        Users user = new Users();
        user.setUsername(usersCreateRequestDto.getUsername());
        user.setEmailAddress(usersCreateRequestDto.getEmail());
        user.setPassword(usersCreateRequestDto.getPassword());
        usersRepository.save(user);

        return modelMapper.map(user, UsersDto.class);
    }

    @Override
    public UsersDto update(UUID userId, UsersUpdatePasswordRequsetDto usersUpdatePasswordRequsetDto) {
        Users user = usersRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User dengan Id " + userId + "tidak ditemukan")
        );

        user.setPassword(usersUpdatePasswordRequsetDto.getPassword());
        usersRepository.save(user);
        return modelMapper.map(user, UsersDto.class);
    }

    @Override
    public UsersDto delete(UUID userId, UsersDeleteRequestDto usersDeleteRequestDto) {
        Users user = usersRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User dengan Id " + userId + "tidak ditemukan")
        );

        user.setDeleted(usersDeleteRequestDto.isDeleted());
        usersRepository.save(user);
        return modelMapper.map(user, UsersDto.class);
    }


}

package com.example.challenge4.controller;

import com.example.challenge4.model.Users;
import com.example.challenge4.service.UsersService;
import com.example.challenge4.view.UsersView;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
@Slf4j
public class UserController {
    @Autowired
    UsersService usersService;

    UsersView usersView = new UsersView();

    public void mainMenu() {
        createUser();
    }

    public void createUser(){
        System.out.println("Silahkan isi form");

        Users user = new Users();
        Scanner scanner = new Scanner(System.in);
        usersView.displayInputUsername();
        String username = scanner.nextLine();

        usersView.displayInputEmail();
        String email = scanner.nextLine();

        usersView.displayInputPassword();
        String password = scanner.nextLine();

        user.setUsername(username);
        user.setEmailAddress(email);
        user.setPassword(password);

        usersService.createUser(user);
        System.out.println(user.getId() + " | " + user.getUsername());

    }


}

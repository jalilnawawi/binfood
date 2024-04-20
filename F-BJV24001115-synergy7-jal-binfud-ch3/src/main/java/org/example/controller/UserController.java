package org.example.controller;

import org.example.Data;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.example.view.UserView;

import java.util.Scanner;

public class UserController {
    public void userLogin(){
        Data.initiateUsers();
        UserView userView = new UserView();
        userView.displayUserViewHeader();
        userView.displayInputUsernameView();
        Scanner input = new Scanner(System.in);
        String inputUserName = input.next();

        UserService userService = new UserServiceImpl();
        userService.loginByUserName(inputUserName);
    }
}

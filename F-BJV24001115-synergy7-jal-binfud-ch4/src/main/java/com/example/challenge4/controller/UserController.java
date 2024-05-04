package com.example.challenge4.controller;

import com.example.challenge4.model.Users;
import com.example.challenge4.service.UsersService;
import com.example.challenge4.view.UsersView;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
@Slf4j
public class UserController {
    @Autowired
    UsersService usersService;

    UsersView usersView = new UsersView();

    public void mainMenu() {
//        createUser();
        showUsers();
//        updateUsers();
//        deleteUser();
//        getUserByUsername();
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

        usersService.createUserByProcedure(username,email,password);
        System.out.println("Welcome " + user.getUsername());
    }

    public void showUsers(){
        List<Users> usersList = usersService.showUser();
        usersList.forEach(user -> System.out.println(
                user.getUsername() + " | " + user.getEmailAddress()
        ));
    }

    public void updateUsers(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id = ");
        String id = scanner.nextLine();

        usersView.displayInputUsername();
        String username = scanner.nextLine();

        usersView.displayInputEmail();
        String email = scanner.nextLine();

        usersView.displayInputPassword();
        String password = scanner.nextLine();

        usersService.updateUserByProcedure(UUID.fromString(id), username, email, password);
        System.out.println(username + " with id = " + id + " successfully updated");
    }

    public void deleteUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id = ");
        String id = scanner.nextLine();

        usersService.deleteUserByProcedure(UUID.fromString(id));
        System.out.println("user dengan id = " + id + " berhasil dihapus!");
    }

    String getUserByUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input username = ");
        String username = scanner.nextLine();
        return username;
    }
}
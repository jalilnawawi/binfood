package org.example.service;

import org.example.Data;
import org.example.model.Users;

import java.util.List;

public class UserServiceImpl implements UserService{
    List<Users> usersList = Data.usersList;

    @Override
    public String loginByUserName(String inputUserName) {

        if (inputUserName.equalsIgnoreCase("user1")){
            System.out.println("Selamat berbelanja " + inputUserName);
        } else if (inputUserName.equalsIgnoreCase("user2")) {
            System.out.println("Selamat berbelanja " + inputUserName);
        } else if (inputUserName.equalsIgnoreCase("user3")) {
            System.out.println("Selamat berbelanja " + inputUserName);
        } else {
            System.out.println("Input sesuai username yang tersedia!!!");
            System.exit(1);
        }

        return inputUserName;

    }
}

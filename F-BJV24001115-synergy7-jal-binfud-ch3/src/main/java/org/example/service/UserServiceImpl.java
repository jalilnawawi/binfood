package org.example.service;

import org.example.Data;
import org.example.model.Users;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Override
    public String loginByUserName(String inputUserName) {

        if (inputUserName.equalsIgnoreCase("user1")){
            System.out.println("Selamat berbelanja " + inputUserName + "\n");
        } else if (inputUserName.equalsIgnoreCase("user2")) {
            System.out.println("Selamat berbelanja " + inputUserName + "\n");
        } else if (inputUserName.equalsIgnoreCase("user3")) {
            System.out.println("Selamat berbelanja " + inputUserName + "\n");
        } else {
            throw new NullRequestException(
                    "\n============================\n"
                            + "User tidak ditemukan!\n"
                            + "============================\n"
            );
        }

        return inputUserName;

    }
}

package org.example.view;

import org.example.Data;
import org.example.model.Users;

import java.util.List;
import java.util.stream.Collectors;

public class UserView {
    List<Users> usersList = Data.usersList;
    public void displayUserViewHeader(){
        System.out.println("Berikut daftar username yang bisa digunakan");
        List<String> userNameList = usersList.stream()
                        .map(Users::getUserName).collect(Collectors.toList());
        userNameList.forEach(System.out::println);
    }

    public void displayInputUsernameView(){
        System.out.print("Pilih Username : ");
    }
}

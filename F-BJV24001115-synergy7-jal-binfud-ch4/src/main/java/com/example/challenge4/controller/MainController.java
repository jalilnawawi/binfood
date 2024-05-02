package com.example.challenge4.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MainController {
    @Autowired
    MerchantController merchantController;

    @Autowired
    ProductController productController;

    @Autowired
    UserController userController;

    public void mainController(){
//        merchantController.mainMenu();
//        productController.mainMenu();
          userController.mainMenu();
    }
}

package com.example.challenge4.controller;

import com.example.challenge4.repository.ProductRepository;
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

    public void mainController(){
//        merchantController.mainMenu();
        productController.mainMenu();
    }
}

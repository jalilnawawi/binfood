package com.example.challenge4.controller;

import com.example.challenge4.model.*;
import com.example.challenge4.service.ProductService;
import com.example.challenge4.service.UsersService;
import com.example.challenge4.view.OrderDetailView;
import com.example.challenge4.view.UsersView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
@Slf4j
public class MainController {
    @Autowired
    MerchantController merchantController;

    @Autowired
    ProductController productController;

    @Autowired
    UserController userController;

    @Autowired
    UsersService usersService;

    @Autowired
    OrderController orderController;

    @Autowired
    OrderDetailController orderDetailController;

    @Autowired
    ProductService productService;

    UsersView usersView = new UsersView();
    OrderDetailView orderDetailView = new OrderDetailView();

    Users user;
    Merchant merchant;
    Product selectedProduct;
    Map<Long, OrderDetail> orderDetailMap = new HashMap<>();

    public void mainController(){
//        userController.mainMenu();
//        orderController.mainMenu();
//        merchantController.mainMenu();
//        productController.mainMenu();
        orderDetailController.mainMenu();
    }
}
